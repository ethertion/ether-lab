package com.ethertion.lab.service.impl;

import com.ethertion.lab.domain.Book;
import com.ethertion.lab.repository.BookRepository;
import org.springframework.stereotype.Service;
import com.ethertion.lab.service.BookService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author amiguel
 */
@Service("bookService")
public class BookServiceImpl implements BookService{
        
        @Autowired
        BookRepository bookRepository;
        
        @Override
        public Optional<Book> findByTitle(String title){
               return bookRepository.findByTitle(title);
        }
        
        
}
