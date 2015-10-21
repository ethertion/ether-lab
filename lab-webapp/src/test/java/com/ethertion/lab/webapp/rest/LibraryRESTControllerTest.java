package com.ethertion.lab.webapp.rest;

import com.ethertion.lab.domain.Book;
import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Test case for the library.
 *
 * @author amiguel
 * {@code
 * http://localhost:8080/lab-webapp/book/1/ (GET) (Finds a book with id 1)
 * http://localhost:8080/lab-webapp/books/ (GET) (Finds all books)
 * http://localhost:8080/lab-webapp/book/?title=Batman (GET) (Finds a book by title 'Batman')
 * http://localhost:8080/lab-webapp/book/ (POST) (Saves a book. Title and author parameters as input in json format are optional, i.e: {"title": "Batman", "author": "Bob Kane"})
 * http://localhost:8080/lab-webapp/book/1/ (DELETE) (Deletes the book with id 1)
 * }
 */
public class LibraryRESTControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(LibraryRESTController.class);

    private RestTemplate restTemplate = new RestTemplate();

    @Test
    public void findBookByTitle (){
        logger.debug("Find book by title");
        Book book = saveBook("Batman");
        book = restTemplate.getForObject("http://localhost:8080/lab-webapp/rest/book/" + book.getId(), Book.class);
        logger.debug(book.toString());
        assertNotNull(book);
    }

    @Test
    public void findBook (){
        logger.debug("Find book");
        Book book = saveBook(null);
        ResponseEntity<Book> response = restTemplate.getForEntity("http://localhost:8080/lab-webapp/rest/book/" + book.getId(), Book.class);
        logger.debug(response.getBody().toString());
        assertNotNull(response.getBody());
    }

    @Test
    public void findAllBooks (){
        logger.debug("Find all books");
        Book book = saveBook("Star Wars");
        ResponseEntity<List<Book>> response = restTemplate.exchange("http://localhost:8080/lab-webapp/rest/books/",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Book>>() {} );
        List<Book> books = response.getBody();
        logger.debug(books.toString());
        assertNotNull(books);
    }

    @Test
    public void deleteBook (){
        logger.debug("Delete book");
        Book book = saveBook(null);
        restTemplate.delete("http://localhost:8080/lab-webapp/rest/book/" + book.getId());
        assertTrue(true);
    }

    private Book saveBook(String title){
        Book book = new Book();
        book.setTitle(title);
        ResponseEntity<Book> response = restTemplate.postForEntity("http://localhost:8080/lab-webapp/rest/book/", book, Book.class);
        return response.getBody();
    }

}
