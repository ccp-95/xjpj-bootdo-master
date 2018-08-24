package com.bootdo.common.service;

import com.bootdo.common.domain.AttatchmentDO;
import com.bootdo.common.vo.AttatchmentVO;

import java.util.List;
import java.util.Map;

/**
 * 文章附件
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-08-23 10:26:31
 */
public interface AttatchmentService {
	
	AttatchmentDO get(Double id);
	
	List<AttatchmentDO> list(Map<String, Object> map);
	
	List<AttatchmentVO> listAttatchmentByCid(Long cid);
	
	int count(Map<String, Object> map);
	
	int save(AttatchmentDO attatchment);
	
	int update(AttatchmentDO attatchment);
	
	int remove(Double id);
	
	int removeByCid(Long cid);
	
	int batchRemove(Double[] ids);

	int removeByFid(Long id);
}
