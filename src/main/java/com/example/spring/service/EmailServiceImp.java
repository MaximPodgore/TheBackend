package com.example.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.dao.EmailDao;
import com.example.spring.model.Email;


@Service
@Transactional(readOnly = true)
public class EmailServiceImp implements EmailService {

   @Autowired
   private EmailDao emailDao;

   @Transactional
   @Override
   public long save(Email email) {
      return emailDao.save(email);
   }

   @Override
   public Email get(long id) {
      return emailDao.get(id);
   }

   @Override
   public List<Email> list() {
      return emailDao.list();
   }

   @Transactional
   @Override
   public void update(long id, Email email) {
      emailDao.update(id, email);
   }

   @Transactional
   @Override
   public void delete(long id) {
      emailDao.delete(id);
   }
}
