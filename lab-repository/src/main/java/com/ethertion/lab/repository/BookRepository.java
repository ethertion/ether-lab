package com.ethertion.lab.repository;

import com.ethertion.lab.domain.Book;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amiguel
 */
@Repository("bookRepository")
public interface BookRepository extends JpaRepository<Book, Long> {
        
        Optional<Book> findByTitle(String title);
}

