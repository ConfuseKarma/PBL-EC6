/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.fesa.TotalMedia.service;

import br.edu.fesa.TotalMedia.model.Director;
import br.edu.fesa.TotalMedia.repository.DirectorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    // Criar um novo diretor
    public Director saveDirector(Director director) {
        return directorRepository.save(director);
    }

    // Obter todos os diretores
    public List<Director> findAllDirectors() {
        return directorRepository.findAll();
    }

    // Obter diretor por ID
    public Optional<Director> findDirectorById(Integer id) {
        return directorRepository.findById(id);
    }

    // Atualizar diretor
    public Director updateDirector(Integer id, Director updatedDirector) {
        return directorRepository.save(updatedDirector);
    }

    // Deletar diretor
    public void deleteDirector(Integer id) {
        
        directorRepository.deleteById(id);
    }
}

