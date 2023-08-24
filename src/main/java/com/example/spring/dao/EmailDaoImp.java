package com.example.spring.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.spring.model.Email;

@Repository
public class EmailDaoImp implements EmailDao{

	@Autowired
	   private SessionFactory sessionFactory;

	   @Override
	   public long save(Email email) {
	      sessionFactory.getCurrentSession().save(email);
	      return email.getId();
	   }

	   @Override
	   public Email get(long id) {
	      return sessionFactory.getCurrentSession().get(Email.class, id);
	   }

	   @Override
	   public List<Email> list() {
	      Session session = sessionFactory.getCurrentSession();
	      CriteriaBuilder cb = session.getCriteriaBuilder();
	      CriteriaQuery<Email> cq = cb.createQuery(Email.class);
	      Root<Email> root = cq.from(Email.class);
	      cq.select(root);
	      Query<Email> query = session.createQuery(cq);
	      return query.getResultList();
	   }

	   @Override
	   public void update(long id, Email email) {
	      Session session = sessionFactory.getCurrentSession();
	      Email email2 = session.byId(Email.class).load(id);
	      email2.setEmail(email.getEmail());
	      email2.setName(email.getName());
		  email2.setMessage(email.getMessage());
	      session.flush();
	   }

	   @Override
	   public void delete(long id) {
	      Session session = sessionFactory.getCurrentSession();
	      Email email = session.byId(Email.class).load(id);
	      session.delete(email);
	   }

    
}
