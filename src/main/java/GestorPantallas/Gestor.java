package GestorPantallas;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public abstract class Gestor {
    static ArrayList<Pantalla> pantallas = new ArrayList<Pantalla>();
    static Stack<JFrame> historia = new Stack<JFrame>();

    public static void add(Pantalla nueva_pantalla) {
        pantallas.add(nueva_pantalla);
    }

    public static void init(String nombrePantalla) {
        push(nombrePantalla);
    }

    public static void push(String nombrePantalla) {
        Pantalla proximaPantalla = Pantalla.find(nombrePantalla,pantallas);
        try {
            Constructor constructorPantalla = proximaPantalla.clase.getConstructor();
            JFrame nuevaPantalla = (JFrame) constructorPantalla.newInstance();
            nuevaPantalla.setVisible(true);
            if (historia.size() > 0) {
                historia.lastElement().setVisible(false);
            }
            historia.push(nuevaPantalla);
        } catch (NoSuchMethodException e) {
            System.out.format("La pantalla %s no tiene una clase con un constructor válido",nombrePantalla);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    public static void pop() {
        if (historia.size() > 1) {
            JFrame pantallaActual = historia.pop();
            pantallaActual.setVisible(false);
            pantallaActual.dispose();
            historia.lastElement().setVisible(true);
        } else {
            System.out.println("El stack del gestor de pantallas ya está en la base de la pila.");
        }

    }
    public static JFrame peek(){
        return historia.peek();
    }
}
