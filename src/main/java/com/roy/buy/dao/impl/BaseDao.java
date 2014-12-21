package com.roy.buy.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.roy.buy.dao.IBaseDao;

public class BaseDao<T extends Serializable> implements IBaseDao<T> {
	
	/**
	 * Entity
	 */
	private Class<T> clazz;
	
	/**
	 * 自動注入SessionFactory
	 */
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	public BaseDao() {
		
	}
	
	public BaseDao(final Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public int save(T entity) {
		return (int) getSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getSession().update(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		getSession().saveOrUpdate(entity);
	}

	@Override
	public void delete(T entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getSession().createCriteria(clazz).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(int id) {
		return (T) getSession().get(clazz, id);
	}
	
	/**
	 * 根據欄位名稱與查詢條件, 回傳Entity
	 */
	@SuppressWarnings("unchecked")
	public T findBy(String columnName, Object value) {
		T entity = null;
        Criteria criteria = getSession().createCriteria(clazz);    
        criteria.add(Restrictions.in(columnName, new Object[]{value}));
        if(criteria.list().size() > 0) {
        	entity = (T) criteria.list().get(0); 
        }
        return entity;
    }
	
	/**
	 * 根據欄位名稱與查詢條件, 回傳Entity List
	 */
	@SuppressWarnings("unchecked")
	public List<T> findListBy(String columnName, Object value) {
        Criteria criteria = getSession().createCriteria(clazz);    
        criteria.add(Restrictions.in(columnName, new Object[]{value}));
        return criteria.list();
    }
	
	public Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

}
