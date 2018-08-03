package com.zztlj.xjpj.utils;

import com.github.crab2died.converter.ReadConvertible;

public class PingdingxinxiXBConverter implements ReadConvertible{

	@Override
	public Object execRead(String object) {
		if (object.equals("男")) {
			return "1";
		}
		else{
			return "0";
		}
	}

}
