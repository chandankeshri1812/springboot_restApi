package com.restApi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restApi.models.Book;
import com.restApi.services.BookServices;

@RestController
public class BookController {

	@Autowired
	private BookServices bookServices;

//	@ResponseBody
//	or
//	@RequestMapping(value="/books",method=RequestMethod.GET)
//	@GetMapping("/books")
//	public Book getBooks() {
//		
//		Book book = new Book();
//		book.setId(123);
//		book.setTitle("The epic shit");
//		book.setAuthor("Ankur");
//		
//		return book;
//	}
	
	

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookServices.getALlBooks();
		if(books.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(books);
	}
	
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id") int id) {

		Book book=bookServices.getALlBookById(id);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(book));
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b =this.bookServices.addBook(book);
		
		return b;
	}
	
	
	@DeleteMapping("books/{booksId}")
	public void deleteBook(@PathVariable("booksId") int booksId) {
		
	this.bookServices.deleteBook(booksId);
		
	}
	

}
