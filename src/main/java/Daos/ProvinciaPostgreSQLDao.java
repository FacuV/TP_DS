package Daos;

import Negocio.Pais;
import Negocio.Provincia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProvinciaPostgreSQLDao implements ProvinciaDao{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private EntityManager manager;
    @Override
    public void createProvincia(Provincia provincia) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(provincia);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public Provincia getProvincia(String nombre) {
        Provincia provincia = null;
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        List provincias = manager.createQuery("FROM Provincia WHERE nombre = '"+nombre+"'").getResultList();
        if(!provincias.isEmpty()){provincia= (Provincia) provincias.get(0);}
        manager.getTransaction().commit();
        manager.close();
        return provincia;
    }

    @Override
    public Provincia getProvincia(int id_provincia) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Provincia provincia = manager.find(Provincia.class,id_provincia);
        manager.getTransaction().commit();
        manager.close();
        return provincia;
    }
    @Override
    public Provincia getOrCreateProvincia(String nombre, Pais pais) {
        Provincia provincia = getProvincia(nombre);
        if(provincia == null) createProvincia(new Provincia(nombre,pais));
        provincia = getProvincia(nombre);
        return provincia;
    }
}
