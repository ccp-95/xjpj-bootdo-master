package com.zztlj.xjpj.dao;

import com.zztlj.xjpj.domain.ApiKeyDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * API访问密钥
 * @author zz
 * @email zz@163.com
 * @date 2018-10-11 13:50:18
 */
@Mapper
public interface ApiKeyDao {

	ApiKeyDO get(Double id);
	
	List<ApiKeyDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(ApiKeyDO apiKey);
	
	int update(ApiKeyDO apiKey);
	
	int remove(Double ID);
	
	int batchRemove(Double[] ids);

	ApiKeyDO getByAppID(String appid);
}
