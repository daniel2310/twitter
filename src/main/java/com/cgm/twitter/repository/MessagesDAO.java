package com.cgm.twitter.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cgm.twitter.domain.Message;

@Repository
public class MessagesDAO<E> extends AbstractDAO<Message> {

	protected MessagesDAO() {
		super(Message.class);
	}

	@Autowired
	@PersistenceContext(name = "twitter-spa")
	private EntityManager em;

	@Transactional
	public EntityManager em() {
		return em;
	}

	@Transactional
	public void updateMessage(final E entityToBeUpdate) {
		em.merge(entityToBeUpdate);

	}
}
