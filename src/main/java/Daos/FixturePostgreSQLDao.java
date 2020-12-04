package Daos;

import Negocio.Fixture;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FixturePostgreSQLDao implements FixtureDao{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private EntityManager manager;
    @Override
    public void deleteFixture(Fixture fixture) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(fixture);
        manager.getTransaction().commit();
        manager.close();
    }
}
