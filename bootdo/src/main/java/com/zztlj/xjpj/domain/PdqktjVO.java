package com.zztlj.xjpj.domain;

import java.io.Serializable;

/**
 * 评定情况统计VO
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-07-31 17:26:52
 */
 
public class PdqktjVO implements Serializable{

	private static final long serialVersionUID = 1L;
	//单位名称
	private String deptName;
	//评定职工人数
	private Integer pdzgrs;
	//三星人数
	private Integer sxrs;
	//三星比例
	private Double sxbl;
	//二星人数
	private Integer exrs;
	//二星比例
	private Double exbl;
	//一星人数
	private Integer yxrs;
	//一星比例
	private Double yxbl;
	
	public Integer getPdzgrs() {
		return pdzgrs;
	}
	public void setPdzgrs(Integer pdzgrs) {
		this.pdzgrs = pdzgrs;
	}
	public Integer getSxrs() {
		return sxrs;
	}
	public void setSxrs(Integer sxrs) {
		this.sxrs = sxrs;
	}
	public Integer getExrs() {
		return exrs;
	}
	public void setExrs(Integer exrs) {
		this.exrs = exrs;
	}
	public Integer getYxrs() {
		return yxrs;
	}
	public void setYxrs(Integer yxrs) {
		this.yxrs = yxrs;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public Double getSxbl() {
		return (double)this.sxrs/this.pdzgrs;
	}
	public Double getExbl() {
		return (double)this.exrs/this.pdzgrs;
	}
	public Double getYxbl() {
		return (double)this.yxrs/this.pdzgrs;
	}
}
