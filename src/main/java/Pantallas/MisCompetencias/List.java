package Pantallas.MisCompetencias;
import GestorPantallas.Gestor;
import Negocio.*;
import Servicio.GestorCompetencia;
import Servicio.GestorUsuarios;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class List extends JScrollPane {
    private JButton AgregarCompetencia = new JButton("Agregar");
    private DefaultListModel model = new DefaultListModel();
    private java.util.List<CompetenciaDTO> listaCompetenciasDTO;
    private JList Lista = new JList();
    private String busqueda = "";
    private String modalidad = "";
    private String estado = "";
    private String deporte = "";

    public List(MisCompetencias misCompetencias) {
        Lista.setModel(model);
        listaCompetenciasDTO = GestorUsuarios.getCompetenciasDTO();
        for (CompetenciaDTO competencia : listaCompetenciasDTO) {
            model.addElement(competencia.nombre + " - " + competencia.deporte + " - " + competencia.estado);
        };

        setViewportView(Lista);
        Lista.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                JList list = (JList) evt.getSource();
                if (evt.getClickCount() == 2) {
                    int index = list.locationToIndex(evt.getPoint());
                    misCompetencias.setCompetencia(listaCompetenciasDTO.get(index).id_competencia);
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
        for (Integer index = 0; index < listaCompetenciasDTO.size(); index++) {
            CompetenciaDTO competencia = listaCompetenciasDTO.get(index);
            if (!this.deporte.isEmpty() && !competencia.deporte.equals(this.deporte)) continue;
            if (!this.estado.isEmpty() && !competencia.estado.equals(this.estado)) continue;
            if (
                    !this.modalidad.isEmpty() &&
                    !((competencia.modalidad_competencia == GestorCompetencia.LIGA) && this.modalidad.equals("Liga")) &&
                    !((competencia.modalidad_competencia == GestorCompetencia.ELIMINATORIA_SIMPLE) && this.modalidad.equals("Eliminatoria Simple")) &&
                    !((competencia.modalidad_competencia == GestorCompetencia.ELIMINATORIA_DOBLE) && this.modalidad.equals("Eliminatoria Doble"))
            ) continue;
            if (competencia.getNombre().contains(this.busqueda) || this.busqueda.isEmpty()) model.addElement(competencia.nombre + " - " + competencia.deporte + " - " + competencia.estado);
        };
    };
};
