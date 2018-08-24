package com.bootdo.common.domain;

import java.io.Serializable;
import java.util.Date;



/**
 * 文章附件
 * 
 * @author zz
 * @email zz@163.com
 * @date 2018-08-23 10:26:31
 */
public class AttatchmentDO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//序号
	private Long id;
	//文章ID
	private Long cid;
	//文件ID
	private Long fid;

	public AttatchmentDO(){
		super();
	}
	
	public AttatchmentDO(Long cid,Long fid){
		super();
		this.cid = cid;
		this.fid = fid;
	}
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
	 * 设置：文章ID
	 */
	public void setCid(Long cid) {
		this.cid = cid;
	}
	/**
	 * 获取：文章ID
	 */
	public Long getCid() {
		return cid;
	}
	/**
	 * 设置：文件ID
	 */
	public void setFid(Long fid) {
		this.fid = fid;
	}
	/**
	 * 获取：文件ID
	 */
	public Long getFid() {
		return fid;
	}
}
