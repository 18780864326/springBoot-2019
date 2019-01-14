package org.baseRepository.first;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 
 * <p>Project: Jpa</p>
 * <p>Description: </p>
 * <p>Copyright (c) 2019 LionCredo.All Rights Reserved.</p>
 * @author C3005890</a>
 */
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable> extends JpaRepository<T,ID>  {
	/**
	 *  传入SQL查询语句 返回结果集
	 * @param sql语句 
	 * @return	 List 的 数据集  Object[] 结果根据sql 映射的顺序
	 */
	 List<Object[]> listBySqlToListObj(String sql);
	 
	 /**
		 *  传入SQL查询语句 返回结果集
		 *  类型必须被 容器托管（有映射关系）
		 * @param sql语句 
		 * @return	  指定了返回有映射关系的实体类型 List 
		 */
		 List<T> listBySqlToListEntity(String sql,Class<T> resultClass);
		
		 /**
			 *  传入SQL查询语句 返回结果集 映射结果为一列
			 * @param sql语句 
			 * @return	  指定了返回的String类型 List 
			 */
		 List<String>  listBySqlAndOneColumnToListStr(String sql);

	 /**
		 *  获取当前序列的下一个值（用于保存新数据时得到自增id）
		 * @param 传入 数据库中 序列名
		 * @return	 值
		 */
		 Long getTableSequencesToLong(String sqlsequences);
		 
		 /**
		  * 根据 sql 语句查询 ， 返回row 用 map包装 
		  * key 为 映射列的全大写字母  值 为其对应值
		  * 效率略低
		  * @param sql
		  * @return List<Map<String,Object>>
		  * @todo 建议使用 ListBySqlToDto方法
		  */
		 @Deprecated
		 List<Map<String,Object>> listBySqlToMap(String sql);
		 
		 /**
		  *  传入  要统计计数 sql 语句 
		  *  自动 拼装 select count
		  * @param sql
		  * @return 返回 总数 Long 类型
		  */
		 Integer countBySqlToInteger(String sql)
		 ;	
		 
		 /**
		  * 传入  要分页的  sql 语句
		  * 自动 拼接 rownum 进行 分页 
		  * @param sql 
		  * @param startIndex	开始下标
		  * @param endIndex	结束下标
		  * @return 结果集合 map<String,Object>
		  * @todo 建议使用 ListBySqlToDto方法
		  */
		 @Deprecated
		 List<Map<String,Object>> ListBySqlAndPageInfoToMap(String sql,Integer startIndex , Integer endIndex);	
		 
		 /**
		  * 传入  要分页的  sql 语句
		  * 自动 拼接 rownum 进行 分页 
		  * @param sql 
		  * @param startIndex	开始下标
		  * @param endIndex	结束下标
		  * @return 结果集合 map<String,Object>
		  * @todo 建议使用 ListBySqlToDto方法
		  */
		 @Deprecated
		 List<?> ListBySqlAndPageInfoToListDto(String sql,Integer startIndex , Integer endIndex,Class<?> _class);	
		 
		 
		 /**
		  *  <p>传入 要查询的sql
		  *  可以应用原始SQL查询，允许它返回非托管实体
		  *  要求Dto 的属性名与 结果集的列名必须一一对应 
		  *  因为Oracle 数据库 自动结果集列名大写 请加上 as "属性名" 
		  *  防止自动初始化为大写.
		  *  <p>
		  *  <code>
		  *  select 	
		  *  	t.id as \"id\" ,
		  *  	t.user_name as \"userName\"  ,
		  *  	t.password as \"password\"  
		  *  from TEST_USER t
		  *  </code>
		  *  <p>Dto 数字类型 必须写  java.lang.Number<p>
		  * @param sql  
		  * @param  _class Dto 类型
		  * @return 结果集
		  */
		 List<?> ListBySqlToDto(String sql ,Class<?> _class);
}

