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
        //JFrame home = new Home();
        //JFrame pantalla = new JPantalla("una pantalla","tu vijea");
        //GestorPantallas.add(new Pantalla("home",home));
        //GestorPantallas.add(new Pantalla("pantalla",pantalla));
        //GestorPantallas.init("home");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Usuario usuario = new Usuario();
        manager.persist(usuario);
        usuario = manager.find(Usuario.class,1);
        usuario.setNombre("Pablo");
        usuario.setApellido("Leonarduzzi");
        usuario.setNumero_documento("36001639");
        usuario.setTipoDeDocumento(TipoDeDocumento.DNI);
        Provincia provincia = manager.find(Provincia.class,2);
        System.out.println(provincia);
        Localidad localidad = new Localidad("Santa fe",provincia);
        manager.persist(localidad);
        System.out.println(localidad);
        manager.persist(localidad);
        //localidad = manager.find(Localidad.class,localidad);
        //System.out.println(localidad);
        usuario.setLocalidad(localidad);
        Deporte deporte = manager.find(Deporte.class,1);
        ArrayList<Deporte> deportes = new ArrayList(); deportes.add(deporte);
        LugarRealizacion lugarRealizacion = new LugarRealizacion("La canchita",usuario,deportes,"el descampado");
        manager.persist(lugarRealizacion);
        lugarRealizacion = manager.merge(lugarRealizacion);
        ArrayList<LugarRealizacion> lugares = new ArrayList<>(); lugares.add(lugarRealizacion);
        usuario.setLugaresRealizacion(lugares);
        Competencia competencia = new EliminatoriaSimple();
        competencia.setNombre("competencia de pablo");
        competencia.setReglamento("se juega con los pies");
        Puntuacion puntuacion = new PuntuacionResultadoFinal();
        manager.persist(puntuacion);
        puntuacion = manager.merge(puntuacion);
        competencia.setPuntuacion(puntuacion);
        competencia.setEstado(Estado.CREADA);
        competencia.setUsuario(usuario);
        competencia.setDeporte(deporte);
        Disponibilidad disponibilidad = new Disponibilidad(10,competencia,lugarRealizacion);
        manager.persist(disponibilidad);
        disponibilidad = manager.merge(disponibilidad);
        ArrayList<Disponibilidad> disponibilidades = new ArrayList<>();
        disponibilidades.add(disponibilidad);
        competencia.setDisponibilidades(disponibilidades);
        Participante participante = new Individuo("pablito","pablodl77@gmail.com");
        manager.persist(participante);
        participante = manager.merge(participante);
        ArrayList<Participante> participantes = new ArrayList<>();
        participantes.add(participante);
        competencia.setParticipantes(participantes);
        manager.persist(competencia);
        competencia = manager.find(Competencia.class,1);
        manager.getTransaction().commit();
        System.out.println(competencia);
        manager.close();








    }
}
