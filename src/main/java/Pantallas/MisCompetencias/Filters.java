package Pantallas.MisCompetencias;

import javax.swing.*;
import java.awt.*;

public class Filters extends JPanel {

    public Filters() {
        super();
        setBackground(Color.green);
        setLayout(new GridLayout(4,1));
        add(new JComboBox<String>());
        add(new JComboBox<String>());
        add(new JComboBox<String>());
        add(new JButton("Aceptar"));
    };

    public static class Constraints extends GridBagConstraints {
        public Constraints() {
            gridx = 0;
            gridy = 1;
            weighty = 1;
            weightx = 1;
            fill = GridBagConstraints.BOTH;
        };
    };
}
