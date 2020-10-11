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
import java.time.LocalDate;
import java.util.ArrayList;
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
        //Provincia provincia = manager.find(Provincia.class,2);
        //System.out.println(provincia);
        //Localidad localidad = new Localidad("Santa fe",provincia);
        //manager.persist(localidad);
        //manager.getTransaction().commit();
        //Localidad localidad = manager.find(Localidad.class,5);
        //System.out.println(localidad);
        //manager.getTransaction().commit();
        //manager.getTransaction().begin();
       //Usuario usuario = new Usuario("Pablo","Leonarduzzi","pablodl77@gmail.com","36001639",TipoDeDocumento.DNI,localidad);
       //manager.persist(usuario);
       //manager.getTransaction().commit();
       //manager.getTransaction().begin();
       //Usuario usuario = manager.find(Usuario.class,4);
       //Deporte deporte = manager.find(Deporte.class,1);
       //ArrayList<Deporte> deportes = new ArrayList(); deportes.add(deporte);
       //LugarRealizacion lugarRealizacion = new LugarRealizacion("La canchita",usuario,deportes,"el descampado");
       //manager.persist(lugarRealizacion);
       //manager.getTransaction().commit();

        /*
        CAMBIAR LOS MAPEOS @ManyToMany, estan al reves
         */

      //manager.getTransaction().begin();
      //Usuario usuario = manager.find(Usuario.class,4);
      //LugarRealizacion lugarRealizacion = manager.find(LugarRealizacion.class,7);
      //Deporte deporte = manager.find(Deporte.class,1);
      //ArrayList<LugarRealizacion> lugares = new ArrayList<>(); lugares.add(lugarRealizacion);
      //usuario.setLugaresRealizacion(lugares);
      //Puntuacion puntuacion = new PuntuacionResultadoFinal();
      //manager.persist(puntuacion);
      //manager.getTransaction().commit();
      //manager.getTransaction().begin();
      //usuario = manager.find(Usuario.class,4);
      //deporte = manager.find(Deporte.class,1);
      //puntuacion = manager.find(Puntuacion.class,1);
      //Competencia competencia = new EliminatoriaSimple("competencia de pablo","se juega con los pies",puntuacion,usuario,deporte);
      //manager.persist(competencia);
      //manager.getTransaction().commit();
       manager.getTransaction().begin();
       Competencia competencia = manager.find(Competencia.class,1);
       LugarRealizacion lugarRealizacion = manager.find(LugarRealizacion.class,7);
       Disponibilidad disponibilidad = new Disponibilidad(10,competencia,lugarRealizacion);
       manager.persist(disponibilidad);
       ArrayList<Disponibilidad> disponibilidades = new ArrayList<>();
       disponibilidades.add(disponibilidad);
       competencia.setDisponibilidades(disponibilidades);
       Participante participante = new Individuo("pablito","pablodl77@gmail.com");
       manager.persist(participante);
       //participante = manager.merge(participante);
       ArrayList<Participante> participantes = new ArrayList<>();
       participantes.add(participante);
       competencia.setParticipantes(participantes);
       manager.persist(competencia);
       manager.getTransaction().commit();
       System.out.println(competencia);
       manager.close();









    }
}
