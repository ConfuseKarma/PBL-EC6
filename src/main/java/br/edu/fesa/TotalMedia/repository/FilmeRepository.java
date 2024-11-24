package br.edu.fesa.TotalMedia.repository;

import br.edu.fesa.TotalMedia.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Integer> {}
