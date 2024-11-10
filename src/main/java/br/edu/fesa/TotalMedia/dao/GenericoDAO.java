package br.edu.fesa.TotalMedia.dao;

import br.edu.fesa.TotalMedia.exception.PersistenciaException;
import java.io.Serializable;
import java.util.List;

public interface GenericoDAO<E> extends Serializable {

  List<E> listar() throws PersistenciaException;

  void inserir(E e) throws PersistenciaException;

  void alterar(E e) throws PersistenciaException;

  void remover(E e) throws PersistenciaException;

  E listarPorID(E e) throws PersistenciaException;
}
