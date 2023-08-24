package com.example.spring.service;

import java.util.List;

import com.example.spring.model.Email;

public interface EmailService {

    long save(Email email);

	Email get(long id);

	List<Email> list();

	void update(long id, Email email);

	void delete(long id);
}