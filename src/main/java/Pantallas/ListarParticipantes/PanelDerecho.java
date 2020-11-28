package Pantallas.ListarParticipantes;

import javax.swing.*;
import java.awt.*;

public class PanelDerecho extends JPanel{
    public PanelDerecho(){
        setBackground(Color.red);
        //falta la tabla
    }
    public static class Constraints extends GridBagConstraints {
        public Constraints () {
            fill = GridBagConstraints.BOTH;
            gridx = 2;
            //insets = new Insets(20,20,20,20);
            weightx = 4;
            weighty = 1;
        }
    }
}
