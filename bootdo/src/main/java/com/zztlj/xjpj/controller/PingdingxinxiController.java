package com.zztlj.xjpj.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.configuration.Configuration;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zztlj.xjpj.domain.PingdingxinxiDO;
import com.zztlj.xjpj.domain.WhitelistDO;
import com.zztlj.xjpj.service.PingdingxinxiService;
import com.zztlj.xjpj.service.WhitelistService;
import com.zztlj.xjpj.utils.ConfigUtil;
import com.zztlj.xjpj.utils.DateUtils;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.utils.FileType;
import com.bootdo.common.utils.FileUtil;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.system.domain.UserDO;
import com.github.crab2died.ExcelUtils;

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

	@Autowired
	private WhitelistService whitelistService;

	@GetMapping()
	@RequiresPermissions("xjpj:pingdingxinxi:pingdingxinxi")
	String Pingdingxinxi() {
		return "xjpj/pingdingxinxi/pingdingxinxi";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("xjpj:pingdingxinxi:pingdingxinxi")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		UserDO user = (UserDO) SecurityUtils.getSubject().getPrincipal();
		Long useId = user.getDeptId();
		if (useId == null) {
			return null;
		}
		Query query = new Query(params);
		query.put("deptId", user.getDeptId());
		List<PingdingxinxiDO> pingdingxinxiList = pingdingxinxiService.list(query);
		int total = pingdingxinxiService.count(query);
		PageUtils pageUtils = new PageUtils(pingdingxinxiList, total);
		return pageUtils;
	}

	@ResponseBody
	@GetMapping("/search")
	public PageUtils search(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<PingdingxinxiDO> pingdingxinxiList = pingdingxinxiService.list(query);
		// 屏蔽身份证号中间5位
		for (PingdingxinxiDO pingdingxinxiDO : pingdingxinxiList) {

			String sfzh = pingdingxinxiDO.getSfzh();
			sfzh = sfzh.substring(0, 10) + "*****" + sfzh.substring(15);
			pingdingxinxiDO.setSfzh(sfzh);
		}
		int total = pingdingxinxiService.count(query);
		PageUtils pageUtils = new PageUtils(pingdingxinxiList, total);
		return pageUtils;
	}

	@GetMapping("/importExcel")
	@RequiresPermissions("xjpj:pingdingxinxi:import")
	String importExcel() {
		return "xjpj/pingdingxinxi/importExcel";
	}

	@GetMapping("/add")
	@RequiresPermissions("xjpj:pingdingxinxi:add")
	String add() {
		return "xjpj/pingdingxinxi/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("xjpj:pingdingxinxi:edit")
	String edit(@PathVariable("id") Double id, Model model) {
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
	public R save(PingdingxinxiDO pingdingxinxi) {
		if (pingdingxinxiService.save(pingdingxinxi) > 0) {
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
	public R update(PingdingxinxiDO pingdingxinxi) {
		pingdingxinxiService.update(pingdingxinxi);
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	@RequiresPermissions("xjpj:pingdingxinxi:remove")
	public R remove(Double id) {
		PingdingxinxiDO pdxx = pingdingxinxiService.get(id);
		String khzq = pdxx.getKhzq();
		// 检查所选考核周期是否在可修改期限内
		Configuration config = ConfigUtil.getConfig();

		String archiveDayStr = config.getString("archiveDay");
		String archiveDateStr = khzq + archiveDayStr + "235959";
		Date archiveDate = DateUtils.parse(archiveDateStr, DateUtils.YMDHMS);
		// 所选考核周期增加一个月为截止时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(archiveDate);
		cal.add(Calendar.MONTH, 1);
		archiveDate = cal.getTime();

		// 判断用户是否在截止时间白名单中
		UserDO user = (UserDO) SecurityUtils.getSubject().getPrincipal();

		WhitelistDO whitelistDO = whitelistService.getByDeptId(user.getDeptId());

		if (whitelistDO != null && whitelistDO.getExpiryDate().compareTo(archiveDate) > 0) {
			archiveDate = whitelistDO.getExpiryDate();
		}

		Date now = new Date();
		// 当前时间超出归档时间
		if (now.compareTo(archiveDate) > 0) {
			return R.error("已过截止时间，不允许删除！如有疑问请联系管理员！");
		}

		if (pingdingxinxiService.remove(id) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("xjpj:pingdingxinxi:batchRemove")
	public R remove(@RequestParam("ids[]") Double[] ids) {
		for (Double id : ids) {
			PingdingxinxiDO pdxx = pingdingxinxiService.get(id);
			String khzq = pdxx.getKhzq();
			// 检查所选考核周期是否在可修改期限内
			Configuration config = ConfigUtil.getConfig();

			String archiveDayStr = config.getString("archiveDay");
			String archiveDateStr = khzq + archiveDayStr + "235959";
			Date archiveDate = DateUtils.parse(archiveDateStr, DateUtils.YMDHMS);
			// 所选考核周期增加一个月为截止时间
			Calendar cal = Calendar.getInstance();
			cal.setTime(archiveDate);
			cal.add(Calendar.MONTH, 1);
			archiveDate = cal.getTime();

			// 判断用户是否在截止时间白名单中
			UserDO user = (UserDO) SecurityUtils.getSubject().getPrincipal();

			WhitelistDO whitelistDO = whitelistService.getByDeptId(user.getDeptId());

			if (whitelistDO != null && whitelistDO.getExpiryDate().compareTo(archiveDate) > 0) {
				archiveDate = whitelistDO.getExpiryDate();
			}

			Date now = new Date();
			// 当前时间超出归档时间
			if (now.compareTo(archiveDate) > 0) {
				return R.error("已过截止时间，不允许删除！如有疑问请联系管理员！");
			}
		}
		pingdingxinxiService.batchRemove(ids);
		return R.ok();
	}

	/**
	 * 导入Excel
	 */
	@ResponseBody
	@PostMapping("/uploadExcel")
	R upload(@RequestParam("file") MultipartFile file, @RequestParam("khzq") String khzq, HttpServletRequest request) {
		if (khzq.isEmpty()) {
			return R.error("请先选择考核周期，再上传文件！");
		}
		// 检查所选考核周期是否在可修改期限内
		Configuration config = ConfigUtil.getConfig();

		String archiveDayStr = config.getString("archiveDay");
		String archiveDateStr = khzq + archiveDayStr + "235959";
		Date archiveDate = DateUtils.parse(archiveDateStr, DateUtils.YMDHMS);
		// 所选考核周期增加一个月为截止时间
		Calendar cal = Calendar.getInstance();
		cal.setTime(archiveDate);
		cal.add(Calendar.MONTH, 1);
		archiveDate = cal.getTime();

		// 判断用户是否在截止时间白名单中
		UserDO user = (UserDO) SecurityUtils.getSubject().getPrincipal();

		WhitelistDO whitelistDO = whitelistService.getByDeptId(user.getDeptId());

		if (whitelistDO != null && whitelistDO.getExpiryDate().compareTo(archiveDate) > 0) {
			archiveDate = whitelistDO.getExpiryDate();
		}

		Date now = new Date();
		// 当前时间超出归档时间
		if (now.compareTo(archiveDate) > 0) {
			return R.error("已过截止时间，请于" + archiveDayStr + "日前录入上个考核周期的评价信息！如有疑问请联系管理员！");
		}

		String fileName = file.getOriginalFilename();
		InputStream iStream;
		try {
			iStream = file.getInputStream();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return R.error();
		}
		fileName = FileUtil.renameToUUID(fileName);
		FileDO sysFile = new FileDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
		try {
			System.out.println("考核周期 ：" + khzq + "  " + sysFile.toString());

			List<PingdingxinxiDO> list = ExcelUtils.getInstance().readExcel2Objects(iStream, PingdingxinxiDO.class);

			String updateMsg = "";
			int insertCount = 0;
			int updateCount = 0;
			for (PingdingxinxiDO pdxx : list) {
				pdxx.setKhzq(khzq);
				pdxx.setDeptId(user.getDeptId());
				int ret = pingdingxinxiService.saveOrUpdate(pdxx);
				if (ret == 1) {
					insertCount++;
				}
				if (ret == 2) {
					updateCount++;
					if (updateCount<=5) {
						updateMsg += pdxx.getZgxm()+" ";
					}
				}
			}
			return R.ok().put("fileName", sysFile.getUrl()).put("updateMsg", "共新增信息"+insertCount+"条。更新数据"+updateCount+"条，更新人员为 "+updateMsg+"等");
		} catch (NumberFormatException e) {

			return R.error("分数格式错误，请检查！错误数据为：" + e.getMessage());
		} catch (Exception e) {

			return R.error(e.getMessage());
		}

	}
}
