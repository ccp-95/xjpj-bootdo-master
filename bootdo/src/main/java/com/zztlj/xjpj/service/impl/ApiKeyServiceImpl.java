package com.zztlj.xjpj.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.zztlj.xjpj.dao.ApiKeyDao;
import com.zztlj.xjpj.domain.ApiKeyDO;
import com.zztlj.xjpj.service.ApiKeyService;



@Service
public class ApiKeyServiceImpl implements ApiKeyService {
	@Autowired
	private ApiKeyDao apiKeyDao;
	
	@Override
	public ApiKeyDO get(Double id){
		return apiKeyDao.get(id);
	}
	
	@Override
	public List<ApiKeyDO> list(Map<String, Object> map){
		return apiKeyDao.list(map);
	}
	
	@Override
	public int count(Map<String, Object> map){
		return apiKeyDao.count(map);
	}
	
	@Override
	public int save(ApiKeyDO apiKey){
		return apiKeyDao.save(apiKey);
	}
	
	@Override
	public int update(ApiKeyDO apiKey){
		return apiKeyDao.update(apiKey);
	}
	
	@Override
	public int remove(Double id){
		return apiKeyDao.remove(id);
	}
	
	@Override
	public int batchRemove(Double[] ids){
		return apiKeyDao.batchRemove(ids);
	}

	@Override
	public ApiKeyDO get(String appid) {
		// TODO Auto-generated method stub
		return apiKeyDao.getByAppID(appid);
	}
	
}
