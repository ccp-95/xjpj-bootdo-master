package com.zztlj.xjpj.dao;

import com.zztlj.xjpj.domain.WhitelistDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * @author zz
 * @email zz@163.com
 * @date 2018-08-27 11:20:33
 */
@Mapper
public interface WhitelistDao {

	WhitelistDO get(Double id);
	
	List<WhitelistDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(WhitelistDO whitelist);
	
	int update(WhitelistDO whitelist);
	
	int remove(Double ID);
	
	int batchRemove(Double[] ids);

	WhitelistDO getByDeptId(Long id);
}
