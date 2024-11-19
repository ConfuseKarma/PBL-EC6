package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.model.User; // Classe User
import br.edu.fesa.TotalMedia.enumerator.UserRole; // Enum de papel do usuário

import org.springframework.security.core.Authentication; // Para obter dados do usuário autenticado
import org.springframework.stereotype.Controller; // Para marcar a classe como um controlador
import org.springframework.ui.Model; // Para passar dados para a view
import org.springframework.web.bind.annotation.GetMapping; // Para mapear requisições GET
import org.springframework.web.bind.annotation.RequestMapping; // Para mapear o caminho base do controlador


@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/menu")
    public String adminPage(Authentication authentication, Model model) {
        // Simula o usuário autenticado
        User currentUser = getAuthenticatedUser(authentication);

        if (currentUser != null) {
            // Verifica se é administrador
            if (currentUser.getUserRole() == UserRole.ADMIN) {
                String adminImage = currentUser.getImage() != null && !currentUser.getImage().isEmpty()
                        ? currentUser.getImage()
                        : "/images/admin_pfp.png"; // Caminho da imagem padrão
                model.addAttribute("adminImage", adminImage);
            }
        }

        return "admin"; // Nome da view para a área do administrador
    }

    // Método auxiliar para obter o usuário autenticado
    private User getAuthenticatedUser(Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }
}

