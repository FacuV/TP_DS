package Pantallas.NuevaCompetencia;

import Daos.UsuarioDao;
import Daos.UsuarioPostgreSQLDao;
import Negocio.DisponibilidadDTO;
import Negocio.Equipo;
import Negocio.LugarRealizacion;
import Negocio.Usuario;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NuevoLugar extends JDialog {
    NuevoLugar self = this;
    String nuevaCantidad;
    JPanel content = new JPanel();
    UsuarioDao usuarioDao = new UsuarioPostgreSQLDao();
    List<LugarRealizacion> lugares;

    public NuevoLugar (Window frame, String name, DefaultTableModel model, ArrayList<DisponibilidadDTO> disponibilidades) {
        super(frame, name);
        setSize(new Dimension(500,150));
        setLocationRelativeTo(null);
        setContentPane(content);
        content.setLayout(new GridLayout(3,2));
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JTextField Cantidad = new JTextField();
        JComboBox Nombres = new JComboBox();
        Usuario usuario = usuarioDao.getUsuario(4);
        lugares = usuario.getLugaresRealizacion();
        for (LugarRealizacion lugar : lugares) {
            Nombres.addItem(lugar.getNombre());
        };

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

                int lugar_id = 0;
                for (LugarRealizacion lugar : lugares) {
                    if (lugar.getNombre() == Nombres.getSelectedItem()) {
                        lugar_id = lugar.getId_lugar_realizacion();
                    }
                };

                disponibilidades.add(new DisponibilidadDTO(Integer.parseInt(Cantidad.getText()),lugar_id));
            }
        });

        add(Cancelar);
        add(Aceptar);
    }
}
