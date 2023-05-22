package com.restApi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.restApi.dao.BookRespository;
import com.restApi.models.Book;


@Component
public class BookServices {

//	private static List<Book> list =new ArrayList<>();
//	
//	
//	static {
//		list.add(new Book(12,"java complete Reference", "XYZ"));
//		list.add(new Book(1,"python complete Reference", "pqr"));
//		list.add(new Book(13,"go complete Reference", "abc"));
//		list.add(new Book(2,"c complete Reference", "yxz"));
//
//	}
	
	@Autowired
	private BookRespository bookRespository;
	
	
	
	
	// get all books
	public List<Book> getALlBooks(){
		List<Book> list= (List<Book>)this.bookRespository.findAll();
		return list;
	}
	
	
	// get single books by id
	public Book getALlBookById(int id){
		
		Book book =null;
		try {
//			book = list.stream().filter(e->e.getId()==id).findFirst().get();
			book  = this.bookRespository.findById(id);

		}catch(Exception e){
			e.printStackTrace();
		}
		return book;
	}
	
	// adding books
	public Book addBook(Book b) {
	Book book=bookRespository.save(b);
//		list.add(b);
		return book;
		
	}
	
	// delete books
	public void deleteBook( int bid) {
		
//		list =list.stream().filter(book->{
//			if(book.getId()!=bid) {
//				return true;
//			}else 
//				return false;
//			
//		}).collect(Collectors.toList());
		
		// or
		
//		list =list.stream().filter(book->book.getId()!=bid).collect(Collectors.toList());
		
		bookRespository.deleteById(bid);
	}
	
}
