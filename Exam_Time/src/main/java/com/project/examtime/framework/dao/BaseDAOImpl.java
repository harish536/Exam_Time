package com.project.examtime.framework.dao;


	import java.io.Serializable;
	import java.util.List;

	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import javax.persistence.TypedQuery;
	import javax.persistence.criteria.CriteriaBuilder;
	import javax.persistence.criteria.CriteriaQuery;
	import javax.persistence.criteria.Root;

	import org.springframework.util.Assert;

	/**
	 * 
	 * @author Harish
	 *
	 */
	public class BaseDAOImpl<T, ID extends Serializable> implements BaseDAO<T, ID> {

		@PersistenceContext
		protected EntityManager entityManager;

		private Class<T> domainClass;

		public BaseDAOImpl(Class<T> domainClass) {
			this.domainClass = domainClass;
		}

		@Override
		public T findOne(ID id) {
			return (entityManager.find(domainClass, id));
		}

		@Override
		public List<T> findAll() {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<T> query = builder.createQuery(domainClass);
			Root<T> root = query.from(domainClass);
			query.select(root);

			return (entityManager.createQuery(query).getResultList());
		}

		@Override
		public long count() {
			CriteriaBuilder builder = entityManager.getCriteriaBuilder();
			CriteriaQuery<Long> query = builder.createQuery(Long.class);
			Root<T> root = query.from(domainClass);
			query.select(builder.count(root));
			return (entityManager.createQuery(query).getSingleResult());
		}

		@Override
		public <S extends T> S create(S entity) {
			entityManager.persist(entity);
			return (entity);
		}

		@Override
		public <S extends T> S update(S entity) {
			if (!entityManager.contains(entity)) {
				entity = entityManager.merge(entity);
			}
			return (entity);
		}

		/**
		 * updates all entities
		 */
		public void updateAll(List<T> entities) {
			for (T entity : entities) {
				update(entity);
			}
		}

		@Override
		public void delete(T entity) {
			Assert.notNull(entity, "The entity must not be null!");
			entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
		}

		@Override
		public void deleteAll(Iterable<? extends T> entities) {
			Assert.notNull(entities, "The given Iterable of entities must not be null!");
			for (T entity : entities) {
				delete(entity);
			}
		}

		/**
		 * Return a string representation of a Criteria Query
		 */
		public String toQueryString(TypedQuery<?> typedQuery) {
			return typedQuery.unwrap(org.hibernate.Query.class).getQueryString();
		}

		@Override
		public void detach(T entity) {
			this.entityManager.detach(entity);
		}

		@Override
		public void batchCreate(List<T> entities, int batchSize) {
			int count = 0;
			for (T entity : entities) {
				entityManager.persist(entity);
				if (count % batchSize == 0) {
					entityManager.flush();
					entityManager.clear();
				}
			}
		}

		@Override
		public void batchCreate(List<T> entities) {
			for (T entity : entities) {
				entityManager.persist(entity);
			}
		}
	}

