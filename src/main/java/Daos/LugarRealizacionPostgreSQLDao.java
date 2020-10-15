package Daos;

import Negocio.Competencia;
import Negocio.LugarRealizacion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LugarRealizacionPostgreSQLDao implements LugarRealizacionDao{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private EntityManager manager;
    @Override
    public LugarRealizacion createLugarRealizacion(LugarRealizacion lugarRealizacion) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(lugarRealizacion);
        manager.getTransaction().commit();
        manager.getTransaction().begin();
        lugarRealizacion = (LugarRealizacion) manager.createQuery("FROM LugarRealizacion WHERE nombre = '"+lugarRealizacion.getNombre()+"'").getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return lugarRealizacion;
    }

    @Override
    public void deleteLugarRealizacion(LugarRealizacion lugarRealizacion) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(lugarRealizacion);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public LugarRealizacion getLugarRealizacion(int id_lugar_realizacion) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        LugarRealizacion lugarRealizacion = manager.find(LugarRealizacion.class,id_lugar_realizacion);
        manager.getTransaction().commit();
        manager.close();
        return lugarRealizacion;
    }

    @Override
    public LugarRealizacion getLugarRealizacion(String nombre) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        LugarRealizacion lugarRealizacion = (LugarRealizacion) manager.createQuery("FROM LugarRealizacion WHERE nombre = '"+nombre+"'").getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return lugarRealizacion;
    }

    @Override
    public void updateLugarRealizacion(LugarRealizacion lugarRealizacion) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(lugarRealizacion);
        manager.getTransaction().commit();
        manager.close();
    }
}
