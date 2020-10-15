package Pantallas.NuevaCompetencia;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NuevoLugar extends JDialog {
    NuevoLugar self = this;
    String nuevaCantidad;
    JPanel content = new JPanel();

    public NuevoLugar (Window frame, String name, DefaultTableModel model) {
        super(frame, name);
        setSize(new Dimension(500,150));
        setLocationRelativeTo(null);
        setContentPane(content);
        content.setLayout(new GridLayout(3,2));
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField Cantidad = new JTextField();
        JComboBox Nombres = new JComboBox();
        Nombres.addItem("Boquita");
        Nombres.addItem("Colón");
        Nombres.addItem("River");
        Nombres.addItem("Unión");
        add(new JLabel("Lugar de realización:"));
        add(Nombres);
        add(new JLabel("Cantidad de encuentros:"));
        add(Cantidad);

        JButton Cancelar = new JButton("Cancelar");
        Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                self.dispose();
            }
        });

        JButton Aceptar = new JButton("Aceptar");
        Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object [] row = new Object[2];
                row[0] = Nombres.getSelectedItem();
                row[1] = Cantidad.getText();
                model.addRow(row);
                self.setVisible(false);
                self.dispose();
            }
        });

        add(Cancelar);
        add(Aceptar);
    }
}
