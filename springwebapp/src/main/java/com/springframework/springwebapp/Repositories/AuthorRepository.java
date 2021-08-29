package com.springframework.springwebapp.Repositories;

import com.springframework.springwebapp.Model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
