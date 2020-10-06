package Main;

import GestorPantallas.GestorPantallas;
import GestorPantallas.Pantalla;
import Interface.Home;

import javax.swing.*;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {
        JFrame home = new Home();
        GestorPantallas.add(new Pantalla("home",home));
        GestorPantallas.init("home");
    }
}
