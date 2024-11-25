/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.exception.ResourceNotFoundException;
import br.edu.fesa.TotalMedia.model.Movie;
import br.edu.fesa.TotalMedia.service.MovieService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    // Lista todos os filmes e exibe na página de listagem
    @GetMapping("/list")
    public String listMovies(Model model) {
        List<Movie> movies = movieService.findAll();
        model.addAttribute("movies", movies);
        return "movie/list"; // Retorna o arquivo "movies-list.html"
    }

    // Exibe o formulário para criar um novo filme
    @GetMapping("/create")
    public String createMovieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie/create";
    }
    
    // Salva o novo filme enviado pelo formulário
    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movie/list"; // Redireciona para a lista de filmes
    }
}
