package com.zztlj.xjpj.service;

import java.util.List;

import com.zztlj.xjpj.domain.PdqktjVO;

public interface StatisticService {

	List<PdqktjVO> calcPdqktj(String khzq);
}
