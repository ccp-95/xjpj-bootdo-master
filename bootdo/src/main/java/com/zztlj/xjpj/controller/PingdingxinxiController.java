package com.zztlj.xjpj.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zztlj.xjpj.domain.PingdingxinxiDO;
import com.zztlj.xjpj.service.PingdingxinxiService;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.utils.FileType;
import com.bootdo.common.utils.FileUtil;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * ${comments}
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-07-31 17:26:52
 */
 
@Controller
@RequestMapping("/xjpj/pingdingxinxi")
public class PingdingxinxiController {
	@Autowired
	private PingdingxinxiService pingdingxinxiService;
	
	@GetMapping()
	@RequiresPermissions("xjpj:pingdingxinxi:pingdingxinxi")
	String Pingdingxinxi(){
	    return "xjpj/pingdingxinxi/pingdingxinxi";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("xjpj:pingdingxinxi:pingdingxinxi")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<PingdingxinxiDO> pingdingxinxiList = pingdingxinxiService.list(query);
		int total = pingdingxinxiService.count(query);
		PageUtils pageUtils = new PageUtils(pingdingxinxiList, total);
		return pageUtils;
	}
	
	@GetMapping("/importExcel")
	@RequiresPermissions("xjpj:pingdingxinxi:import")
	String importExcel(){
	    return "xjpj/pingdingxinxi/importExcel";
	}
	
	@GetMapping("/add")
	@RequiresPermissions("xjpj:pingdingxinxi:add")
	String add(){
	    return "xjpj/pingdingxinxi/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("xjpj:pingdingxinxi:edit")
	String edit(@PathVariable("id") Double id,Model model){
		PingdingxinxiDO pingdingxinxi = pingdingxinxiService.get(id);
		model.addAttribute("pingdingxinxi", pingdingxinxi);
	    return "xjpj/pingdingxinxi/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("xjpj:pingdingxinxi:add")
	public R save( PingdingxinxiDO pingdingxinxi){
		if(pingdingxinxiService.save(pingdingxinxi)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xjpj:pingdingxinxi:edit")
	public R update( PingdingxinxiDO pingdingxinxi){
		pingdingxinxiService.update(pingdingxinxi);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("xjpj:pingdingxinxi:remove")
	public R remove( Double id){
		if(pingdingxinxiService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("xjpj:pingdingxinxi:batchRemove")
	public R remove(@RequestParam("ids[]") Double[] ids){
		pingdingxinxiService.batchRemove(ids);
		return R.ok();
	}
	
	/**
	 * 导入Excel
	 */
	@ResponseBody
	@PostMapping("/uploadExcel")
	R upload(@RequestParam("file") MultipartFile file,@RequestParam("khzq") String khzq,HttpServletRequest request) {
		
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);
		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
		try {
			System.out.println("考核周期 ："+khzq+"  "+sysFile.toString());
			return R.ok().put("fileName",sysFile.getUrl());
		} catch (Exception e) {
			return R.error();
		}

	}
}
