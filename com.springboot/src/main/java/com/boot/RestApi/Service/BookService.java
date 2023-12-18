package com.boot.RestApi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.boot.RestApi.Entities.Book;

@Component
public class BookService {
	
	static List<Book> libook=new ArrayList<Book>();
	
	static
	{
		libook.add(new Book(123,"THE complete refrence book","Prince Kumar"));
		libook.add(new Book(124,"Mathematical power","Sakshi Singh"));
		libook.add(new Book(125,"Computer Science","Piyush Kumar"));
		libook.add(new Book(126,"Hello everyone ","Swati Singh"));
		
	}
	// get single book
	public Book getBookById(int id)
	{
		for(Book e :libook)
		{
			if(e.getId()==id)
			{
				return e;
			}
		}
		return null;
	}
	
	// get complete book
	public List<Book> getBooks()
	{
		return libook;
	}
	
	// adding book
	public Book addBook(Book b)
	{
		libook.add(b);
		return b;
	}
	// deleting books on the babsis of id
	
	public void deleteBookById(int id)
	{
		libook=libook.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
	}
	
	// update particular book
	
	public Book updateBook(Book book,int id)
	{
		for(Book b :libook)
		{
			if(b.getId()==id)
			{
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
				return b;
			}
		}
		return null;
	}

}
