package com.bootdo.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.bootdo.common.domain.AttatchmentDO;
import com.bootdo.common.service.AttatchmentService;
import com.bootdo.common.utils.PageUtils;
import com.bootdo.common.utils.Query;
import com.bootdo.common.utils.R;
import com.bootdo.common.vo.AttatchmentVO;

/**
 * 文章附件
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-08-23 10:26:31
 */
 
@Controller
@RequestMapping("/common/attatchment")
public class AttatchmentController {
	@Autowired
	private AttatchmentService attatchmentService;
	
	@GetMapping()
	@RequiresPermissions("common:attatchment:attatchment")
	String Attatchment(){
	    return "common/attatchment/attatchment";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("common:attatchment:attatchment")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<AttatchmentDO> attatchmentList = attatchmentService.list(query);
		int total = attatchmentService.count(query);
		PageUtils pageUtils = new PageUtils(attatchmentList, total);
		return pageUtils;
	}
	
	@ResponseBody
	@GetMapping("/listAttatchment/{cid}")
	public List<AttatchmentVO> listAttatchment(@PathVariable("cid") Long cid){
		//查询列表数据
		List<AttatchmentVO> attatchmentList = attatchmentService.listAttatchmentByCid(cid);
		return attatchmentList;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("common:attatchment:add")
	String add(){
	    return "common/attatchment/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("common:attatchment:edit")
	String edit(@PathVariable("id") Double id,Model model){
		AttatchmentDO attatchment = attatchmentService.get(id);
		model.addAttribute("attatchment", attatchment);
	    return "common/attatchment/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("common:attatchment:add")
	public R save( AttatchmentDO attatchment){
		if(attatchmentService.save(attatchment)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("common:attatchment:edit")
	public R update( AttatchmentDO attatchment){
		attatchmentService.update(attatchment);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("common:attatchment:remove")
	public R remove( Double id){
		if(attatchmentService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("common:attatchment:batchRemove")
	public R remove(@RequestParam("ids[]") Double[] ids){
		attatchmentService.batchRemove(ids);
		return R.ok();
	}
	
}
