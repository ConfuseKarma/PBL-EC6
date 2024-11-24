package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.enumerator.Genre;
import br.edu.fesa.TotalMedia.model.Media;
import br.edu.fesa.TotalMedia.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;  // Serviço que gerencia a lógica de negócios das mídias

    // Criação de uma nova mídia (CREATE)
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("media", new Media());  // Cria um novo objeto Media para preencher o formulário
        model.addAttribute("genres", Arrays.asList(Genre.values())); // Adiciona os gêneros ao modelo
        return "media/create";  // Página de formulário para criação de mídia
    }

    @PostMapping("/save")
    public String createMedia(@ModelAttribute Media media, Model model) {
        // Chama o serviço para salvar a mídia no banco de dados
        mediaService.saveMedia(media);
        return "redirect:/media/list";  // Redireciona para a lista de mídias
    }

    // Listar todas as mídias (READ)
    @GetMapping("/list")
    public String listMedia(Model model) {
        List<Media> mediaList = mediaService.getAllMedias();  // Recupera todas as mídias
        model.addAttribute("mediaList", mediaList);  // Adiciona a lista de mídias ao modelo
        return "media/list";  // Página que lista as mídias
    }

    // Exibir uma única mídia (READ)
    @GetMapping("/{id}")
    public String showMedia(@PathVariable int id, Model model) {
        Optional<Media> mediaOpt = mediaService.getMediaById(id);  // Recupera a mídia pelo ID
        if (mediaOpt.isPresent()) {
            model.addAttribute("media", mediaOpt.get());  // Se encontrado, adiciona ao modelo
            return "media/detail";  // Página de detalhes da mídia
        }
        return "redirect:/media/list";  // Se não encontrado, redireciona para a lista
    }

    // Atualizar uma mídia existente (UPDATE)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Media> mediaOpt = mediaService.getMediaById(id);  // Recupera a mídia pelo ID
        if (mediaOpt.isPresent()) {
            model.addAttribute("media", mediaOpt.get());  // Se encontrado, adiciona ao modelo
            model.addAttribute("genres", Arrays.asList(Genre.values())); // Adiciona os gêneros ao modelo
            return "media/edit";  // Página de formulário para editar a mídia
        }
        return "redirect:/media/list";  // Se não encontrado, redireciona para a lista
    }

    @PostMapping("/update/{id}")
    public String updateMedia(@PathVariable int id, @ModelAttribute Media media) {
        media.setId(id);  // Garante que o ID da mídia não seja alterado
        mediaService.updateMedia(media);  // Atualiza a mídia no banco de dados
        return "redirect:/media/list";  // Redireciona para a lista de mídias
    }

    // Deletar uma mídia (DELETE)
    @GetMapping("/delete/{id}")
    public String deleteMedia(@PathVariable int id, Model model) {
        Optional<Media> mediaOpt = mediaService.getMediaById(id);
        if (mediaOpt.isPresent()) {
            model.addAttribute("media", mediaOpt.get());  // Se encontrado, adiciona ao modelo
            return "media/delete";  // Página de formulário para confirmar a exclusão da mídia
        }
        return "redirect:/media/list";  // Se não encontrado, redireciona para a lista de mídias
    }

    @PostMapping("/delete/{id}")
    public String confirmDelete(@PathVariable int id) {
        mediaService.deleteMedia(id);  // Deleta a mídia do banco de dados
        return "redirect:/media/list";  // Redireciona para a lista de mídias
    }
}
