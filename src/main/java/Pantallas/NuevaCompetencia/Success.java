package Pantallas.NuevaCompetencia;

import javax.swing.*;
import java.awt.*;

public class Success extends JDialog {

    public Success (Window frame) {
        super(frame);
        setSize(new Dimension(500,150));
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
        GridBagConstraints msgConstraint = new GridBagConstraints();
        msgConstraint.weightx = 1;
        msgConstraint.weighty = 1;
        msgConstraint.anchor = GridBagConstraints.CENTER;
        add(new JLabel("La competencia se creó con éxito!"),msgConstraint);
    }
}
