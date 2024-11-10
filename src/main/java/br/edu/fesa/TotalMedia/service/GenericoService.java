/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.fesa.TotalMedia.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GenericoService<T> {

    void save(T entity);

    void update(T entity);

    void delete(T t);

    T findById(UUID id);

    List<T> findAll();

    Optional<T> findByAttribute(String attributeName, Object value);
}
