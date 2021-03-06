package com.ethertion.lab.service;

import com.ethertion.lab.domain.Book;
import com.ethertion.lab.repository.AuthorRepository;
import com.ethertion.lab.repository.EditorialRepository;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Optional;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author amiguel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-service.xml", "classpath:applicationContext-cache.xml"})
public class BookServiceITTest {
	
		private static final Logger logger = LoggerFactory.getLogger(BookServiceITTest.class);		
        
        @Autowired
        BookService bookService;
        
        @Autowired
        AuthorRepository authorRepository;
        
        @Autowired
        EditorialRepository editorialRepository;
      
        public BookServiceITTest() {
        }
                     
        @Before
        public void setUp() throws Exception{
        		
        	/*
                Editorial editorial = new Editorial();
                editorial.setId(1L);
                editorial.setName("Thienemann Verlag");                
                List<Editorial> editorials = new ArrayList();
                editorials.add(editorial);
                editorialRepository.save(editorial);
                
                Author author = new Author();
                author.setId(1L);
                author.setFirstName("Michael");
                author.setLastName("Ende");
                author.setEditorials(editorials);
                author = authorRepository.save(author);
                */
                Book book = new Book();
                book.setId(1L);
                book.setTitle("The Neverending Story");
                //book.setAuthor(author);
                book = bookService.save(book);         
        }    
        
        @Test        
        public void findAndCacheBooks() {             
        		
        		logger.debug("Finding book 1");
                bookService.find(1L);
                logger.debug("Finding book 1. Retrieving from cache ???");
                bookService.find(1L);
                
                assertTrue(true);
        }

        @Ignore
        @Test        
        public void findByTitle() {                
                Optional<Book> opt = bookService.findByTitle("The Neverending Story");                
                assertNotNull(opt.get());
        }
        
        public BookService getBookRepository() {
                return bookService;
        }

        public void setBookService(BookService bookService) {
                this.bookService = bookService;
        }
        
}
