package Main;

import Interface.Home;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        JFrame home = new Home();
        home.setVisible(true);
    }

}
