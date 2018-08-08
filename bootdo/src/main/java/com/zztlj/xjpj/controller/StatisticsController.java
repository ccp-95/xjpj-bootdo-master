package com.zztlj.xjpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zztlj.xjpj.domain.PdqktjVO;
import com.zztlj.xjpj.service.StatisticService;

import java.util.List;

@Controller
@RequestMapping("/xjpj/statistics")
public class StatisticsController {


	@Autowired
	private StatisticService statitsticService;
	
	@GetMapping("/pdqktj")
	@ResponseBody
	public List<PdqktjVO> listPdqktj(String khzq) {
		return statitsticService.calcPdqktj(khzq);
	}
}
