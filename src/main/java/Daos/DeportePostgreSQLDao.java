package Daos;

import Negocio.Deporte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeportePostgreSQLDao implements DeporteDao{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private EntityManager manager;
    @Override
    public Deporte getDeporte(int id_deporte) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Deporte deporte = manager.find(Deporte.class,id_deporte);
        manager.getTransaction().commit();
        manager.close();
        return deporte;
    }

    @Override
    public Deporte getDeporte(String nombre) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Deporte deporte = (Deporte) manager.createQuery("FROM Deporte WHERE nombre = '"+nombre+"'").getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return deporte;
    }
}
