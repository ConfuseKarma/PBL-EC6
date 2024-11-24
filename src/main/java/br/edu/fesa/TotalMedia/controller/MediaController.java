package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.model.Genre;
import br.edu.fesa.TotalMedia.model.Media;
import br.edu.fesa.TotalMedia.service.MediaService;
import br.edu.fesa.TotalMedia.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/media")
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @Autowired
    private GenreService genreService;

    // Página de criação de uma nova mídia
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("media", new Media()); // Objeto vazio para preenchimento no formulário
        List<Genre> genres = genreService.getAllGenres(); // Buscar todos os gêneros da tabela
        model.addAttribute("genres", genres); // Passa os gêneros para o formulário
        return "media/create"; // Página para criação de mídia
    }

    // Salvar a nova mídia
    @PostMapping("/save")
    public String createMedia(@ModelAttribute Media media, @RequestParam List<Integer> genreIds) { // Alterado para Integer
        // Adiciona os gêneros selecionados à mídia
        for (Integer genreId : genreIds) { // Alterado para Integer
            Optional<Genre> genreOpt = genreService.getGenreById(genreId); // Passa Integer
            genreOpt.ifPresent(media::addGenre); // Adiciona o gênero à mídia
        }
        mediaService.saveMedia(media); // Chama o serviço para salvar
        return "redirect:/media/list"; // Redireciona para a lista após salvar
    }

    // Listar todas as mídias
    @GetMapping("/list")
    public String listMedia(Model model) {
        List<Media> mediaList = mediaService.getAllMedias(); // Recupera todas as mídias
        model.addAttribute("mediaList", mediaList); // Adiciona as mídias ao modelo
        return "media/list"; // Página que exibe as mídias
    }

    // Exibir os detalhes de uma mídia
    @GetMapping("/{id}")
    public String showMedia(@PathVariable Integer id, Model model) { // Alterado para Integer
        Optional<Media> mediaOpt = mediaService.getMediaById(id); // Busca a mídia pelo ID
        if (mediaOpt.isPresent()) {
            model.addAttribute("media", mediaOpt.get()); // Adiciona a mídia ao modelo
            return "media/detail"; // Página de detalhes da mídia
        }
        model.addAttribute("error", "Mídia não encontrada."); // Exibe erro, se necessário
        return "redirect:/media/list"; // Redireciona para a lista se não encontrada
    }

    // Página de edição de uma mídia
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Integer id, Model model) { // Alterado para Integer
        Optional<Media> mediaOpt = mediaService.getMediaById(id); // Busca a mídia pelo ID
        if (mediaOpt.isPresent()) {
            model.addAttribute("media", mediaOpt.get()); // Adiciona a mídia ao modelo
            List<Genre> genres = genreService.getAllGenres(); // Buscar todos os gêneros da tabela
            model.addAttribute("genres", genres); // Passa os gêneros para o formulário
            return "media/edit"; // Página de edição
        }
        model.addAttribute("error", "Mídia não encontrada."); // Exibe erro, se necessário
        return "redirect:/media/list"; // Redireciona para a lista
    }

    // Atualizar a mídia
    @PostMapping("/update/{id}")
    public String updateMedia(@PathVariable Integer id, @ModelAttribute Media media, @RequestParam List<Integer> genreIds) { // Alterado para Integer
        media.setId(id); // Garante que o ID original seja mantido
        // Atualiza os gêneros da mídia
        for (Integer genreId : genreIds) { // Alterado para Integer
            Optional<Genre> genreOpt = genreService.getGenreById(genreId); // Passa Integer
            genreOpt.ifPresent(media::addGenre); // Adiciona ou atualiza os gêneros da mídia
        }
        mediaService.updateMedia(media); // Atualiza a mídia
        return "redirect:/media/list"; // Redireciona para a lista
    }

    // Página de confirmação para deletar uma mídia
    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable Integer id, Model model) { // Alterado para Integer
        Optional<Media> mediaOpt = mediaService.getMediaById(id); // Busca a mídia pelo ID
        if (mediaOpt.isPresent()) {
            model.addAttribute("media", mediaOpt.get()); // Adiciona a mídia ao modelo
            return "media/delete"; // Página de confirmação de exclusão
        }
        model.addAttribute("error", "Mídia não encontrada."); // Exibe erro, se necessário
        return "redirect:/media/list"; // Redireciona para a lista
    }

    // Confirmar e deletar a mídia
    @PostMapping("/delete/{id}")
    public String confirmDelete(@PathVariable Integer id) { // Alterado para Integer
        mediaService.deleteMedia(id); // Chama o serviço para deletar
        return "redirect:/media/list"; // Redireciona para a lista
    }
}
