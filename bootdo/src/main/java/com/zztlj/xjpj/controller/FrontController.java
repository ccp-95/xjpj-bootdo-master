package com.zztlj.xjpj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/front")
public class FrontController {
	
	@GetMapping()
	String main(){
	    return "xjpj/front/main";
	}
	
	@GetMapping("/search")
	String search(){
	    return "xjpj/front/search";
	}
}
