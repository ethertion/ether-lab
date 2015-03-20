package com.ethertion.lab.repository;

import com.ethertion.lab.domain.Author;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amiguel
 */
@Repository("authorRepository")
public interface AuthorRepository extends JpaRepository<Author, Long> {
        
        Optional<Author> findByFirstName(String firstName);
}

