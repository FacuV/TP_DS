package Interface;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame{
    public Home(){
        super("Menu de usúario");
        setSize((int) Toolkit.getDefaultToolkit().getScreenSize().getWidth()/2,(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight()/2);
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        Container cp = getContentPane();
        cp.setLayout(new GridBagLayout());
        cp.setBackground(Color.white);

        JPanel body = new JPanel();
        body.setBackground(Color.white);
        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.weightx = 1;
        gbc1.weighty = 2;
        gbc1.fill = GridBagConstraints.BOTH;

        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.weightx = 1;
        gbc2.gridy = 1;
        gbc2.fill = GridBagConstraints.BOTH;
        gbc2.insets = new Insets(5,5,5,5);

        JPanel footer = new JPanel();
        footer.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.WEST;
            gbc.weightx = 1;
        JButton atras = new JButton("< Cambiar usuario");

        //atras.addActionListener(new ActionListenerAtras());
        footer.add(atras,gbc);
        cp.add(body,gbc1);
        cp.add(footer,gbc2);
    }
    /*JPanel panelTitulo = new JPanel();
            panelTitulo.setLayout(new GridBagLayout());
            panelTitulo.setBackground(Color.white);
            JLabel principal = new JLabel("SISTEMA DE GESTIÓN LOGÍSTICA");
            panelTitulo.add(principal);
            principal.setFont(new Font(Font.DIALOG,1,40));
             */
    /*
        JPanel aux = new JPanel();
        aux.setLayout(new GridBagLayout());
        aux.setBackground(Color.white);
        JPanel subPanelBotones = new JPanel();

        subPanelBotones.setLayout(new GridLayout(6,1,0,10));
        subPanelBotones.setBackground(Color.white);
        JButton plantas = new JButton("PLANTAS");
        plantas.addActionListener(new ActionListenerPlanta());
        JButton camiones = new JButton("CAMIONES");
        camiones.addActionListener(new ActionListenerCamion());
        JButton rutas = new JButton("RUTAS");
        rutas.addActionListener(new ActionListenerRuta());
        JButton insumos = new JButton("INSUMOS");
        insumos.addActionListener(new ActionListenerInsumo());
        JButton ordenes = new JButton("ORDENES DE PEDIDO");
        ordenes.addActionListener(new ActionListenerOrdenesPedido());
        subPanelBotones.add(plantas); subPanelBotones.add(rutas);
        subPanelBotones.add(camiones); subPanelBotones.add(insumos);
        subPanelBotones.add(ordenes);
        GridBagConstraints gbc = new GridBagConstraints(0,0,20,20,20,20,GridBagConstraints.CENTER,GridBagConstraints.VERTICAL,new Insets(0,0,20,0),20,20);
        aux.add(subPanelBotones,gbc);
        cp.add(panelTitulo);
        cp.add(aux);
        */
}
