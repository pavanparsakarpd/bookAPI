package com.devtool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devtool.dao.BookRepository;
import com.devtool.entities.Book;

@Component
public class BookService {
	@Autowired
	BookRepository bookRepository;

	//private static List<Book> books=new ArrayList<Book>();
	
	/*
	 * static { books.add(new Book(0, "java", "James")); books.add(new Book(1, "C",
	 * "danies richi")); books.add(new Book(2,"Python","fdsjf")); }
	 */
	
	//get All books
	public List<Book>getAllBooks(){
		List<Book> list = (List<Book>) bookRepository.findAll();
		list.forEach(na->System.out.println(na));
		return list;
	}
	
	//get single books
	public Book getBookById(int id) {
		Book book=null;
		try {
		//book=books.stream().filter(e->e.getId()==id).findFirst().get();
		
			 book = bookRepository.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	//adding the book
	public Book addBook(Book b) {
		//books.add(b);
		Book save = bookRepository.save(b);
		return save;
	}
	
	
	//deleting book by id
	public void deleteBookById(int id) {
		/*
		 * books.stream().filter(book ->{
		 * 
		 * if(book.getId()==id) { return true; }else { return false; }
		 * }).collect(Collectors.toList());
		 */
		bookRepository.deleteById(id);
		
}
	
	//Update book by Id
	public void updateBookById(Book book,int bId) {
	/*books=	books.stream().map(v->{
			if(v.getId()==bId) {
				v.setTitle(book.getTitle());
				v.setAuther(book.getAuther());
			}
			return v;
			
		}).collect(Collectors.toList());
	}*/
		book.setId(bId);
		bookRepository.save(book);
	}
}
