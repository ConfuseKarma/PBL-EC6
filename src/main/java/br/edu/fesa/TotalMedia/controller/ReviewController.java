package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.model.Review;
import br.edu.fesa.TotalMedia.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // Endpoint para exibir a lista de avaliações
    @GetMapping("/list")
    public String getAllReviews(Model model) {
        List<Review> reviews = reviewService.getAllReviews();
        model.addAttribute("reviews", reviews); // Adiciona a lista de reviews ao modelo
        return "/reviews/list"; // Retorna o nome do template 'list.html'
    }

    // Endpoint para salvar uma nova avaliação
    @PostMapping
    public String saveReview(@ModelAttribute Review review) {
        reviewService.saveReview(review);
        return "redirect:/reviews/list"; // Redireciona de volta para a lista de avaliações após salvar
    }

    // Endpoint para exibir a página de criação de uma avaliação
    @GetMapping("/create")
    public String createReviewForm(Model model) {
        model.addAttribute("review", new Review()); // Cria um novo objeto de review para o formulário
        return "reviews/create"; // Retorna o nome do template de criação (create.html) com o caminho correto
    }

    // Endpoint para buscar uma avaliação pelo ID
    @GetMapping("/{id}")
    public String getReviewById(@PathVariable Integer id, Model model) {
        Optional<Review> review = reviewService.getReviewById(id);
        if (review.isPresent()) {
            model.addAttribute("review", review.get());
            return "reviews/edit"; // Retorna a página de edição (edit.html) com o caminho correto
        }
        return "redirect:/reviews/list"; // Redireciona de volta para a lista caso não encontre
    }

    // Endpoint para atualizar uma avaliação
    @PutMapping("/{id}")
    public String updateReview(@PathVariable Integer id, @ModelAttribute Review review) {
        if (reviewService.existsById(id)) {
            review.setId(id); // Garante que o ID da avaliação está correto
            reviewService.updateReview(review);
        }
        return "redirect:/reviews/list"; // Redireciona para a lista de avaliações após a atualização
    }

    // Endpoint para deletar uma avaliação
    @DeleteMapping("/{id}")
    public String deleteReview(@PathVariable Integer id) {
        if (reviewService.existsById(id)) {
            reviewService.deleteReview(id); // Exclui a avaliação
        }
        return "redirect:/reviews/list"; // Redireciona para a lista de avaliações após a exclusão
    }
}
