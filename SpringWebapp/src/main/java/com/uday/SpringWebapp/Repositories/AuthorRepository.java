package com.uday.SpringWebapp.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.uday.SpringWebapp.model.Author;

public interface AuthorRepository extends CrudRepository<Author, Long>{

}
