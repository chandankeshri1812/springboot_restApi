package com.restApi.dao;

import org.springframework.data.repository.CrudRepository;

import com.restApi.models.Book;

public interface BookRespository extends CrudRepository<Book,Integer>{

	public Book findById(int id);
	
}
