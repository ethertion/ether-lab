package com.ethertion.lab.service;

import com.ethertion.lab.domain.Author;
import com.ethertion.lab.domain.Book;
import com.ethertion.lab.domain.Editorial;
import com.ethertion.lab.repository.AuthorRepository;
import com.ethertion.lab.repository.BookRepository;
import com.ethertion.lab.repository.EditorialRepository;
import java.util.ArrayList;
import java.util.List;
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
        @Autowired
        AuthorRepository authorRepository;
        @Autowired
        EditorialRepository editorialRepository;
       
        public BookServiceITTest() {
        }
                     
        @Before
        public void setUp() throws Exception{
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
                
                Book book = new Book();
                book.setId(1L);
                book.setTitle("The Neverending Story");
                book.setAuthor(author);
                book = bookRepository.save(book);         
        }        

        @Test        
        public void findByTitle() {                
                Optional<Book> opt = bookRepository.findByTitle("The Neverending Story");                
                assertNotNull(opt.get());
        }
        
        public BookRepository getBookRepository() {
                return bookRepository;
        }

        public void setBookRepository(BookRepository bookRepository) {
                this.bookRepository = bookRepository;
        }
        
        
        
}
