package com.zztlj.xjpj.service;

import com.zztlj.xjpj.domain.ApiKeyDO;

import java.util.List;
import java.util.Map;

/**
 * API访问密钥
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-10-11 13:50:18
 */
public interface ApiKeyService {
	
	ApiKeyDO get(Double id);
	
	ApiKeyDO get(String appid);
	
	List<ApiKeyDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ApiKeyDO apiKey);
	
	int update(ApiKeyDO apiKey);
	
	int remove(Double id);
	
	int batchRemove(Double[] ids);
}
