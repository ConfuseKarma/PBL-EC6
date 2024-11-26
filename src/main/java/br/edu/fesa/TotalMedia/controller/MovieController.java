/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.exception.ResourceNotFoundException;
import br.edu.fesa.TotalMedia.model.Movie;
import br.edu.fesa.TotalMedia.model.Review;
import br.edu.fesa.TotalMedia.service.DirectorService;
import br.edu.fesa.TotalMedia.service.MovieService;
import br.edu.fesa.TotalMedia.service.ReviewService;
import java.util.List;
import java.util.Optional;
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
    @Autowired
    private DirectorService directorService;
    @Autowired
    private ReviewService reviewService;

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
        model.addAttribute("directors", directorService.findAllDirectors());
        return "movie/create";
    }
    
    // Salva o novo filme enviado pelo formulário
    @PostMapping("/save")
    public String saveMovie(@ModelAttribute("movie") Movie movie) {
        movieService.save(movie);
        return "redirect:/movie/list"; // Redireciona para a lista de filmes
    }
    
    // Exibe o formulário para editar um filme existente
    @GetMapping("/edit/{id}")
    public String editMovieForm(@PathVariable Integer id, Model model) {
        Movie movie = movieService.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado"));
        model.addAttribute("movie", movie);
        return "movie/edit"; 
    }
    
    // Atualizar um diretor existente
    @PostMapping("/update/{id}")
    public String updateMovie(@PathVariable Integer id, @ModelAttribute Movie movie) {
        movieService.updateMovie(movie);
        return "redirect:/movie/list";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteMovie(@PathVariable int id, Model model) {
    
        Optional<Movie> optionalMovie = movieService.findById(id);
    
            if (optionalMovie.isPresent()) {
                Movie movie = optionalMovie.get();  // Obtém o diretor
                model.addAttribute("movie", movie);  // Adiciona o diretor ao modelo
                return "movie/delete";  // Página de confirmação para excluir
            }   else {
                model.addAttribute("message", "Filme não encontrado");
            return "redirect:/movie/list";  // Redireciona caso o diretor não seja encontrado
        }
    }
    
    // Remove um filme do sistema
    @PostMapping("/excluir/{id}")
    public String confirmDelete(@PathVariable Integer id) {
        movieService.deleteById(id);
        return "redirect:/movie/list"; // Redireciona para a lista de filmes
    }
    
    @GetMapping("/{id}")
    public String showMovieDetails(@PathVariable int id, Model model) {
        Movie movie = movieService.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException("Filme não encontrado com o ID: " + id));
    
        model.addAttribute("movie", movie);
        return "movies/details"; // Nome do template Thymeleaf
    }
}
