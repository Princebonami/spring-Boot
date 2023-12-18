package com.springboot.Jpa.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.Jpa.Entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
	
	public Book findById(int id);

}
