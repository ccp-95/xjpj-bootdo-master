package com.zztlj.xjpj.dao;

import com.zztlj.xjpj.domain.PingdingxinxiDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * @author zz
 * @email zz@163.com
 * @date 2018-07-31 17:26:52
 */
@Mapper
public interface PingdingxinxiDao {

	PingdingxinxiDO get(Double id);
	
	List<PingdingxinxiDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(PingdingxinxiDO pingdingxinxi);
	
	int update(PingdingxinxiDO pingdingxinxi);
	
	int updateWithSfzh(PingdingxinxiDO pingdingxinxi);
	
	int remove(Double ID);
	
	int batchRemove(Double[] ids);
}
