package com.bootdo.common.controller;

import com.bootdo.common.config.BootdoConfig;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.AttatchmentService;
import com.bootdo.common.service.FileService;
import com.bootdo.common.utils.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 文件上传
 * 
 * @author chglee
 * @email 1992lcg@163.com
 * @date 2017-09-19 16:02:20
 */
@Controller
@RequestMapping("/common/sysFile")
public class FileController extends BaseController {

	@Autowired
	private FileService sysFileService;

	@Autowired
	private AttatchmentService attatchmentService;

	@Autowired
	private BootdoConfig bootdoConfig;

	@GetMapping()
	@RequiresPermissions("common:sysFile:sysFile")
	String sysFile(Model model) {
		return "common/file/file";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:sysFile:sysFile")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<FileDO> sysFileList = sysFileService.list(query);
		int total = sysFileService.count(query);
		PageUtils pageUtils = new PageUtils(sysFileList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	// @RequiresPermissions("common:bComments")
	String add() {
		return "common/sysFile/add";
	}

	@GetMapping("/edit")
	// @RequiresPermissions("common:bComments")
	String edit(Long id, Model model) {
		FileDO sysFile = sysFileService.get(id);
		model.addAttribute("sysFile", sysFile);
		return "common/sysFile/edit";
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("common:info")
	public R info(@PathVariable("id") Long id) {
		FileDO sysFile = sysFileService.get(id);
		return R.ok().put("sysFile", sysFile);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:save")
	public R save(FileDO sysFile) {
		if (sysFileService.save(sysFile) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("common:update")
	public R update(@RequestBody FileDO sysFile) {
		sysFileService.update(sysFile);

		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("common:remove")
	public R remove(Long id, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		FileDO fileDO = sysFileService.get(id);
		String fileName = bootdoConfig.getUploadPath() + fileDO.getUrl();
		int ret = sysFileService.remove(id);
		if (ret > 0) {
			attatchmentService.removeByFid(id);
			boolean b = FileUtil.deleteFile(fileName);
			if (!b) {
				return R.error("数据库记录删除成功，文件删除失败");
			}
			return R.ok();
		} else {
			return R.error();
		}
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:remove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		sysFileService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@PostMapping("/upload")
	R upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		String originalFilename = file.getOriginalFilename();
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);
		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/" + fileName, new Date(),originalFilename);
		try {
			FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
		} catch (Exception e) {
			return R.error();
		}

		if (sysFileService.save(sysFile) > 0) {
			return R.ok().put("fileName",sysFile.getUrl()).put("fid", sysFile.getId()).put("originalName", originalFilename);
		}
		return R.error();
	}

	@ResponseBody
	@GetMapping("/download/{fid}")
	public void download(@PathVariable("fid") Long fid,HttpServletRequest request, HttpServletResponse response) {
		FileDO sysFile = sysFileService.get(fid);
		String fURL = bootdoConfig.getUploadPath()+sysFile.getUrl();
		File downloadFile = new File(fURL);
		 ServletContext context = request.getServletContext();  
		  
	        // get MIME type of the file  
	        String mimeType = context.getMimeType(fURL);  
	        if (mimeType == null) {  
	            // set to binary type if MIME mapping not found  
	            mimeType = "application/octet-stream";  
	            System.out.println("context getMimeType is null");  
	        }  
	        System.out.println("MIME type: " + mimeType);  
	  
	        // set content attributes for the response  
	        response.setContentType(mimeType);  
	        response.setContentLength((int) downloadFile.length());  
	  
	        // set headers for the response  
	        String headerKey = "Content-Disposition";  
	        String headerValue;
	        String fileName = sysFile.getOriginalName();
	        String header = request.getHeader("User-Agent").toUpperCase();
	        


			try {
				if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
		            fileName = URLEncoder.encode(fileName, "utf-8");
		            fileName = fileName.replace("+", "%20");    //IE下载文件名空格变+号问题
		        } else {
		            fileName = new String(fileName.getBytes(), "ISO8859-1");
		        }
				
				headerValue = String.format("attachment; filename=\"%s\"",  
						fileName);
			} catch (UnsupportedEncodingException e1) {
				headerValue = String.format("attachment; filename=\"%s\"",  
						 sysFile.getId());
				e1.printStackTrace();
			}  
	        response.setHeader(headerKey, headerValue); 
	        // Copy the stream to the response's output stream.  
	        try {  
	            InputStream myStream = new FileInputStream(fURL);  
	            IOUtils.copy(myStream, response.getOutputStream());  
	            response.flushBuffer();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  
	}
}
