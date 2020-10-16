package Main;

import Daos.DeporteDao;
import Daos.DeportePostgreSQLDao;
import GestorPantallas.GestorPantallas;
import GestorPantallas.Pantalla;
import Negocio.Deporte;
import Pantallas.MisCompetencias;
import Pantallas.Home;
import Pantallas.NuevaCompetencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        GestorPantallas.add(new Pantalla("home", Home.class));
        GestorPantallas.add(new Pantalla("competencias", MisCompetencias.class));
        GestorPantallas.add(new Pantalla("nueva_competencia", NuevaCompetencia.class));
        GestorPantallas.init("home");
       //EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
       //EntityManager manager;
       //    manager = entityManagerFactory.createEntityManager();
       //    Deporte deporte = new Deporte("League of Legends");
       //    manager.getTransaction().begin();
       //    manager.persist(deporte);
       //    manager.getTransaction().commit();
       //    manager.close();

    }
}
