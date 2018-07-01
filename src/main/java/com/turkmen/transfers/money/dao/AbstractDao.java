/**
 * 
 */
package com.turkmen.transfers.money.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author TTTDEMIRCI
 *
 */
public abstract class AbstractDao<K extends Serializable, T> {

	private final Class<T> persistentClass;

	private EntityManagerFactory entityManagerFactory;

	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public AbstractDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
		this.entityManagerFactory = Persistence.createEntityManagerFactory("moneytransfer");
		this.entityManager = this.entityManagerFactory.createEntityManager();
		this.beginTransaction();
	}

	private void beginTransaction() {
		this.entityManager.getTransaction().begin();
	}

	private void commitTransaction() {
		this.entityManager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public T getByKey(K key) {
		return (T) this.entityManager.find(persistentClass, key);
	}

	public void persist(T entity) {

		this.entityManager.persist(entity);
		this.commitTransaction();

	}

	public void merge(T entity) {

		this.entityManager.merge(entity);
		this.commitTransaction();

	}

	public void delete(T entity) {

		this.entityManager.remove(entity);
		this.commitTransaction();

	}

	@SuppressWarnings("unchecked")
	protected List<T> getAllEntities() {

		return this.entityManager.createQuery("Select t from " + persistentClass.getSimpleName() + " t")
				.getResultList();

	}

}
