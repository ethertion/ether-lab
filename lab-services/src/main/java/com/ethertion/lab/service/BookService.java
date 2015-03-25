package com.ethertion.lab.service;

import com.ethertion.lab.domain.Book;
import java.util.Optional;

/**
 *
 * @author amiguel
 */
public interface BookService extends BaseService<Book>{
        
        public Optional<Book> findByTitle(String title);
        public Book save(String title);
        
}
