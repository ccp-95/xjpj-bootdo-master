package com.zztlj.xjpj.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/front")
public class FrontController {
	
	@GetMapping("")
	String index(){
	    return "xjpj/front/main";
	}
	
	@GetMapping("/search")
	String search(@RequestParam Map<String, Object> params,Model model){
		model.addAllAttributes(params);
	    return "xjpj/front/search";
	}
}
