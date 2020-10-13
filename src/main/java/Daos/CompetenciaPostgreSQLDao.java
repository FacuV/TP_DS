package Daos;

import Negocio.Competencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CompetenciaPostgreSQLDao implements CompetenciaDao{
    @Override
    public Competencia createCompetencia(Competencia competencia) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(competencia);
        manager.getTransaction().commit();
        manager.getTransaction().begin();
        competencia = (Competencia) manager.createQuery("FROM Competencia WHERE nombre = '"+competencia.getNombre()+"'").getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return competencia;
    }
}
