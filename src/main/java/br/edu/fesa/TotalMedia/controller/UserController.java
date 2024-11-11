package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.model.User;
import br.edu.fesa.TotalMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;  // Serviço que gerencia a lógica de negócios

    // Criação de um novo usuário (CREATE)
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());  // Cria um novo objeto User para preencher o formulário
        return "user/create";  // Página de formulário para criação
    }

    @PostMapping("/create")
    public String createUser(@ModelAttribute User user) {
        // Define a data de registro como a data atual
        user.setRegistrationDate(java.time.LocalDateTime.now());
        userService.saveUser(user);  // Chama o serviço para salvar o usuário no banco de dados
        return "redirect:/users";  // Redireciona para a lista de usuários
    }

    // Listar todos os usuários (READ)
    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();  // Recupera todos os usuários
        model.addAttribute("users", users);  // Adiciona a lista de usuários ao modelo
        return "user/list";  // Página que lista os usuários
    }

    // Exibir um único usuário (READ)
    @GetMapping("/{id}")
    public String showUser(@PathVariable UUID id, Model model) {
        Optional<User> userOpt = userService.getUserById(id);  // Recupera o usuário pelo ID
        if (userOpt.isPresent()) {
            model.addAttribute("user", userOpt.get());  // Se encontrado, adiciona ao modelo
            return "user/detail";  // Página de detalhes do usuário
        }
        return "redirect:/users";  // Se não encontrado, redireciona para a lista
    }

    // Atualizar um usuário existente (UPDATE)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable UUID id, Model model) {
        Optional<User> userOpt = userService.getUserById(id);  // Recupera o usuário pelo ID
        if (userOpt.isPresent()) {
            model.addAttribute("user", userOpt.get());  // Se encontrado, adiciona ao modelo
            return "user/edit";  // Página de formulário para editar o usuário
        }
        return "redirect:/users";  // Se não encontrado, redireciona para a lista
    }

    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable UUID id, @ModelAttribute User user) {
        //user.setId(id);  // Garante que o ID do usuário não seja alterado
        userService.saveUser(user);  // Atualiza o usuário no banco de dados
        return "redirect:/users";  // Redireciona para a lista de usuários
    }

    // Deletar um usuário (DELETE)
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);  // Deleta o usuário pelo ID
        return "redirect:/users";  // Redireciona para a lista de usuários
    }

    // Ativar/desativar um usuário (UPDATE - toggle)
    @GetMapping("/toggle/{id}")
    public String toggleUserStatus(@PathVariable UUID id) {
        User updatedUser = userService.toggleUserActiveStatus(id);  // Alterna o status ativo/inativo
        if (updatedUser != null) {
            return "redirect:/users";  // Redireciona para a lista de usuários
        }
        return "redirect:/users";  // Redireciona para a lista de usuários, caso falhe
    }
}
