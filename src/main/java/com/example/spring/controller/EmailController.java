package com.example.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.model.Email;
import com.example.spring.service.EmailService;


@CrossOrigin(origins = "*")
@RestController
public class EmailController {

   @Autowired
   private EmailService emailService;

   /*---Add new book---*/
   @PostMapping("/email")
   public ResponseEntity<?> save(@RequestBody Email email) {
	  System.out.println("the json value of book is :::::: "+email);
      long id = emailService.save(email);
      return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
   }
   
   /*---Get a book by id---*/
   @GetMapping("/email/{id}")
   public ResponseEntity<Email> get(@PathVariable("id") long id) {
      Email email = emailService.get(id);
      return ResponseEntity.ok().body(email);
   }  

   /*---get all books---*/
   @GetMapping("/email")
   public ResponseEntity<List<Email>> list() {
      List<Email> emails = emailService.list();
      return ResponseEntity.ok().body(emails);
   }

   /*---Update a book by id---*/
   @PutMapping("/email/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Email email) {
      emailService.update(id, email);
      return ResponseEntity.ok().body("Email has been updated successfully.");
   }

   /*---Delete a book by id---*/
   @DeleteMapping("/email/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      emailService.delete(id);
      return ResponseEntity.ok().body("Email has been deleted successfully.");
   }
}