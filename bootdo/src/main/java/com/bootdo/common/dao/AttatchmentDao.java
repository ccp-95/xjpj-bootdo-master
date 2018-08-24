package com.bootdo.common.dao;

import com.bootdo.common.domain.AttatchmentDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 文章附件
 * @author zz
 * @email zz@163.com
 * @date 2018-08-23 10:26:31
 */
@Mapper
public interface AttatchmentDao {

	AttatchmentDO get(Double id);
	
	List<AttatchmentDO> list(Map<String,Object> map);
	
	int count(Map<String,Object> map);
	
	int save(AttatchmentDO attatchment);
	
	int update(AttatchmentDO attatchment);
	
	int remove(Double ID);
	
	int removeByCid(Long ID);
	
	int batchRemove(Double[] ids);

	int removeByFid(Long id);
}
