package com.ethertion.lab.webapp.rest;

import com.ethertion.lab.domain.Book;
import com.ethertion.lab.service.BookService;
import java.util.Optional;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author amiguel
 */
@RestController
@RequestMapping("/rest")
public class LibraryRESTController {

        private static final Logger logger = Logger.getLogger(LibraryRESTController.class);

        @Autowired
        private BookService bookService;

        /**
         * Finds a book in the library.
         *
         * @param <L>
         * @param title
         * @param request
         * @return
         * @throws Exception
         */
        @SuppressWarnings("unchecked")
        @RequestMapping(method = {RequestMethod.GET}, value = {"/book"}, produces = "application/json")
        public @ResponseBody
        <L> L findBook(
                @RequestParam(value = "title", required = true) String title,
                HttpServletRequest request) throws Exception {

                Book book = null;
                try {
                        Optional<Book> opt = bookService.findByTitle(title);
                        if (opt.isPresent()) {
                                book = opt.get();
                        } else {
                                book = bookService.save(title);
                        }
                } catch (Exception e) {
                        logger.error(e.getMessage());
                        throw new Exception("Could not find book by title: " + title);
                }

                return (L) book;
        }

}
