package com.dcs.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author zongzi
 *   基类
 * @param <T>
 */
public interface BaseDao<T> {

	/**
	 * 插入所有对象属性到数据库
	 * 
	 * @param entity,返回的的主键id在entity对应的主键属性中
	 * @return 返回插入的记录数
	 * @throws Exception
	 */
	public int insert(T entity) throws Exception;

	/**
	 * 批量插入数据到数据库
	 * 
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	public int insertBatch(List<T> entityList) throws Exception;

	/**
	 * 根据id查询实体对象所有属性
	 * 
	 * @param id
	 * @return 返回查询记录
	 * @throws Exception
	 */
	public T selectById(@Param("id")Object id,@Param("dataStatus") Object dataStatus) throws Exception;

	/**
	 * 查找所有记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<T> selectAll(Object dataStatus) throws Exception;

	/**
	 * 根据id删除记录
	 * 
	 * @param id
	 * @return 返回删除的条数
	 * @throws Exception
	 */
	public int deleteById(@Param("id")Object id,@Param("reviser")Object reviser) throws Exception;

	/**
	 * 根据实体类id更新实体所有属性
	 * 
	 * @param entity
	 * @return 返回更新的记录数
	 * @throws Exception
	 */
	public int update(T entity) throws Exception;

}