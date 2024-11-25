/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.TotalMedia.service;

import br.edu.fesa.TotalMedia.model.Movie;
import br.edu.fesa.TotalMedia.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    public Movie save(Movie movie) {
        return movieRepository.save(movie);
    }

    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }
}
