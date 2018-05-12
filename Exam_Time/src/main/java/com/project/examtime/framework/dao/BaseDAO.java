package com.project.examtime.framework.dao;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author Harish
 *
 */
public interface BaseDAO<T, ID extends Serializable> {

	T findOne(ID id);

	List<T> findAll();

	long count();

	<S extends T> S create(S entity);

	<S extends T> S update(S entity);

	void delete(T entity);

	void deleteAll(Iterable<? extends T> entities);

	void detach(T entity);

	void batchCreate(List<T> entities, int batchSize);

	void batchCreate(List<T> entities);

	public void updateAll(List<T> entities);
}
