package Pantallas.NuevaCompetencia;

import Daos.DeporteDao;
import Daos.DeportePostgreSQLDao;
import Helpers.CompetenciaHelper;
import Negocio.CompetenciaDTO;
import Negocio.DisponibilidadDTO;
import Servicio.GestorCompetencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cuerpo extends JPanel {

    public Cuerpo() {
        setLayout(new GridLayout(1,2));
        FormularioDerecho formularioDerecho = new FormularioDerecho();
        FormularioIzquierdo formularioIzquierdo = new FormularioIzquierdo();

        add(formularioIzquierdo);
        add(formularioDerecho);

        formularioDerecho.onAceptar(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DeporteDao deporteDao = new DeportePostgreSQLDao();
                String nombre = formularioIzquierdo.getNombre();
                String modalidad = formularioIzquierdo.getModalidad();
                String deporte = formularioIzquierdo.getDeporte();
                Integer puntosPorGanar = Integer.parseInt((formularioIzquierdo.getPuntosPorGanar().isEmpty())?"0":formularioIzquierdo.getPuntosPorGanar());
                Integer puntosPorPresentarse = Integer.parseInt((formularioIzquierdo.getPuntosPorPresentarse().isEmpty())?"0":formularioIzquierdo.getPuntosPorPresentarse());
                Integer puntosPorAusencia = Integer.parseInt((formularioIzquierdo.getPuntosPorAusencia().isEmpty())?"0":formularioIzquierdo.getPuntosPorAusencia());
                Integer puntosPorEmpate = Integer.parseInt((formularioIzquierdo.getPuntosPorEmpate().isEmpty())?"0":formularioIzquierdo.getPuntosPorEmpate());
                Integer cantidadSets = Integer.parseInt((formularioIzquierdo.getCantidadSets().isEmpty())?"0":formularioIzquierdo.getCantidadSets());
                boolean hasFinalResult = formularioIzquierdo.getHasFinalResult();
                boolean hasSets = formularioIzquierdo.getHasSets();
                boolean hasPuntos = formularioIzquierdo.getHasPuntos();
                boolean hasTie = formularioIzquierdo.getHasTie();
                ArrayList<DisponibilidadDTO> disponibilidades = formularioDerecho.getDisponibilidades();
                String reglamento = formularioDerecho.getReglamento();

                int forma_puntuacion = 0;
                if (hasPuntos) forma_puntuacion = 0;
                if (hasSets) forma_puntuacion = 1;
                if (hasPuntos) forma_puntuacion = 2;

                ArrayList<String> errores = GestorCompetencia.crearComp(new CompetenciaDTO(nombre,deporteDao.getDeporte(deporte).getId_deporte(),disponibilidades,reglamento,4, CompetenciaHelper.getIdModalidad(modalidad),forma_puntuacion,cantidadSets,puntosPorAusencia,puntosPorGanar,puntosPorPresentarse,hasTie,puntosPorEmpate));
                System.out.println(errores);
            }
        });
    }

    static public class Constraints extends GridBagConstraints {
        public Constraints(){
            weightx = 1;
            weighty = 1;
            gridy = 1;
            fill = GridBagConstraints.BOTH;
        }
    }
}
