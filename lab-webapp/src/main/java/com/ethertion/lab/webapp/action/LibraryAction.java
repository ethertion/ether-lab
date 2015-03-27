package com.ethertion.lab.webapp.action;

import com.ethertion.lab.service.BookService;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.RequestContext;

/**
 *
 * @author amiguel
 */
public class LibraryAction extends BaseAction implements ApplicationContextAware{
        
        @Autowired
        private BookService bookService;
        
        private ApplicationContext appContext;
        
        @Override
        public Event setUp(RequestContext context) throws Exception {
                return success();
        }
      
        public Event exit(RequestContext context) throws Exception {
                return success();
        }
        
        public Event book(RequestContext context) throws Exception {
                return success();
        }

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		appContext = applicationContext;		
	}

        public BookService getBookService() {
                return bookService;
        }

        public void setBookService(BookService bookService) {
                this.bookService = bookService;
        }

        public ApplicationContext getAppContext() {
                return appContext;
        }

        public void setAppContext(ApplicationContext appContext) {
                this.appContext = appContext;
        }
        
        
        
}
