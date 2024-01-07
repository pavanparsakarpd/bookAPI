package com.devtool.dao;

import org.springframework.data.repository.CrudRepository;

import com.devtool.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public Book findById(int id);

}
