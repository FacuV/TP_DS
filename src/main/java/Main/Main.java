package Main;

import GestorPantallas.GestorPantallas;
import GestorPantallas.Pantalla;
import Interface.JPantalla;
import Negocio.*;
import Pantallas.Home;
import com.amazonaws.services.dynamodbv2.xspec.S;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Competencia competencia = manager.find(Competencia.class,3);
        System.out.println(competencia.getClass());
        if(competencia.getClass() == Liga.class){
            System.out.println(((Liga) competencia).getPuntos_empate());
        }
        manager.getTransaction().commit();








    }
}
