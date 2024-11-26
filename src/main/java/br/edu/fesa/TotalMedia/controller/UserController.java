package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.enumerator.UserGender;
import br.edu.fesa.TotalMedia.enumerator.UserRole;
import br.edu.fesa.TotalMedia.model.User;
import br.edu.fesa.TotalMedia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;  // Serviço que gerencia a lógica de negócios

    // Criação de um novo usuário (CREATE)
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());  // Cria um novo objeto User para preencher o formulário
        model.addAttribute("genders", Arrays.asList(UserGender.values())); // Adiciona os gêneros ao modelo
        model.addAttribute("roles", Arrays.asList(UserRole.values())); // Adiciona as funções ao modelo
        return "user/create";  // Página de formulário para criação
    }

    @PostMapping("/save")
    public String createUser(@ModelAttribute User user, 
                            @RequestParam("confirmPassword") String confirmPassword, 
                            Model model) {
        if (!user.getPassword().equals(confirmPassword)) 
        {
            model.addAttribute("error", "As senhas não coincidem");
            return "user/create"; // Nome do template de criação de usuário
        }
        // Define a data de registro como a data atual
        user.setRegistrationDate(java.time.LocalDateTime.now());
        userService.saveUser(user);  // Chama o serviço para salvar o usuário no banco de dados
        return "redirect:/user/list";  // Redireciona para a lista de usuários
    }

    // Listar todos os usuários (READ)
    @GetMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.getAllUsers();  // Recupera todos os usuários
        model.addAttribute("users", users);  // Adiciona a lista de usuários ao modelo
        return "user/list";  // Página que lista os usuários
    }

    // Exibir um único usuário (READ)
    @GetMapping("/{id}")
    public String showUser(@PathVariable int id, Model model) {
        Optional<User> userOpt = userService.getUserById(id);  // Recupera o usuário pelo ID
        if (userOpt.isPresent()) {
            model.addAttribute("user", userOpt.get());  // Se encontrado, adiciona ao modelo
            return "user/detail";  // Página de detalhes do usuário
        }
        return "redirect:/user/list";  // Se não encontrado, redireciona para a lista
    }

    // Atualizar um usuário existente (UPDATE)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<User> userOpt = userService.getUserById(id);  // Recupera o usuário pelo ID
        if (userOpt.isPresent()) {
            model.addAttribute("user", userOpt.get());  // Se encontrado, adiciona ao modelo
            model.addAttribute("genders", Arrays.asList(UserGender.values())); // Adiciona os gêneros ao modelo
            model.addAttribute("roles", Arrays.asList(UserRole.values())); // Adiciona as funções ao modelo
            return "user/edit";  // Página de formulário para editar o usuário
        }
        return "redirect:/user/list";  // Se não encontrado, redireciona para a lista
    }

    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute User user) {
        user.setId(id);  // Garante que o ID do usuário não seja alterado
        userService.updateUser(user);  // Atualiza o usuário no banco de dados
        return "redirect:/user/list";  // Redireciona para a lista de usuários
    }

    // Deletar um usuário (DELETE)
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id, Model model) {
        Optional<User> userOpt = userService.getUserById(id);
        if (userOpt.isPresent()) {
            model.addAttribute("user", userOpt.get());  // Se encontrado, adiciona ao modelo
            return "user/delete";  // Página de formulário para editar o usuário
        }
        return "redirect:/user/list"; // Redireciona para a lista de usuários
    }

    @PostMapping("/excluir/{id}")
    public String confirmDelete(@PathVariable int id, Model model) {
        userService.deleteUser(id);
        return "redirect:/user/list";
    }

    // Ativar/desativar um usuário (UPDATE - toggle)
    @GetMapping("/toggle/{id}")
    public String toggleUserStatus(@PathVariable int id) {
        User updatedUser = userService.toggleUserActiveStatus(id);  // Alterna o status ativo/inativo
        if (updatedUser != null) {
            return "redirect:/user/list";  // Redireciona para a lista de usuários
        }
        return "redirect:/user/list";  // Redireciona para a lista de usuários, caso falhe
    }
    
    @GetMapping("/menu")
    public String userPage() {
        return "userArea"; 
    }
}
