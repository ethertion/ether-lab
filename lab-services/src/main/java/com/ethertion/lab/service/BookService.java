/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethertion.lab.service;

import com.ethertion.lab.domain.Book;
import java.util.Optional;

/**
 *
 * @author amiguel
 */
public interface BookService {
        
        public Optional<Book> findByTitle(String title);
        public Book save(String title);
        
}
