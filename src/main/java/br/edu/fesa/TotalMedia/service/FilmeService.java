package br.edu.fesa.TotalMedia.service;

import br.edu.fesa.TotalMedia.model.Filme;
import br.edu.fesa.TotalMedia.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {

    private final FilmeRepository filmeRepository;

    public FilmeService(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    public List<Filme> getAllFilmes() {
        return filmeRepository.findAll();
    }

    public Optional<Filme> getFilmeById(int id) {
        return filmeRepository.findById(id);
    }

    public Filme saveFilme(Filme filme) {
        return filmeRepository.save(filme);
    }

    public void deleteFilme(int id) {
        filmeRepository.deleteById(id);
    }
}
