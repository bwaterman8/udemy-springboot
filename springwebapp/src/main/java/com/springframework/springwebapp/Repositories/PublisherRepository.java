package com.springframework.springwebapp.Repositories;

import com.springframework.springwebapp.Model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
