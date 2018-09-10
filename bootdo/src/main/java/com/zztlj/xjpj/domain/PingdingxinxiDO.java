package com.zztlj.xjpj.domain;

import java.io.Serializable;

import com.github.crab2died.annotation.ExcelField;
import com.zztlj.xjpj.utils.NumberUtil;
import com.zztlj.xjpj.utils.PingdingxinxiXBConverter;
import com.zztlj.xjpj.utils.PingdingxinxiXJConverter;



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
	private Long deptId;
	//单位名称
	@ExcelField(title = "单位", order = 3)
	private String deptName;
	
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
	@ExcelField(title = "星级", order = 11,readConverter = PingdingxinxiXJConverter.class)
	private Double xingJi;
	//综合得分
	@ExcelField(title = "综合得分", order = 12)
	private String zhdf;
	//业务技能
	@ExcelField(title = "业务技能", order = 13)
	private String ywjn;
	//遵章守纪
	@ExcelField(title = "遵章守纪", order = 14)
	private String zzsj;
	//安全绩效
	@ExcelField(title = "安全绩效", order = 15)
	private String aqjx;
	//完成工作
	@ExcelField(title = "完成工作", order = 16)
	private String wcgz;

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
		this.khzq = khzq.trim();
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
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName.replaceAll(" ", "");
	}
	/**
	 * 设置：职工姓名
	 */
	public void setZgxm(String zgxm) {
		this.zgxm = zgxm.replaceAll(" ", "");
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
		this.xb = xb.replaceAll(" ", "");
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
		this.cheJian = cheJian.replaceAll(" ", "");
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
		this.banZu = banZu.replaceAll(" ", "");
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
		this.gangWei = gangWei.replaceAll(" ", "");
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
		this.sfzh = sfzh.replaceAll(" ", "");
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
	public void setZhdf(String zhdf) {
		
		this.zhdf = formatFs(zhdf.replaceAll(" ", ""));
		
	}
	/**
	 * 获取：综合得分
	 */
	public String getZhdf() {
		return zhdf;
	}
	/**
	 * 设置：业务技能
	 */
	public void setYwjn(String ywjn) {
		this.ywjn = formatFs(ywjn.replaceAll(" ", ""));
	}
	/**
	 * 获取：业务技能
	 */
	public String getYwjn() {
		return ywjn;
	}
	/**
	 * 设置：遵章守纪
	 */
	public void setZzsj(String zzsj) {
		this.zzsj = formatFs(zzsj.replaceAll(" ", ""));
	}
	/**
	 * 获取：遵章守纪
	 */
	public String getZzsj() {
		return zzsj;
	}
	/**
	 * 设置：安全绩效
	 */
	public void setAqjx(String aqjx) {
		this.aqjx = formatFs(aqjx.replaceAll(" ", ""));
	}
	/**
	 * 获取：安全绩效
	 */
	public String getAqjx() {
		return aqjx;
	}
	/**
	 * 设置：完成工作
	 */
	public void setWcgz(String wcgz) {
		this.wcgz = formatFs(wcgz.replaceAll(" ", ""));
	}
	/**
	 * 获取：完成工作
	 */
	public String getWcgz() {
		return wcgz;
	}
	
	private String formatFs(String fs){
		if (NumberUtil.isNumeric(fs)) {
			double d = Double.parseDouble(fs);
			return NumberUtil.formatDouble(d, "#.00");
		}
		else{
			return fs;
		}
	}
}
