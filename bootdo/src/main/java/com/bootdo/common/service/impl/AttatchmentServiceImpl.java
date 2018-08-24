package com.bootdo.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bootdo.common.dao.AttatchmentDao;
import com.bootdo.common.dao.FileDao;
import com.bootdo.common.domain.AttatchmentDO;
import com.bootdo.common.domain.FileDO;
import com.bootdo.common.service.AttatchmentService;
import com.bootdo.common.utils.Query;
import com.bootdo.common.vo.AttatchmentVO;



@Service
public class AttatchmentServiceImpl implements AttatchmentService {
	@Autowired
	private AttatchmentDao attatchmentDao;
	@Autowired
	private FileDao fileDao;
	
	
	@Override
	public AttatchmentDO get(Double id){
		return attatchmentDao.get(id);
	}
	
	@Override
	public List<AttatchmentDO> list(Map<String, Object> map){
		return attatchmentDao.list(map);
	}
	
	@Override
	public List<AttatchmentVO> listAttatchmentByCid(Long cid) {
		List<AttatchmentVO> listRet = new ArrayList<AttatchmentVO>();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("cid", cid);
        List<AttatchmentDO> list = attatchmentDao.list(params);
        for (AttatchmentDO attatchmentDO : list) {
        	AttatchmentVO aVO = new AttatchmentVO();
        	aVO.setAttatchmentDO(attatchmentDO);
        	FileDO fDo = fileDao.get(attatchmentDO.getFid());
        	aVO.setFileDO(fDo);
        	listRet.add(aVO);
		}
        return listRet;
	}
	@Override
	public int count(Map<String, Object> map){
		return attatchmentDao.count(map);
	}
	
	@Override
	public int save(AttatchmentDO attatchment){
		return attatchmentDao.save(attatchment);
	}
	
	@Override
	public int update(AttatchmentDO attatchment){
		return attatchmentDao.update(attatchment);
	}
	
	@Override
	public int remove(Double id){
		return attatchmentDao.remove(id);
	}
	
	@Override
	public int batchRemove(Double[] ids){
		return attatchmentDao.batchRemove(ids);
	}

	@Override
	public int removeByCid(Long cid) {
		// TODO Auto-generated method stub
		return attatchmentDao.removeByCid(cid);
	}

	@Override
	public int removeByFid(Long id) {
		// TODO Auto-generated method stub
		return attatchmentDao.removeByFid(id);
	}

	
	
}
