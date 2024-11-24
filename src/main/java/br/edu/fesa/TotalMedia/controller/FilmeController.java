package br.edu.fesa.TotalMedia.controller;

import br.edu.fesa.TotalMedia.model.Filme;
import br.edu.fesa.TotalMedia.service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    private final FilmeService filmeService;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        return "filme/create";  // Página de formulário para criação
    }
    
    // Listar todos os filmes (READ)
    @GetMapping("/list")
    public String listFilmes(Model model) {
        List<Filme> filmes = filmeService.getAllFilmes();  // Recupera todos os filmes
        model.addAttribute("filmes", filmes);  // Adiciona a lista de filmes ao modelo
        return "filme/list";  // Página que lista os filmes
    }

    public FilmeController(FilmeService filmeService) {
        this.filmeService = filmeService;
    }

    @GetMapping
    public List<Filme> getAllFilmes() {
        return filmeService.getAllFilmes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> getFilmeById(@PathVariable int id) {
        return filmeService.getFilmeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Filme createFilme(@RequestBody Filme filme) {
        return filmeService.saveFilme(filme);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> updateFilme(@PathVariable int id, @RequestBody Filme filme) {
        if (!filmeService.getFilmeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        filme.setId(id);
        return ResponseEntity.ok(filmeService.saveFilme(filme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilme(@PathVariable int id) {
        if (!filmeService.getFilmeById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        filmeService.deleteFilme(id);
        return ResponseEntity.noContent().build();
    }
}
