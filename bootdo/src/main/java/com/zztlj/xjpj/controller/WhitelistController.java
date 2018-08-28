package com.zztlj.xjpj.controller;

import java.util.List;
import java.util.Map;

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

import com.zztlj.xjpj.domain.WhitelistDO;
import com.zztlj.xjpj.service.WhitelistService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;

/**
 * ${comments}
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-08-27 11:20:33
 */
 
@Controller
@RequestMapping("/xjpj/whitelist")
public class WhitelistController {
	@Autowired
	private WhitelistService whitelistService;
	
	@GetMapping()
	@RequiresPermissions("xjpj:whitelist:whitelist")
	String Whitelist(){
	    return "xjpj/whitelist/whitelist";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("xjpj:whitelist:whitelist")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<WhitelistDO> whitelistList = whitelistService.list(query);
		int total = whitelistService.count(query);
		PageUtils pageUtils = new PageUtils(whitelistList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("xjpj:whitelist:add")
	String add(){
	    return "xjpj/whitelist/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("xjpj:whitelist:edit")
	String edit(@PathVariable("id") Double id,Model model){
		WhitelistDO whitelist = whitelistService.get(id);
		model.addAttribute("whitelist", whitelist);
	    return "xjpj/whitelist/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("xjpj:whitelist:add")
	public R save( WhitelistDO whitelist){
		if(whitelistService.save(whitelist)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("xjpj:whitelist:edit")
	public R update( WhitelistDO whitelist){
		whitelistService.update(whitelist);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("xjpj:whitelist:remove")
	public R remove( Double id){
		if(whitelistService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("xjpj:whitelist:batchRemove")
	public R remove(@RequestParam("ids[]") Double[] ids){
		whitelistService.batchRemove(ids);
		return R.ok();
	}
	
}
