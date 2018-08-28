package com.zztlj.xjpj.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-08-27 11:20:33
 */
public class WhitelistDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Long id;
	//部门ID
	private Double deptId;
	//部门名称
	private String deptName;
	//有效期
	private Date expiryDate;

	/**
	 * 设置：序号
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：序号
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：部门ID
	 */
	public void setDeptId(Double deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：部门ID
	 */
	public Double getDeptId() {
		return deptId;
	}
	
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	/**
	 * 设置：有效期
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * 获取：有效期
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}
}
