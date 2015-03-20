package com.ethertion.lab.repository;

import com.ethertion.lab.domain.Editorial;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author amiguel
 */
@Repository("editorialRepository")
public interface EditorialRepository extends JpaRepository<Editorial, Long> {
        
        Optional<Editorial> findByName(String name);
}

