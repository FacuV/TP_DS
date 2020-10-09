package Main;

import GestorPantallas.GestorPantallas;
import GestorPantallas.Pantalla;
import Interface.JPantalla;
import Negocio.Pais;
import Negocio.Provincia;
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
        Provincia bs = manager.find(Provincia.class,1);
        System.out.println(bs);
        System.out.println(bs.getPais());


    }
}
