package com.zztlj.xjpj.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Tool {
	
	public static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            System.out.println("MD5(" + sourceStr + ",32) = " + result);
            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
	
	public static void main(String[] args) {
//		System.out.println("admin:"+MD5("admin"));
//		System.out.println("xcb:"+MD5("xcb"));
//		System.out.println("csdw:"+MD5("csdw"));
		System.out.println("test:"+MD5("_appid=gblz_timestamp=1511318999491rybm=2061009508xm=何少杰4d8b6618eb983d2f3754c5dc786fbde9"));
	}

}
