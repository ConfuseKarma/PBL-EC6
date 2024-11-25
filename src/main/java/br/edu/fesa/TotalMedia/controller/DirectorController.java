/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.model.Director;
import br.edu.fesa.TotalMedia.model.User;
import br.edu.fesa.TotalMedia.service.DirectorService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/director")
public class DirectorController {
    
    @Autowired
    private DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    // Listar todos os diretores
    @GetMapping("/list")
    public String listDirectors(Model model) {
        model.addAttribute("directors", directorService.findAllDirectors());
        return "director/list"; // Nome da página de lista de diretores
    }

    // Formulário para adicionar um novo diretor
    @GetMapping("/create")
    public String createDirectorForm(Model model) {
        model.addAttribute("director", new Director());
        return "director/create"; // Nome da página de formulário de criação
    }

    // Salvar um novo diretor
    @PostMapping("/save")
    public String saveDirector(@ModelAttribute Director director) {
        directorService.saveDirector(director);
         System.out.println("Diretor ID: " + director.getId()); // Verificar se o ID está presente
        return "redirect:/director/list";
    }

    // Formulário para editar um diretor existente
    @GetMapping("/edit/{id}")
    public String editDirectorForm(@PathVariable Integer id, Model model) {
        Optional<Director> directorOpt = directorService.findDirectorById(id);
        if (directorOpt.isPresent()) {
            model.addAttribute("director", directorOpt.get());
            return "director/edit"; // Reutiliza o formulário
        }
        return "redirect:/user/list";
    }

    // Atualizar um diretor existente
    @PostMapping("/update/{id}")
    public String updateDirector(@PathVariable Integer id, @ModelAttribute Director director) {
        directorService.updateDirector(id, director);
        return "redirect:/director/list";
    }

    // Deletar um diretor
    @GetMapping("/delete/{id}")
    public String deleteDirector(@PathVariable int id, Model model) {
    
        Optional<Director> optionalDirector = directorService.findDirectorById(id);
    
            if (optionalDirector.isPresent()) {
                Director director = optionalDirector.get();  // Obtém o diretor
                model.addAttribute("director", director);  // Adiciona o diretor ao modelo
                return "director/delete";  // Página de confirmação para excluir
            }   else {
                model.addAttribute("message", "Diretor não encontrado");
            return "redirect:/directors";  // Redireciona caso o diretor não seja encontrado
        }
    }
    
    @PostMapping("/excluir/{id}")
    public String confirmDelete(@PathVariable int id, Model model) {
        directorService.deleteDirector(id);
        return "redirect:/director/list";
    }
}