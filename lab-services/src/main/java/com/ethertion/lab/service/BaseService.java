package com.ethertion.lab.service;

import java.util.List;

/**
 *
 * @author amiguel
 */
public interface BaseService<T> {

        public T find(Long id);

        public List<T> findAll();

        public T save(T t);

        public void delete(Long id);

}
