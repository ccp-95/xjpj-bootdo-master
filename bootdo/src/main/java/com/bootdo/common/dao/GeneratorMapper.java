package com.bootdo.common.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface GeneratorMapper {
	@Select("select t.table_name tableName,'oracle' engine,t.comments tableComment,sysdate createTime from user_tab_comments t"
			+ "")
	List<Map<String, Object>> list();

	@Select("select count(*) from from user_tables t")
	int count(Map<String, Object> map);

	@Select("select t.table_name tableName,'oracle' engine,t.comments tableComment,sysdate createTime from user_tab_comments t "
			+ "	where  t.table_name = #{tableName}")
	Map<String, String> get(String tableName);

	@Select("select t.column_name columnName, t.data_type dataType, c.comments columnComment,CASE WHEN cu.column_name = t.COLUMN_NAME then 'PRI' else '' end as COLUMBKEY "
			+ " from user_tab_columns t,user_col_comments c,user_cons_columns cu, user_constraints au "
			+ " where t.table_name = c.table_name and t.column_name = c.column_name and t.table_name = #{tableName} and au.table_name=t.table_name and cu.constraint_name = au.constraint_name and au.constraint_type = 'P' order by t.column_id")
	List<Map<String, String>> listColumns(String tableName);
}
