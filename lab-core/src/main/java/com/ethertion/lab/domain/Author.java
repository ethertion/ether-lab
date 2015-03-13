package com.ethertion.lab.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author amiguel
 */
@Entity
public class Author {
        
        private Long id;
        private String fisrtName;
        private String lastName;
        private List<Editorial> editorials = new ArrayList();
        
        public Author(){
                
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

        @Column(name = "firstName")
        public String getFisrtName() {
                return fisrtName;
        }

        public void setFisrtName(String fisrtName) {
                this.fisrtName = fisrtName;
        }

        @Column(name = "lastName")
        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }     

        @ManyToMany(mappedBy = "authors")
        public List<Editorial> getEditorials() {
                return editorials;
        }

        public void setEditorials(List<Editorial> editorials) {
                this.editorials = editorials;
        }
        
}
