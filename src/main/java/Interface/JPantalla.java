package Interface;

import javax.swing.*;
import java.awt.*;

public class JPantalla extends JFrame {
    protected JPanel body = new JPanel();
    public JPantalla(String nombrePantalla,String nombreBotonFooter){
        super(nombrePantalla);
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        cp.setBackground(Color.white);
        body.setBackground(Color.red);
            GridBagConstraints constraintBody = new GridBagConstraints();
            constraintBody.weightx = 1;
            constraintBody.weighty = 1;
            constraintBody.fill = GridBagConstraints.BOTH;
            constraintBody.anchor = GridBagConstraints.CENTER;
        JPanel footer = new Footer(nombreBotonFooter);

        cp.add(body,constraintBody);
        cp.add(footer,new GridBagConstraintFooter());
    }
    public JPantalla(String nombrePantalla){
        this(nombrePantalla,"< Volver");
    }

}
