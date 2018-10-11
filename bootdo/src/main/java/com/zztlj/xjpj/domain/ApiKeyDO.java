package com.zztlj.xjpj.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * API访问密钥
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-10-11 14:13:09
 */
public class ApiKeyDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Double id;
	//App标识
	private String appid;
	//App密钥
	private String appkey;
	//单位ID
	private Long deptId;

	/**
	 * 设置：序号
	 */
	public void setId(Double id) {
		this.id = id;
	}
	/**
	 * 获取：序号
	 */
	public Double getId() {
		return id;
	}
	/**
	 * 设置：App标识
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}
	/**
	 * 获取：App标识
	 */
	public String getAppid() {
		return appid;
	}
	/**
	 * 设置：App密钥
	 */
	public void setAppkey(String appkey) {
		this.appkey = appkey;
	}
	/**
	 * 获取：App密钥
	 */
	public String getAppkey() {
		return appkey;
	}
	/**
	 * 设置：单位ID
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：单位ID
	 */
	public Long getDeptId() {
		return deptId;
	}
}
