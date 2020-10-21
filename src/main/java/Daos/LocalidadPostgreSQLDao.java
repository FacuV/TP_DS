package Daos;

import Negocio.Localidad;
import Negocio.Provincia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class LocalidadPostgreSQLDao implements LocalidadDao{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private EntityManager manager;
    @Override
    public void createLocalidad(Localidad localidad) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(localidad);
        manager.getTransaction().commit();
        manager.close();
    }
    @Override
    public Localidad getLocalidad(String nombre) {
        Localidad localidad = null;
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        List localidades = manager.createQuery("FROM Localidad WHERE nombre = '"+nombre+"'").getResultList();
        if(!localidades.isEmpty()){localidad= (Localidad) localidades.get(0);}
        manager.getTransaction().commit();
        manager.close();
        return localidad;
    }

    @Override
    public Localidad getLocalidad(int id_localidad) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Localidad localidad = manager.find(Localidad.class,id_localidad);
        manager.getTransaction().commit();
        manager.close();
        return localidad;
    }
    @Override
    public Localidad getOrCreateLocalidad(String nombre, Provincia provincia) {
        Localidad localidad = getLocalidad(nombre);
        if(localidad == null) createLocalidad(new Localidad(nombre,provincia));
        localidad = getLocalidad(nombre);
        return localidad;
    }
}
