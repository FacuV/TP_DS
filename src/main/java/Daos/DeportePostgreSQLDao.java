package Daos;

import Negocio.Deporte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
    static public int getDeporteId(String nombre) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Deporte deporte = (Deporte) manager.createQuery("FROM Deporte WHERE nombre = '"+nombre+"'").getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return deporte.getId_deporte();
    }
    @Override
    public List<Deporte> getDeportes() {
        List<Deporte> deportes;
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        deportes = manager.createQuery("FROM Deporte").getResultList();
        manager.getTransaction().commit();
        manager.close();
        return deportes;
    };
}
