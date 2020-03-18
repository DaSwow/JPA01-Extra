package persistence;

import entities.EntityBase;
import javax.persistence.EntityManager;

public abstract class RepositoryBase<T extends EntityBase> implements Repository<T> {

    private final EntityManager entityManager;
    private final Class<T> cls;

    public RepositoryBase(EntityManager entityManager, Class cls) {
        this.entityManager = entityManager;
        this.cls = cls;
    }

    @Override
    public T find(int id) {
        return (T) entityManager.find(cls, id);
    }

    @Override
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    @Override
    public void commit() {
        entityManager.getTransaction().commit();
    }

}
