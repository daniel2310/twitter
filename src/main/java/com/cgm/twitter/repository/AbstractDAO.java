package com.cgm.twitter.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@EnableTransactionManagement
public abstract class AbstractDAO<E> {

	@PersistenceContext(name = "twitter-spa")
	private EntityManager em;

	private final Class<E> entityClass;

	protected AbstractDAO(final Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Transactional
	public EntityManager em() {
		return em;
	}

	@Transactional
	public E findById(final Long entityId) {
		return em.find(entityClass, entityId);
	}

	@Transactional
	public void save(final E entityToBeSaved) {
		em.persist(entityToBeSaved);
	}

	@Transactional
	public void update(final E entityToBeUpdated) {
		em.merge(entityToBeUpdated);
	}

	@Transactional
	public void remove(final E entityToBeRemoved) {
		em.remove(entityToBeRemoved);
	}

	@Transactional
	public void delete(final Long id) {
		em.remove(findById(id));
	}

	@Transactional
	@SuppressWarnings({ "rawtypes", "unchecked" })
	 public E findByName(final String entityName) {
		E result = null;
		try { 
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<E> cq = cb.createQuery(entityClass);
			Root root = cq.from(entityClass);
			cq.select(root);
			cq.where(cb.equal(root.get("name"), entityName));
			TypedQuery<E> q = em.createQuery(cq);
			result = q.getSingleResult();
		} 
	  catch  (Exception e) {
		  System.out.println("invalid USERNAME or PASSWORD");
	}
		  return  result;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> findAll() {
		return (List<E>) em.createQuery(new StringBuilder().append("SELECT entity FROM ")
				.append(entityClass.getCanonicalName()).append(" entity ").toString()).getResultList();
	}

}
