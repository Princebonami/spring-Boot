package com.boot.RestApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.RestApi.Entities.Book;
import com.boot.RestApi.Service.BookService;

@RestController
public class BookController {
  
  @Autowired
  private BookService bookService;
   @GetMapping("/books")
   // here we have to send the status that wheather the books found or not so there is a class ResponseEntity that class is used to send the status.
  public ResponseEntity<List<Book>> getBooks()
  {
	   List<Book> list=bookService.getBooks();
	   if(list.size()<=0)
	   {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   }
	   return ResponseEntity.of(Optional.of(list));
	  
  }
   
   @GetMapping("/books/{id}")
   public ResponseEntity<Book> getBook(@PathVariable("id") int id)
   {
	   Book book=bookService.getBookById(id); 
	   if(book==null)
	   {
		   return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	   }
	  return ResponseEntity.of(Optional.of(book));
   }
   
   @PostMapping("/books")
   public ResponseEntity<Book> addBook(@RequestBody  Book book)
   {
	   System.out.println(book);
	   Book b=null;
	   b=bookService.addBook(book);
	   if(b==null)
	   {
		   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	   }
	   else
	   {
		   return ResponseEntity.ok(b);
	   }
	  
	  
   }
   
   @DeleteMapping("/books/{id}")
   public ResponseEntity<Void> dleteBookById(@PathVariable("id") int id)
   {
	   try {
		   bookService.deleteBookById(id);
		   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	   }
	   catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	  
	   
   }
   
   @PutMapping("/books/{id}")
   public Book updateBook(@RequestBody Book book,@PathVariable("id") int id)
   {
	  Book book1= bookService.updateBook( book, id);
	  return book1;
   }

}
