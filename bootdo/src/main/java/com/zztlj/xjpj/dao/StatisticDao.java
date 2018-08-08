package com.zztlj.xjpj.dao;

import com.zztlj.xjpj.domain.PdqktjVO;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

/**
 * ${comments}
 * @author zz
 * @email zz@163.com
 * @date 2018-07-31 17:26:52
 */
@Mapper
public interface StatisticDao {
	List<PdqktjVO> calcPdqktj(String khzq);
	
}
