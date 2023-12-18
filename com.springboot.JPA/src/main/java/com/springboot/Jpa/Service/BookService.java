package com.springboot.Jpa.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springboot.Jpa.Entities.Book;
import com.springboot.Jpa.dao.BookRepository;

@Component
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	// get single book
	public Book getBookById(int id)
	{
		Book  book= bookRepository.findById(id);
		return book;
	}
	
	// get complete book
	public List<Book> getBooks()
	{
	 List<Book> list=(List<Book>)bookRepository.findAll();
	 return list;
	}
	
	// adding book
	public Book addBook(Book b)
	{
		Book book=bookRepository.save(b);
		return book;
	}
	// deleting books on the babsis of id
	
	public void deleteBookById(int id)
	{
		bookRepository.deleteById(id);
	}
	
	// update particular book
	
	public void updateBook(Book book,int id)
	{
		book.setId(id);
		bookRepository.save(book);
		
	}

}
