package com.ethertion.lab.service.impl;

import com.ethertion.lab.domain.Book;
import com.ethertion.lab.repository.BookRepository;
import org.springframework.stereotype.Service;
import com.ethertion.lab.service.BookService;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

/**
 *
 * @author amiguel
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	BookRepository bookRepository;

	@Override
	@Cacheable("book")
	public Book find(Long id) {
		logger.debug("Finding by id " + id);
		return bookRepository.findOne(id);
	}

	@Override
	public List<Book> findAll() {
		logger.debug("Finding all books");
		return bookRepository.findAll();
	}

	@Override
	public Optional<Book> findByTitle(String title) {
		logger.debug("Finding by tittle " + title);
		return bookRepository.findByTitle(title);
	}

	@Override
	public Book save(Book book) {
		logger.debug("Saving book " + book.toString());
		return bookRepository.save(book);
	}

	@Override
	public Book save(String title) {
		logger.debug("Saving book by title " + title);
		Book book = new Book();
		book.setTitle(title);
		return bookRepository.save(book);
	}

	@Override
	public void delete(Long id) {
		logger.debug("Deleting book " + id);
		bookRepository.delete(id);
	}

}
