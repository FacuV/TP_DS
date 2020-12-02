package Pantallas.MisCompetencias;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    GridBagConstraints gbc = new GridBagConstraints();

    public Header () {
        super(); gbc.fill = GridBagConstraints.BOTH;
        setBackground(Color.red);
        setLayout(new GridBagLayout());
        add(new JButton("Home"));
        gbc.weightx = 1; gbc.gridx = 1; add(new JTextField(),gbc);
    };

    public static class Constraints extends GridBagConstraints {
        public Constraints() {
            gridy = 0;
            gridx = 0;
            weightx = 1;
            gridwidth = 2;
            fill = GridBagConstraints.BOTH;
        };
    };
};
