package com.devtool.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devtool.entities.Book;
import com.devtool.service.BookService;


@RestController
public class BookController {
	@Autowired
	BookService bookService;
	

	@GetMapping(value ="/books")
	@ResponseBody
	public List<Book> getBooks() {
		List<Book> allBooks = this.bookService.getAllBooks();
		allBooks.forEach(na->System.out.println(na));
		return allBooks;
		
	}
	
	@GetMapping(value="/books/{id}")
	public ResponseEntity<Book> getBook(@PathVariable("id")int id) {
		Book bookById = this.bookService.getBookById(id);
		if(bookById==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
		
	}
	@PostMapping(value = "/books")
	public Book addBook(@RequestBody Book book) {
		Book addBook = this.bookService.addBook(book);
		return book;
		
	}
	
	
	//Delete book by id
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable("id")int id) {
		
		this.bookService.deleteBookById(id);
		
	}
	
// update book by id
	@PutMapping(value="/books/{bId}")
	public Book updateBookById(@RequestBody Book book,@PathVariable("bId") int bId) {
		this.bookService.updateBookById(book, bId);
		return book;
		
	}
	
}
