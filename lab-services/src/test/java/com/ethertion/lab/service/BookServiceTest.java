/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class BookServiceTest {
        
        @Autowired
        BookRepository bookRepository;

        public BookServiceTest() {
        }

        @Test
        public void findByTitle() {
                Optional<Book> book = bookRepository.findByTitle("Star Wars");
                assertNotNull(book);
        }

        public BookRepository getBookRepository() {
                return bookRepository;
        }

        public void setBookRepository(BookRepository bookRepository) {
                this.bookRepository = bookRepository;
        }
        
        
        
}
