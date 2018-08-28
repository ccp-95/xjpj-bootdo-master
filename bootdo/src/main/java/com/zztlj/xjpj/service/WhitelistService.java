package com.zztlj.xjpj.service;

import com.zztlj.xjpj.domain.WhitelistDO;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-08-27 11:20:33
 */
public interface WhitelistService {
	
	WhitelistDO get(Double id);
	
	WhitelistDO getByDeptId(Long id);
	
	List<WhitelistDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(WhitelistDO whitelist);
	
	int update(WhitelistDO whitelist);
	
	int remove(Double id);
	
	int batchRemove(Double[] ids);
}
