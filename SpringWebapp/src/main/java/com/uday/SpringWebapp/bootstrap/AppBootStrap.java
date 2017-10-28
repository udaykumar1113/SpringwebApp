package com.uday.SpringWebapp.bootstrap;



import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.uday.SpringWebapp.Repositories.AuthorRepository;
import com.uday.SpringWebapp.Repositories.BookRepository;
import com.uday.SpringWebapp.model.Author;
import com.uday.SpringWebapp.model.Book;

@Component
public class AppBootStrap implements ApplicationListener<ContextRefreshedEvent>
{
	//The beans are autowired as @Component annotation is added
	private AuthorRepository authorRepository;
	private BookRepository bookRepository;

	public AppBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
		//super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}


	//@Override
	public void onApplicationEvent(ContextRefreshedEvent ContextRefreshedEvent) {
		initData();
		
	}

	private void initData() {
		System.out.println("in context");
		Author author1=new Author("RR","Martin");
		Book book1=new Book("Game of Thrones","1345689","HBO");
		//Many to many relation is established here
		author1.getBooks().add(book1);
		book1.getAuthors().add(author1);
		
		Author author2=new Author("JK","Rowling");
		Book book2=new Book("Harry Potter 1","1276358","Bloomsbury");
		Book book3=new Book("Harry potter 2","1894567","Bloomsbury");
		author2.getBooks().add(book2);
		author2.getBooks().add(book3);
		book2.getAuthors().add(author2);
		book3.getAuthors().add(author2);
		
		authorRepository.save(author1);
		bookRepository.save(book1);
		
		authorRepository.save(author2);		
		bookRepository.save(book2);
		bookRepository.save(book3);
		
		
	}

}
