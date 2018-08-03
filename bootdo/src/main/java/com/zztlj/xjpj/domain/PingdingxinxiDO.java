package com.zztlj.xjpj.domain;

import java.io.Serializable;
import java.util.Date;

import com.github.crab2died.annotation.ExcelField;
import com.zztlj.xjpj.utils.PingdingxinxiXBConverter;



/**
 * ${comments}
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-07-31 17:26:52
 */
public class PingdingxinxiDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	@ExcelField(title = "序号", order = 1)
	private Integer id;
	//考核周期
	@ExcelField(title = "考核周期", order = 2)
	private String khzq;
	//单位
	@ExcelField(title = "单位", order = 3)
	private Long deptId;
	//职工姓名
	@ExcelField(title = "职工姓名", order = 4)
	private String zgxm;
	//年龄
	@ExcelField(title = "年龄", order = 5)
	private Double nl;
	//性别 0：女 1：男
	@ExcelField(title = "性别", order = 6,readConverter = PingdingxinxiXBConverter.class)
	private String xb;
	//车间
	@ExcelField(title = "所在车间", order = 7)
	private String cheJian;
	//班组
	@ExcelField(title = "所在班组", order = 8)
	private String banZu;
	//岗位
	@ExcelField(title = "岗位名称", order = 9)
	private String gangWei;
	//身份证号
	@ExcelField(title = "身份证号", order = 10)
	private String sfzh;
	//星级
	@ExcelField(title = "星级", order = 11)
	private Double xingJi;
	//综合得分
	@ExcelField(title = "综合得分", order = 12)
	private Double zhdf;
	//业务技能
	@ExcelField(title = "业务技能", order = 13)
	private Double ywjn;
	//遵章守纪
	@ExcelField(title = "遵章守纪", order = 14)
	private Double zzsj;
	//安全绩效
	@ExcelField(title = "安全绩效", order = 15)
	private Double aqjx;
	//完成工作
	@ExcelField(title = "完成工作", order = 16)
	private Double wcgz;

	/**
	 * 设置：序号
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：序号
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
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	/**
	 * 获取：单位
	 */
	public Long getDeptId() {
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
	 * 设置：年龄
	 */
	public void setNl(Double nl) {
		this.nl = nl;
	}
	/**
	 * 获取：年龄
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
