package com.zztlj.xjpj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zztlj.xjpj.dao.StatisticDao;
import com.zztlj.xjpj.domain.PdqktjVO;
import com.zztlj.xjpj.service.StatisticService;

@Service
public class StatisticServiceImpl implements StatisticService {

	@Autowired
	private StatisticDao statisticDao;
	@Override
	public List<PdqktjVO> calcPdqktj(String khzq) {
		
		return statisticDao.calcPdqktj(khzq);
	}

}
