package com.zztlj.xjpj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.zztlj.xjpj.dao.WhitelistDao;
import com.zztlj.xjpj.domain.WhitelistDO;
import com.zztlj.xjpj.service.WhitelistService;



@Service
public class WhitelistServiceImpl implements WhitelistService {
	@Autowired
	private WhitelistDao whitelistDao;
	
	@Override
	public WhitelistDO get(Double id){
		return whitelistDao.get(id);
	}
	
	@Override
	public List<WhitelistDO> list(Map<String, Object> map){
		return whitelistDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return whitelistDao.count(map);
	}
	
	@Override
	public int save(WhitelistDO whitelist){
		return whitelistDao.save(whitelist);
	}
	
	@Override
	public int update(WhitelistDO whitelist){
		return whitelistDao.update(whitelist);
	}
	
	@Override
	public int remove(Double id){
		return whitelistDao.remove(id);
	}
	
	@Override
	public int batchRemove(Double[] ids){
		return whitelistDao.batchRemove(ids);
	}

	@Override
	public WhitelistDO getByDeptId(Long id) {
		return whitelistDao.getByDeptId(id);
	}
	
}
