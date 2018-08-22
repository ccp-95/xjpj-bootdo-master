package com.zztlj.xjpj.controller;

import org.apache.commons.configuration.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zztlj.xjpj.domain.PdqktjVO;
import com.zztlj.xjpj.service.StatisticService;
import com.zztlj.xjpj.utils.ConfigUtil;
import com.zztlj.xjpj.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/xjpj/statistics")
public class StatisticsController {


	@Autowired
	private StatisticService statitsticService;
	
	@GetMapping("/pdqktj")
	@ResponseBody
	public List<PdqktjVO> listPdqktj(String khzq) {
		if (khzq==null||khzq.isEmpty()) {
			Date now = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(now);
			int day = cal.get(Calendar.DATE);
			Configuration config = ConfigUtil.getConfig();
			
			String publishDay = config.getString("publishDay");
			if (day<Integer.parseInt(publishDay)) {
				cal.add(Calendar.MONTH, -1);
			}
			
			khzq = DateUtils.format(cal.getTime(), "yyyyMM");
		}
		return statitsticService.calcPdqktj(khzq);
	}
}
