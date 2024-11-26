package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.model.Movie;
import br.edu.fesa.TotalMedia.model.Review;
import br.edu.fesa.TotalMedia.model.User;
import br.edu.fesa.TotalMedia.service.MovieService;
import br.edu.fesa.TotalMedia.service.ReviewService;
import br.edu.fesa.TotalMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private UserService userService;

    // Listar todas as avaliações (READ)
    @GetMapping("/list")
    public String listReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();  // Recupera todas as avaliações
        model.addAttribute("reviews", reviews);  // Adiciona as avaliações ao modelo
        return "reviews/list";  // Página que lista as avaliações
    }

    // Exibir uma avaliação específica por ID (READ)
    @GetMapping("/{id}")
    public String showReview(@PathVariable Integer id, Model model) {
        Optional<Review> reviewOpt = reviewService.getReviewById(id);  // Recupera a avaliação pelo ID
        if (reviewOpt.isPresent()) {
            model.addAttribute("review", reviewOpt.get());  // Se encontrado, adiciona ao modelo
            return "reviews/detail";  // Página de detalhes da avaliação
        }
        return "redirect:/reviews/list";  // Se não encontrado, redireciona para a lista
    }

    // Criar uma nova avaliação (CREATE)
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Movie> movieList = movieService.findAll();  // Obtém todos os filmes
        model.addAttribute("review", new Review());  // Cria um novo objeto Review para o formulário
        model.addAttribute("movieList", movieList);  // Adiciona a lista de filmes ao modelo
        return "reviews/create";  // Página de formulário para criação
    }

    @PostMapping("/save")
    public String createReview(@ModelAttribute Review review, Model model) {
        // Obtendo o usuário autenticado através do SecurityContext
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();  // O nome do usuário é o email

        // Recuperando o usuário a partir do seu email
        User user = userService.getUserByEmail(email).orElse(null);

        if (user == null) {
            model.addAttribute("error", "Usuário não autenticado");
            return "reviews/create";  // Redireciona para a página de criação de avaliação com erro
        }

        review.setUser(user);  // Associa o usuário à avaliação
        reviewService.saveReview(review);  // Salva a avaliação no banco de dados
        return "redirect:/reviews/list";  // Redireciona para a lista de avaliações
    }

    // Editar uma avaliação existente (UPDATE)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Optional<Review> reviewOpt = reviewService.getReviewById(id);  // Recupera a avaliação pelo ID
        if (reviewOpt.isPresent()) {
            model.addAttribute("review", reviewOpt.get());  // Se encontrado, adiciona ao modelo
            List<Movie> movieList = movieService.findAll();  // Obtém todos os filmes para selecionar
            model.addAttribute("movieList", movieList);  // Adiciona a lista de filmes ao modelo
            return "reviews/edit";  // Página de formulário para editar a avaliação
        }
        return "redirect:/reviews/list";  // Se não encontrado, redireciona para a lista
    }

    @PostMapping("/update/{id}")
    public String updateReview(@PathVariable Integer id, @ModelAttribute Review review) {
        review.setId(id);  // Garante que o ID da avaliação está correto
        reviewService.updateReview(review);  // Atualiza a avaliação no banco de dados
        return "redirect:/reviews/list";  // Redireciona para a lista de avaliações
    }

    // Excluir uma avaliação (DELETE)
    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable Integer id, Model model) {
        Optional<Review> reviewOpt = reviewService.getReviewById(id);  // Recupera a avaliação pelo ID
        if (reviewOpt.isPresent()) {
            model.addAttribute("review", reviewOpt.get());  // Se encontrado, adiciona ao modelo
            return "reviews/delete";  // Página de confirmação de exclusão
        }
        return "redirect:/reviews/list";  // Se não encontrado, redireciona para a lista
    }

    @PostMapping("/delete/{id}")
    public String deleteReview(@PathVariable Integer id) {
        reviewService.deleteReview(id);  // Exclui a avaliação
        return "redirect:/reviews/list";  // Redireciona para a lista de avaliações
    }
}
