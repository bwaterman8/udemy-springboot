package com.springframework.springwebapp.Bootstrap;

import com.springframework.springwebapp.Model.Author;
import com.springframework.springwebapp.Model.Book;
import com.springframework.springwebapp.Model.Publisher;
import com.springframework.springwebapp.Repositories.AuthorRepository;
import com.springframework.springwebapp.Repositories.BookRepository;
import com.springframework.springwebapp.Repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author jrr = new Author("JRR", "Tolkein");
        Book fellowship = new Book("Fellowship of the Ring", "1234");
        Publisher randy = new Publisher("Randy's Books", "23 Book rd, Columbus, Ohio");

        jrr.getBooks().add(fellowship);
        fellowship.getAuthors().add(jrr);
        randy.getBooks().add(fellowship);

        authorRepository.save(jrr);
        bookRepository.save(fellowship);
        publisherRepository.save(randy);


        Author jk = new Author("JK", "Rowling");
        Book sorcerer = new Book("Sorcerer's Stone", "4321");
        Publisher magic = new Publisher("Magical Books", "444 Wiz ln, Witchy, Liverpool");

        jk.getBooks().add(sorcerer);
        sorcerer.getAuthors().add(jk);
        magic.getBooks().add(sorcerer);

        authorRepository.save(jk);
        bookRepository.save(sorcerer);
        publisherRepository.save(magic);

        System.out.println("Started in SpringBoot");
        System.out.println("number of book: " + bookRepository.count());
        System.out.println("number of publishers: " + publisherRepository.count());
    }
}
