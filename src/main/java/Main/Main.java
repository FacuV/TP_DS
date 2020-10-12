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
        //atencion con las relaciones unidireccionales de LugarRealizacion-disponibilidad y ecuentro-participante ya que si se borra un lado se puede generar un conflicto, si se borra el lugar se borra la disponibilidad  y si se borra el participante seguramente se borrara el encuentro.
        //podria hacer que las relaciones sean bidireccionales para poder evita rese problema

    }
}
