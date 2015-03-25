package com.ethertion.lab.webapp.pojo;

import java.io.Serializable;

/**
 *
 * @author amiguel
 */
public class Book implements Serializable{
        
        private String title;
        private String author;

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getAuthor() {
                return author;
        }

        public void setAuthor(String author) {
                this.author = author;
        }

        @Override
        public String toString() {
                return "Book{" + "title=" + title + ", author=" + author + '}';
        }
        
}
