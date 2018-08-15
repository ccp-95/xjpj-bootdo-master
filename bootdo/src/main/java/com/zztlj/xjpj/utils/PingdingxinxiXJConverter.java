package com.zztlj.xjpj.utils;

import com.github.crab2died.converter.ReadConvertible;

public class PingdingxinxiXJConverter implements ReadConvertible{

	@Override
	public Object execRead(String xj) {
		Double ret;
		switch (xj) {
		case "1":
		case "2":
		case "3":
			ret = Double.parseDouble(xj);
			break;

		default:
			ret = 0.0;
			break;
		}
		return ret;
	}

}
