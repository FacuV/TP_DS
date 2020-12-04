package Pantallas.MisCompetencias;
import GestorPantallas.Gestor;
import Negocio.Competencia;
import Negocio.EliminatoriaDoble;
import Negocio.EliminatoriaSimple;
import Negocio.Liga;
import Servicio.GestorCompetencia;
import Servicio.GestorUsuarios;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class List extends JPanel {
    private JButton AgregarCompetencia = new JButton("Agregar");
    private GridBagConstraints gbc = new GridBagConstraints();
    private DefaultListModel model = new DefaultListModel();
    private JScrollPane scroller = new JScrollPane();
    private java.util.List<Competencia> listaCompetencias;
    private JList Lista = new JList();
    private String busqueda = "";
    private String modalidad = "";
    private String estado = "";
    private String deporte = "";

    public List(MisCompetencias misCompetencias) {
        setLayout(new GridBagLayout());
        Lista.setModel(model);
        listaCompetencias = GestorUsuarios.getUsuarioLogueado().getCompetencias();
        for (Competencia competencia : listaCompetencias) {
            model.addElement(competencia.getNombre());
        }
        scroller.setViewportView(Lista);
        gbc.gridy = 0; gbc.weightx = 1; gbc.weighty = 1; gbc.fill = GridBagConstraints.BOTH; add(scroller,gbc);
        gbc.gridy++; gbc.weightx = 0; gbc.weighty = 0; add(AgregarCompetencia,gbc);
        setBorder(new EmptyBorder(20,20,20,20));
        Lista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    // Double-click detected
                    int index = list.locationToIndex(evt.getPoint());
                    misCompetencias.setCompetencia(listaCompetencias.get(index));
                };
            };
});
        AgregarCompetencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestor.push("nueva_competencia");
            }
        });
    };

    public static class Constraints extends GridBagConstraints {
        public Constraints() {
            fill = GridBagConstraints.BOTH;
            weightx = 3;
            weighty = 1;
            gridx = 1;
            gridy = 1;
        };
    };

    public void filtrarBusqueda(String busqueda) {
        this.busqueda = busqueda;
        this.filtrar();
    };

    public void filtrarDeporte(String deporte) {
        this.deporte = deporte;
        this.filtrar();
    };

    public void filtrarEstado(String estado) {
        this.estado = estado;
        this.filtrar();
    };

    public void filtrarModalidad(String modalidad) {
        this.modalidad = modalidad;
        this.filtrar();
    };

    private void filtrar() {
        model.removeAllElements();
        for (Integer index = 0; index < listaCompetencias.size(); index++) {
            Competencia competencia = listaCompetencias.get(index);
            if (!this.deporte.isEmpty() && !competencia.getDeporte().getNombre().equals(this.deporte)) continue;
            if (!this.estado.isEmpty() && !competencia.getEstado().toString().equals(this.estado)) continue;
            if (
                    !this.modalidad.isEmpty() &&
                    !((competencia instanceof Liga) && this.modalidad.equals("Liga")) &&
                    !((competencia instanceof EliminatoriaSimple) && this.modalidad.equals("Eliminatoria Simple")) &&
                    !((competencia instanceof EliminatoriaDoble) && this.modalidad.equals("Eliminatoria Doble"))
            ) continue;
            if (competencia.getNombre().contains(this.busqueda) || this.busqueda.isEmpty()) model.addElement(competencia.getNombre());
        };
    };
};
