package Pantallas.NuevaCompetencia;
import Negocio.DisponibilidadDTO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Lugares extends JPanel {
    ArrayList<DisponibilidadDTO> disponibilidades = new ArrayList<>();
    private JTable tabla = new JTable();
    private GridBagConstraints gbc = new GridBagConstraints();
    private int index = 0;
    private JLabel error = new JLabel("",SwingUtilities.CENTER);
    private DefaultTableModel model = (DefaultTableModel) tabla.getModel();
    private Lugares self = this;
    private String deporte = "";
    public ActionListener onDeporteChange;

    public Lugares () {
        onDeporteChange = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                self.disponibilidades = new ArrayList<>();
                self.model.setRowCount(0);
            }
        };

        setLayout(new GridBagLayout());
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.insets = new Insets(0,20,0,20);
        model.addColumn("Nombre");
        model.addColumn("Cantidad");
        gbc.gridy = index++; add(new JLabel("Lugares de realización"),gbc);

        error.setForeground(Color.red);
        gbc.gridy = index++; add(error,gbc);

        error.setForeground(Color.red);
        gbc.gridy = index++; add(error,gbc);

        JScrollPane lugaresScroll = new JScrollPane(tabla);
        GridBagConstraints lugaresScrollConstraints = new GridBagConstraints();
        lugaresScrollConstraints.gridy = index++;
        lugaresScrollConstraints.gridwidth = 2;
        lugaresScrollConstraints.weighty = 1;
        lugaresScrollConstraints.weightx = 1;
        lugaresScrollConstraints.fill = GridBagConstraints.BOTH;
        lugaresScrollConstraints.insets = new Insets(10,20,10,20);
        add(lugaresScroll,lugaresScrollConstraints);

        JButton botonAgregar = new JButton("Agregar");
        botonAgregar.addActionListener(new addDisponibilidad());
        JButton botonEliminar = new JButton("Eliminar");
        botonEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                disponibilidades.remove(tabla.getSelectedRow());
                model.removeRow(tabla.getSelectedRow());
            }
        });
        gbc.gridy = index; add(botonEliminar, gbc);
        gbc.gridy = index++; add(botonAgregar, gbc);
    };

    public ArrayList<DisponibilidadDTO> getDisponibilidades() {
        return this.disponibilidades;
    };
    public void setError(String error) { this.error.setText(error); };
    public void setDeporte(String deporte) { this.deporte = deporte; };
    public ActionListener getOnDeporteChange() { return this.onDeporteChange;};

    public class addDisponibilidad implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            NuevoLugar prompt = new NuevoLugar(SwingUtilities.getWindowAncestor(self),"Agregar Lugar",model,disponibilidades,self.deporte);
            prompt.setVisible(true);
        }
    }
}
