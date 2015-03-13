package com.ethertion.lab.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
        
/**
 *
 * @author amiguel
 */
public class Editorial {
        
        private Long id;
        private String name;
        private String address;
        private List<Author> authors = new ArrayList();
        
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

         @Column(name = "name")
        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        @Column(name = "address")
        public String getAddress() {
                return address;
        }

        public void setAddress(String address) {
                this.address = address;
        }

        @ManyToMany(mappedBy = "editorials")
        public List getAuthors() {
                return authors;
        }

        public void setAuthors(List authors) {
                this.authors = authors;
        }
        
}
