package com.zztlj.xjpj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.system.dao.DeptDao;
import com.zztlj.xjpj.dao.PingdingxinxiDao;
import com.zztlj.xjpj.domain.PingdingxinxiDO;
import com.zztlj.xjpj.service.PingdingxinxiService;



@Service
public class PingdingxinxiServiceImpl implements PingdingxinxiService {
	@Autowired
	private PingdingxinxiDao pingdingxinxiDao;
	@Autowired
    DeptDao deptMapper;
	
	@Override
	public PingdingxinxiDO get(Double id){
		return pingdingxinxiDao.get(id);
	}
	
	@Override
	public List<PingdingxinxiDO> list(Map<String, Object> map){
		return pingdingxinxiDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return pingdingxinxiDao.count(map);
	}
	
	@Override
	public int save(PingdingxinxiDO pingdingxinxi){
		return pingdingxinxiDao.save(pingdingxinxi);
	}
	
	@Override
	public int update(PingdingxinxiDO pingdingxinxi){
		return pingdingxinxiDao.update(pingdingxinxi);
	}
	
	@Override
	public int remove(Double id){
		return pingdingxinxiDao.remove(id);
	}
	
	@Override
	public int batchRemove(Double[] ids){
		return pingdingxinxiDao.batchRemove(ids);
	}

	@Override
	public int saveOrUpdate(PingdingxinxiDO pingdingxinxi) {
		String sfzh = pingdingxinxi.getSfzh();
		if (sfzh == null || sfzh.length() == 0) {
			return 0;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("khzq", pingdingxinxi.getKhzq());
		map.put("sfzh", sfzh);
		map.put("deptId", pingdingxinxi.getDeptId());
		int count = pingdingxinxiDao.count(map);
		if (count == 0) {
			pingdingxinxiDao.save(pingdingxinxi);
			return 1;
		}
		else if (count == 1) {
			pingdingxinxiDao.updateWithSfzh(pingdingxinxi);
			return 2;
		}
		return 0;
	}
	
}
