/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ethertion.lab.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author amiguel
 */
@Entity
public class Book {
        
        private Long id;
        private String title;
        
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
        
        
}
