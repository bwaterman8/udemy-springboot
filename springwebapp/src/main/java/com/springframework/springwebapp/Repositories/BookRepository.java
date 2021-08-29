package com.springframework.springwebapp.Repositories;

import com.springframework.springwebapp.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
