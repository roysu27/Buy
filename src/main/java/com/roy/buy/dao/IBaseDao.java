package com.roy.buy.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 基礎Dao, 繼承時需宣告T是哪種Entity
 */
public interface IBaseDao<T extends Serializable> {

	/**
	 * 新增Entity, 回傳ID
	 */
	public int save(T entity);

	/**
	 * 修改Entity
	 */
	public void update(T entity);

	/**
	 * 新增或修改Entity, 用ID區別功能
	 */
	public void saveOrUpdate(T entity);

	/**
	 * 刪除Entity
	 */
	public void delete(T entity);

	/**
	 * 查詢整個Table, 取得Entity List
	 */
	public List<T> findAll();

	/**
	 * 根據ID, 查詢Entity
	 */
	public T findById(int id);

}
