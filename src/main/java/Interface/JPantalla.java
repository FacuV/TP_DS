package Interface;

import javax.swing.*;
import java.awt.*;

public class JPantalla extends JFrame {
    protected JPanel body = new JPanel();
    protected Footer footer;
    public JPantalla(String nombrePantalla,String nombreBotonFooter){
        super(nombrePantalla);
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        cp.setBackground(Color.white);
//        body.setBackground(Color.white);
            GridBagConstraints constraintBody = new GridBagConstraints();
            constraintBody.weightx = 1;
            constraintBody.weighty = 1;
            constraintBody.fill = GridBagConstraints.BOTH;
            constraintBody.anchor = GridBagConstraints.CENTER;

        cp.add(body,constraintBody);
        //Si se pasa como parametro una cadena vacia o un null en nombreBotonFooter no se creara el footer
        if(!(nombreBotonFooter == null || nombreBotonFooter.isEmpty())){
            footer = new Footer(nombreBotonFooter);
            cp.add(footer, new GridBagConstraintFooter());
        }
    }
    public JPantalla(String nombrePantalla){
        this(nombrePantalla,"< Volver");
    }

    public JPanel getBody() {
        return body;
    }

    public Footer getFooter() {
        return footer;
    }
}
