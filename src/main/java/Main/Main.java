package Main;

import GestorPantallas.GestorPantallas;
import GestorPantallas.Pantalla;
import Interface.JPantalla;
import Negocio.Pais;
import Pantallas.Home;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //JFrame home = new Home();
        //JFrame pantalla = new JPantalla("una pantalla","tu vijea");
        //GestorPantallas.add(new Pantalla("home",home));
        //GestorPantallas.add(new Pantalla("pantalla",pantalla));
        //GestorPantallas.init("home");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        EntityManager manager = entityManagerFactory.createEntityManager();
        Pais australia= new Pais("Australia");
        Pais hungria= new Pais("Hungria");
        manager.getTransaction().begin();
        //almacenar objeto
        manager.persist(australia);
        manager.persist(hungria);
        manager.getTransaction().commit();

        //manager.getTransaction().begin();
        ////almacenar objeto
        //australia=manager.find(Pais.class,0);
        //hungria=manager.find(Pais.class,35);
        //manager.remove(australia);
        //manager.remove(hungria);
        //manager.getTransaction().commit();
        List paises = manager.createQuery("FROM Pais").getResultList();
        System.out.println(paises);
        System.out.println(paises.size());
        manager.close();


    }
}
