package br.edu.fesa.TotalMedia.service;

import br.edu.fesa.TotalMedia.model.Genre;
import br.edu.fesa.TotalMedia.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    // Método para buscar um gênero pelo ID
    public Optional<Genre> getGenreById(Integer id) {
        return genreRepository.findById(id);  // Método do JpaRepository para buscar pelo ID
    }

    // Método para buscar todos os gêneros
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();  // Retorna todos os gêneros do repositório
    }

    // Método para buscar um gênero pelo nome
    public Optional<Genre> getGenreByName(String name) {
        // Como o método findByName não está no repositório, vamos criar uma consulta customizada
        return genreRepository.findAll()
                .stream()
                .filter(genre -> genre.getName().equalsIgnoreCase(name))
                .findFirst();  // Realiza a busca por nome
    }

    // Método para imprimir todos os gêneros no console (apenas para visualização)
    public void printAllGenres() {
        genreRepository.findAll().forEach(genre -> {
            System.out.println("Genre: " + genre.getName());
        });
    }
}
