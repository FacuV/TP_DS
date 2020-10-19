package Pantallas.NuevaCompetencia;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Cabecera extends JPanel {

    public Cabecera() {
        setLayout(new GridBagLayout());

        JButton BotonHome = new JButton("Home");
        GridBagConstraints BotonHomeConstraints = new GridBagConstraints();
        add(BotonHome,BotonHomeConstraints);

        JLabel Titulo = new JLabel("Nueva competencia",SwingConstants.CENTER);
        Titulo.setFont(new Font("Arial",Font.BOLD, 30));
        GridBagConstraints TituloConstraints = new GridBagConstraints();
        TituloConstraints.weightx = 1;
        TituloConstraints.gridwidth = 2;
        add(Titulo,TituloConstraints);
    }

    static public class Constraints extends GridBagConstraints {
        public Constraints () {
            fill = GridBagConstraints.BOTH;
            gridx = 0;
            gridy = 0;
            insets = new Insets(20,20,20,20);
            weightx = 1;
        }
    }
}
