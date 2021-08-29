package com.springframework.springwebapp.Bootstrap;

import com.springframework.springwebapp.Model.Author;
import com.springframework.springwebapp.Model.Book;
import com.springframework.springwebapp.Repositories.AuthorRepository;
import com.springframework.springwebapp.Repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author jrr = new Author("JRR", "Tolkein");
        Book fellowship = new Book("Fellowship of the Ring", "1234");

        jrr.getBooks().add(fellowship);
        fellowship.getAuthors().add(jrr);

        authorRepository.save(jrr);
        bookRepository.save(fellowship);

        System.out.println("Started in SpringBoot");
        System.out.println("number of book: " + bookRepository.count());

    }
}
