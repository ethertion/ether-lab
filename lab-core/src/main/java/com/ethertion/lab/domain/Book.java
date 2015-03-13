package com.ethertion.lab.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 *
 * @author amiguel
 */
@Entity
public class Book {
        
        private Long id;
        private String title;        
        private Author author;
        
        public Book(){
                
        }

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }       
        
        @Column(name = "title")
        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        } 

        @OneToOne()
	@JoinColumn(name = "author_id")
        public Author getAuthor() {
                return author;
        }

        public void setAuthor(Author author) {
                this.author = author;
        }        
        
}
