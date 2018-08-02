package com.zztlj.xjpj.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * ${comments}
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-07-31 17:26:52
 */
public class PingdingxinxiDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//$column.comments
	private Integer id;
	//考核周期
	private String khzq;
	//单位
	private Double deptId;
	//职工姓名
	private String zgxm;
	//$column.comments
	private Double nl;
	//性别 0：女 1：男
	private String xb;
	//车间
	private String cheJian;
	//班组
	private String banZu;
	//岗位
	private String gangWei;
	//身份证号
	private String sfzh;
	//星级
	private Double xingJi;
	//综合得分
	private Double zhdf;
	//业务技能
	private Double ywjn;
	//遵章守纪
	private Double zzsj;
	//安全绩效
	private Double aqjx;
	//完成工作
	private Double wcgz;

	/**
	 * 设置：${column.comments}
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：${column.comments}
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：考核周期
	 */
	public void setKhzq(String khzq) {
		this.khzq = khzq;
	}
	/**
	 * 获取：考核周期
	 */
	public String getKhzq() {
		return khzq;
	}
	/**
	 * 设置：单位
	 */
	public void setDeptId(Double deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：单位
	 */
	public Double getDeptId() {
		return deptId;
	}
	/**
	 * 设置：职工姓名
	 */
	public void setZgxm(String zgxm) {
		this.zgxm = zgxm;
	}
	/**
	 * 获取：职工姓名
	 */
	public String getZgxm() {
		return zgxm;
	}
	/**
	 * 设置：${column.comments}
	 */
	public void setNl(Double nl) {
		this.nl = nl;
	}
	/**
	 * 获取：${column.comments}
	 */
	public Double getNl() {
		return nl;
	}
	/**
	 * 设置：性别 0：女 1：男
	 */
	public void setXb(String xb) {
		this.xb = xb;
	}
	/**
	 * 获取：性别 0：女 1：男
	 */
	public String getXb() {
		return xb;
	}
	/**
	 * 设置：车间
	 */
	public void setCheJian(String cheJian) {
		this.cheJian = cheJian;
	}
	/**
	 * 获取：车间
	 */
	public String getCheJian() {
		return cheJian;
	}
	/**
	 * 设置：班组
	 */
	public void setBanZu(String banZu) {
		this.banZu = banZu;
	}
	/**
	 * 获取：班组
	 */
	public String getBanZu() {
		return banZu;
	}
	/**
	 * 设置：岗位
	 */
	public void setGangWei(String gangWei) {
		this.gangWei = gangWei;
	}
	/**
	 * 获取：岗位
	 */
	public String getGangWei() {
		return gangWei;
	}
	/**
	 * 设置：身份证号
	 */
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	/**
	 * 获取：身份证号
	 */
	public String getSfzh() {
		return sfzh;
	}
	/**
	 * 设置：星级
	 */
	public void setXingJi(Double xingJi) {
		this.xingJi = xingJi;
	}
	/**
	 * 获取：星级
	 */
	public Double getXingJi() {
		return xingJi;
	}
	/**
	 * 设置：综合得分
	 */
	public void setZhdf(Double zhdf) {
		this.zhdf = zhdf;
	}
	/**
	 * 获取：综合得分
	 */
	public Double getZhdf() {
		return zhdf;
	}
	/**
	 * 设置：业务技能
	 */
	public void setYwjn(Double ywjn) {
		this.ywjn = ywjn;
	}
	/**
	 * 获取：业务技能
	 */
	public Double getYwjn() {
		return ywjn;
	}
	/**
	 * 设置：遵章守纪
	 */
	public void setZzsj(Double zzsj) {
		this.zzsj = zzsj;
	}
	/**
	 * 获取：遵章守纪
	 */
	public Double getZzsj() {
		return zzsj;
	}
	/**
	 * 设置：安全绩效
	 */
	public void setAqjx(Double aqjx) {
		this.aqjx = aqjx;
	}
	/**
	 * 获取：安全绩效
	 */
	public Double getAqjx() {
		return aqjx;
	}
	/**
	 * 设置：完成工作
	 */
	public void setWcgz(Double wcgz) {
		this.wcgz = wcgz;
	}
	/**
	 * 获取：完成工作
	 */
	public Double getWcgz() {
		return wcgz;
	}
}
