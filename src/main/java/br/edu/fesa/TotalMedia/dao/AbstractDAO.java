package br.edu.fesa.TotalMedia.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public abstract class AbstractDAO<T> implements GenericoDAO<T> {

  @SuppressWarnings("unchecked")
  private final Class<T> entityClass =
      (Class<T>)
          ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

  @PersistenceContext private EntityManager entityManager;

  protected EntityManager getEntityManager() {
    return entityManager;
  }

  public void save(T entity) {
    if (entityManager.contains(entity)) {
      entityManager.merge(entity);
    } else {
      entityManager.persist(entity);
    }
  }

  public void update(T entity) {
    entityManager.merge(entity);
  }

  @Transactional
  public void delete(T entity) {
    if (entityManager.contains(entity)) {
      entityManager.remove(entity);
    } else {
      entityManager.remove(entityManager.merge(entity));
    }
  }

  public T findById(UUID id) {
    return entityManager.find(entityClass, id);
  }

  public List<T> findAll() {
    return entityManager
        .createQuery("from " + entityClass.getSimpleName(), entityClass)
        .getResultList();
  }

  protected List<T> createQuery(String jpql, Object... params) {
    TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
    for (int i = 0; i < params.length; i++) {
      query.setParameter(i + 1, params[i]);
    }
    return query.getResultList();
  }

  private Object getPrimaryKey(T entity) {
    Class<?> clazz = entity.getClass();
    for (Field field : clazz.getDeclaredFields()) {
      if (field.isAnnotationPresent(Id.class)) {
        try {
          field.setAccessible(true);
          return field.get(entity);
        } catch (IllegalAccessException e) {
          throw new RuntimeException("Unable to access primary key field", e);
        }
      }
    }
    throw new IllegalArgumentException("No field annotated with @Id found in entity: " + entity);
  }

  public Optional<T> findByAttribute(String attributeName, Object value) {
    String jpql = "from " + entityClass.getSimpleName() + " where " + attributeName + " = :value";
    TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
    query.setParameter("value", value);
    return query.getResultStream().findFirst();
  }
}
