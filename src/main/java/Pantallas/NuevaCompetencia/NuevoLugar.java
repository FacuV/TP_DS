package Pantallas.NuevaCompetencia;
import Negocio.*;
import Servicio.GestorUsuarios;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NuevoLugar extends JDialog {
    JTextField Cantidad = new JTextField();
    JComboBox Nombres = new JComboBox();
    JButton Cancelar = new JButton("Cancelar");
    JButton Aceptar = new JButton("Aceptar");
    JLabel ErrorMsg = new JLabel("");
    JPanel content = new JPanel();
    List<LugarRealizacionDTO> lugares;
    NuevoLugar self = this;
    private String deporte = "";

    public NuevoLugar (Window frame, String name, DefaultTableModel model, ArrayList<DisponibilidadDTO> disponibilidades, String deporte) {
        super(frame, name);
        setSize(new Dimension(500,150));
        setLocationRelativeTo(null);
        setContentPane(content);
        this.deporte = deporte;
        content.setLayout(new GridLayout(4,2));
        content.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ErrorMsg.setForeground(Color.red);

        lugares = GestorUsuarios.getLugaresRealizacionDTO();
        for (LugarRealizacionDTO lugar : lugares) {
            boolean alreadySelected = false;
            boolean usable = false;
            for(DeporteDTO deporteDTO:lugar.deportesDTO) {
                if (deporteDTO.nombre.equals(deporte)) usable = true;
            }
            for (DisponibilidadDTO disponibilidad : disponibilidades) {
                if (disponibilidad.id_lugar_realizacion == lugar.id_lugar_realizacion)
                    alreadySelected = true;
            };
            if (!alreadySelected && usable) Nombres.addItem(lugar.nombre);
        };
        Cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.setVisible(false);
                self.dispose();
            }
        });

        Aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Cantidad.getText().isEmpty()){
                    ErrorMsg.setText("Tenés que ingresar una cantidad.");
                    return;
                }

                Object [] row = new Object[2];
                row[0] = Nombres.getSelectedItem();
                row[1] = Cantidad.getText();
                model.addRow(row);
                int lugar_id = 0;
                for (LugarRealizacionDTO lugar : lugares) {
                    if (lugar.nombre == Nombres.getSelectedItem()) {
                        lugar_id = lugar.id_lugar_realizacion;
                    };
                };

                disponibilidades.add(new DisponibilidadDTO(Integer.parseInt(Cantidad.getText()),lugar_id));
                self.setVisible(false);
                self.dispose();
            }
        });

        add(new JLabel("Lugar de realización:"));
        add(Nombres);
        add(ErrorMsg); add(new JLabel(""));
        add(new JLabel("Cantidad de encuentros:"));
        add(Cantidad);
        add(Cancelar);
        add(Aceptar);
    };
};
