package Pantallas.MenuDeUsuario;

import javax.swing.*;
import java.awt.*;

public class PanelSuperior extends JPanel{
    JLabel correoElectronico = new JLabel("Correo Electrónico");
    JLabel contraseña = new JLabel("Contraseña");
    JTextField correoElectronicoTF = new JTextField();
    JTextField contraseñaTF = new JTextField();
    public PanelSuperior(){
        super();
        //setBackground(Color.green);
        //Setear fuentes
        correoElectronico.setFont(new Font(Font.DIALOG,Font.PLAIN,30));
        contraseña.setFont(new Font(Font.DIALOG,Font.PLAIN,30));
        setLayout(new GridLayout(2,2,0,50));
        add(correoElectronico);add(correoElectronicoTF);
        add(contraseña);add(contraseñaTF);
    }

    public String getTextCorreo(){return correoElectronicoTF.getText();}

    static public class Constraints extends GridBagConstraints {
        public Constraints(){
            weightx = 1;
            weighty = 2;
            gridy = 1;
            fill = GridBagConstraints.HORIZONTAL;
            anchor = GridBagConstraints.CENTER;
            insets = new Insets(0,50,0,50);
        }
    }
}
