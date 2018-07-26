package com.bootdo.common.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 列的属性
 * 
 * 
 */
public class ColumnDO {
	// 列名
	private String columnName;
	// 列名类型
	private String dataType;
	// JDBCType
	private String jdbcType;
	// 列名备注
	private String comments;

	// 属性名称(第一个字母大写)，如：user_name => UserName
	private String attrName;
	// 属性名称(第一个字母小写)，如：user_name => userName
	private String attrname;
	// 属性类型
	private String attrType;
	// auto_increment
	private String extra;

	private static Map<String, String> typeMap = new HashMap<String, String>(){{
		put("NUMBER","NUMERIC");
		put("INTEGER","INTEGER");
		put("FLOAT","FLOAT");
		put("DECIMAL","DECIMAL");
		put("DATE","DATE");
		put("VARCHAR","VARCHAR");
		put("VARCHAR2","VARCHAR");
		put("NVARCHAR","VARCHAR");
		put("NVARCHAR2","VARCHAR");
		put("VARCHAR","VARCHAR");
		put("NCLOB","NCLOB");
		put("CLOB","CLOB");
		put("BLOB","BLOB");
		put("NCHAR","NCHAR");
		}};;
	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
		setJdbcType(convertDataTypeToJdbcType(dataType));
	}
	
	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getAttrname() {
		return attrname;
	}

	public void setAttrname(String attrname) {
		this.attrname = attrname;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	private String convertDataTypeToJdbcType(String dataType){
		String jdbcType = typeMap.get(dataType);
		if (jdbcType != null) {
			return jdbcType;
		}
		else {
			return "unknowType";
		}
	}
	@Override
	public String toString() {
		return "ColumnDO{" +
				"columnName='" + columnName + '\'' +
				", dataType='" + dataType + '\'' +
				", comments='" + comments + '\'' +
				", attrName='" + attrName + '\'' +
				", attrname='" + attrname + '\'' +
				", attrType='" + attrType + '\'' +
				", extra='" + extra + '\'' +
				'}';
	}
}
