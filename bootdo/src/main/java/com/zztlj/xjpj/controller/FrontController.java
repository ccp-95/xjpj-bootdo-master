package com.zztlj.xjpj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zztlj.xjpj.service.PingdingxinxiService;

@Controller
@RequestMapping("/front")
public class FrontController {
	
	@GetMapping()
	String main(){
	    return "xjpj/front/main";
	}
}
