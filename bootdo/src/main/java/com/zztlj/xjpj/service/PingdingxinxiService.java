package com.zztlj.xjpj.service;

import com.zztlj.xjpj.domain.PingdingxinxiDO;

import java.util.List;
import java.util.Map;

/**
 * ${comments}
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-07-31 17:26:52
 */
public interface PingdingxinxiService {
	
	PingdingxinxiDO get(Double id);
	
	List<PingdingxinxiDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(PingdingxinxiDO pingdingxinxi);
	
	int update(PingdingxinxiDO pingdingxinxi);
	
	int remove(Double id);
	
	int batchRemove(Double[] ids);
	
	int saveOrUpdate(PingdingxinxiDO pingdingxinxi);
}
