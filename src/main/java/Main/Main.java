package Main;


import Negocio.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Competencia competencia = (Competencia) manager.createQuery("FROM Competencia WHERE nombre = 'liga_test'").getSingleResult();
        System.out.println(competencia.getClass());
        if(competencia.getClass() == Liga.class){
            System.out.println(((Liga) competencia).getPuntos_empate());
        }
        manager.getTransaction().commit();
    }
}
