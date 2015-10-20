package com.ethertion.lab.webapp.rest;

import com.ethertion.lab.domain.Author;
import com.ethertion.lab.domain.Book;
import com.ethertion.lab.service.BookService;

import java.util.List;
import java.util.Optional;

import com.ethertion.lab.webapp.pojo.BookForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for the library.
 *
 * @author amiguel
 */
@RestController
@RequestMapping("/rest")
public class LibraryRESTController {

    private static final Logger logger = LoggerFactory.getLogger(LibraryRESTController.class);

    @Autowired
    private BookService bookService;

    /**
     * Finds a book by id.
     *
     * @param id
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(method = {RequestMethod.GET}, value = {"/book/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> findBook(@PathVariable("id") Long id) {

        Book book = null;
        try {
            book = (Book) bookService.find(id);
            if (book != null) {
                logger.debug("Finding book: " + book.toString());
            }else{
                return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Book>(book, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    /**
     * Finds all books.
     *
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(method = {RequestMethod.GET}, value = {"/books"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findAllBooks() {

        List<Book> books = null;
        try {
            books = bookService.findAll();
            logger.debug("Finding books: " + books.toString());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Object>(books, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Object>(books, HttpStatus.OK);
    }

    /**
     * Finds a book by title in the library.
     *
     * @param title
     * @param request
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(method = {RequestMethod.GET}, value = {"/book"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> findBookByTitle(@RequestParam("title") String title, HttpServletRequest request) {

        Book book = null;
        try {
            Optional<Book> opt = bookService.findByTitle(title);
            if (opt.isPresent()) {
                book = opt.get();
                logger.debug("Finding book by title: " + book.toString());
            }else {
                return new ResponseEntity<Book>(book, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Book>(book, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    /**
     * Saves a book.
     *
     * @param in
     * @return
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(method = {RequestMethod.POST}, value = {"/book"}, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Book> saveBook(@RequestBody(required = false) BookForm in) {

        Book book = null;

        try {
            if (in != null) {
                Optional<Book> opt = bookService.findByTitle(in.getTitle());
                if (opt.isPresent()) {
                    book = opt.get();
                } else {
                    book = new Book();
                    book.setTitle(in.getTitle());
                    Author author = new Author();
                    author.setFirstName(in.getAuthor());
                    book.setAuthor(author);
                    book = bookService.save(book);
                }
            }else{
                book = bookService.save(new Book());
            }
            logger.debug("Saving book: " + book.toString());
        }catch(Exception e){
            logger.error(e.getMessage(), e);
            return new ResponseEntity<Book>(book, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Book>(book, HttpStatus.OK);

    }

    /**
     * Deletes a book by id.
     *
     * @param id
     * @throws Exception
     */
    @SuppressWarnings("unchecked")
    @RequestMapping(method = {RequestMethod.DELETE}, value = {"/book/{id}"}, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Void> deleteBook (@PathVariable("id") Long id) {

        try {
            Book book = (Book) bookService.find(id);
            if (book!=null) {
                bookService.delete(id);
                logger.debug("Deleting book " + id);
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return ResponseEntity.status(HttpStatus.OK).build();

    }

    /**
     * Exception handler.
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handlerLoaderException (Exception e){
        logger.error(e.getMessage(), e);
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
