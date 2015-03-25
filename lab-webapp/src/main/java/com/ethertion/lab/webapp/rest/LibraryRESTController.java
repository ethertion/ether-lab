package com.ethertion.lab.webapp.rest;

import com.ethertion.lab.domain.Author;
import com.ethertion.lab.domain.Book;
import com.ethertion.lab.service.BookService;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST Controller for the library.
 * @author amiguel
 */
@RestController
@RequestMapping("/rest")
public class LibraryRESTController {

        private static final Logger logger = Logger.getLogger(LibraryRESTController.class);

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
        @RequestMapping(method = {RequestMethod.GET}, value = {"/book/{id}"}, produces = "application/json")
        public @ResponseBody
        Book findBook(@PathVariable("id") Long id) throws Exception {

                Book book = null;
                try {
                        book = (Book) bookService.find(id);
                } catch (Exception e) {
                        logger.error(e.getMessage());
                        throw new Exception("Could not find book by id: " + id, e);
                }

                return book;
        }

        /**
         * Finds all books.
         * @return
         * @throws Exception 
         */
        @SuppressWarnings("unchecked")
        @RequestMapping(method = {RequestMethod.GET}, value = {"/books"}, produces = "application/json")
        public @ResponseBody
        List<Book> findBooks() throws Exception {

                List<Book> books = null;
                try {
                        books = bookService.findAll();
                } catch (Exception e) {
                        logger.error(e.getMessage());
                        throw new Exception("Could not find books", e);
                }

                return books;
        }

        /**
         * Finds a book in the library.
         *
         * @param <L>
         * @param title
         * @param request
         * @return
         * @throws Exception
         */
        @SuppressWarnings("unchecked")
        @RequestMapping(method = {RequestMethod.GET}, value = {"/book/title/{title}"}, produces = "application/json")
        public @ResponseBody
        Book findBookByTitle(
                @PathVariable("title") String title,
                HttpServletRequest request) throws Exception {

                Book book = null;
                try {
                        Optional<Book> opt = bookService.findByTitle(title);
                        if (opt.isPresent()) {
                                book = opt.get();
                        }
                } catch (Exception e) {
                        logger.error(e.getMessage());
                        throw new Exception("Could not find book by title: " + title, e);
                }

                return book;
        }
      
        /**
         * Saves a book.
         * @param in
         * @return
         * @throws Exception 
         */
        @SuppressWarnings("unchecked")
        @RequestMapping(method = {RequestMethod.POST}, value = {"/book"}, produces = "application/json")
        public @ResponseBody
        Book saveBook(@RequestBody com.ethertion.lab.webapp.pojo.Book in) throws Exception{               
                
                Book book = null;
                
                try {
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
                } catch (Exception e) {
                        logger.error(e.getMessage());
                        throw new Exception("Could not save book: " + in.toString());
                }

                return book;
        }
        
        @SuppressWarnings("unchecked")
        @RequestMapping(method = {RequestMethod.DELETE}, value = {"/book/{id}"}, produces = "application/json")
        public @ResponseBody
        void deleteBook(@PathVariable("id") Long id) throws Exception{               
              
                try {
                        bookService.delete(id);
                } catch (Exception e) {
                        logger.error(e.getMessage());
                        throw new Exception("Could not delete book: " + id.toString());
                }
                
        }        

}
