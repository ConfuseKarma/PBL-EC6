/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.enumerator.UserRole;
import br.edu.fesa.TotalMedia.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/critic")
public class CriticController {

    @GetMapping("/menu")
    public String criticPage(Authentication authentication, Model model) {
        // Simula o usuário autenticado
        User currentUser = getAuthenticatedUser(authentication);

        if (currentUser != null) {
            // Verifica se é administrador
            if (currentUser.getUserRole() == UserRole.CRITIC) {
                String criticImage = currentUser.getImage() != null && !currentUser.getImage().isEmpty()
                        ? currentUser.getImage()
                        : "/images/critic_pfp.png"; // Caminho da imagem padrão
                model.addAttribute("adminImage", criticImage);
            }
        }

        return "critic"; // Nome da view para a área do administrador
    }

    // Método auxiliar para obter o usuário autenticado
    private User getAuthenticatedUser(Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return (User) authentication.getPrincipal();
        }
        return null;
    }

}
