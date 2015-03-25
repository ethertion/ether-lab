package com.ethertion.lab.service.impl;

import com.ethertion.lab.domain.Book;
import com.ethertion.lab.repository.BookRepository;
import org.springframework.stereotype.Service;
import com.ethertion.lab.service.BookService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author amiguel
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

        @Autowired
        BookRepository bookRepository;

        @Override
        public Book find(Long id) {
                return bookRepository.findOne(id);
        }

        @Override
        public List<Book> findAll() {
                return bookRepository.findAll();
        }

        @Override
        public Optional<Book> findByTitle(String title) {
                return bookRepository.findByTitle(title);
        }

        @Override
        public Book save(Book book) {
                return bookRepository.save(book);
        }

        @Override
        public Book save(String title) {
                Book book = new Book();
                book.setTitle(title);
                return bookRepository.save(book);
        }

        @Override
        public void delete(Long id) {
                bookRepository.delete(id);
        }

}
