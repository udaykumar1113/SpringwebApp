package com.uday.Spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.uday.SpringWebapp.model.Book;

public interface BookRepository extends CrudRepository<Book,Long>{

}
