package com.ethertion.lab.service;

import com.ethertion.lab.domain.Book;
import com.ethertion.lab.repository.BookRepository;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Optional;
import javax.transaction.Transactional;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author amiguel
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-service.xml"})
public class BookServiceITTest {
        
        @Autowired
        BookRepository bookRepository;
       
        public BookServiceITTest() {
        }
                     
        @Before
        public void setUp() throws Exception{
                Book book = new Book();
                book.setId(1L);
                book.setTitle("Star Wars");
                book = bookRepository.save(book);
        }        

        @Test        
        public void findByTitle() {                
                Optional<Book> opt = bookRepository.findByTitle("Star Wars");                
                assertNotNull(opt.get());
        }

        public BookRepository getBookRepository() {
                return bookRepository;
        }

        public void setBookRepository(BookRepository bookRepository) {
                this.bookRepository = bookRepository;
        }
        
        
        
}
