package Daos;

import Negocio.Pais;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PaisPostgreSQLDao implements PaisDao{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private EntityManager manager;

    @Override
    public void createPais(Pais pais) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(pais);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public Pais getPais(String nombre) {
        Pais pais = null;
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        List paises = manager.createQuery("FROM Pais WHERE nombre = '"+nombre+"'").getResultList();
        if(!paises.isEmpty()){pais= (Pais) paises.get(0);}
        manager.getTransaction().commit();
        manager.close();
        return pais;
    }

    @Override
    public Pais getPais(int id_pais) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Pais pais = manager.find(Pais.class,id_pais);
        manager.getTransaction().commit();
        manager.close();
        return pais;
    }

    @Override
    public Pais getOrCreatePais(String nombre){
        Pais pais = getPais(nombre);
        if(pais == null) createPais(new Pais(nombre));
        pais = getPais(nombre);
        return pais;
    }
}
