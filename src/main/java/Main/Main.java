package Main;

import GestorPantallas.*;
import Interface.JPantalla;
import Pantallas.Home;
import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        JFrame home = new Home();
        JFrame pantalla = new JPantalla("una pantalla", "tu vijea");
        GestorPantallas.add(new Pantalla("home", home));
        GestorPantallas.add(new Pantalla("pantalla", pantalla));
        GestorPantallas.init("home");
        ArrayList<Pantalla> lista = new ArrayList<Pantalla>();
        Class claseFrame = Class.forName("javax.swing.JFrame");
        System.out.println(claseFrame.getConstructor());
        Constructor constructor = claseFrame.getConstructor();
        JFrame frame;
        frame = (JFrame) constructor.newInstance();
        frame.setVisible(true);
        System.out.println(frame);
    }
}
