package Pantallas.NuevaCompetencia;

import Daos.DeporteDao;
import Daos.DeportePostgreSQLDao;
import GestorPantallas.Gestor;
import Helpers.CompetenciaHelper;
import Negocio.CompetenciaDTO;
import Negocio.DisponibilidadDTO;
import Servicio.GestorCompetencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

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
                if(formularioIzquierdo.getNombre().isEmpty()){
                    formularioIzquierdo.setNombreError("Se debe ingresar un nombre para la competencia");
                    return;
                }else{formularioIzquierdo.setNombreError("");}
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
                if(Collections.frequency(errores,null) == 4){ Gestor.pop();return;}
                if(errores.get(0) != null){formularioIzquierdo.setNombreError(errores.get(0));}else{formularioIzquierdo.setNombreError("");};
                if(errores.get(1) != null){formularioIzquierdo.setCantidadSetsError(errores.get(1));}else{formularioIzquierdo.setCantidadSetsError("");}
                if(errores.get(2) != null){formularioIzquierdo.setPuntosPartGanadoEmpatadoError(errores.get(2));}else{formularioIzquierdo.setPuntosPartGanadoEmpatadoError("");}
                if(errores.get(3) != null){formularioIzquierdo.setPuntosPartGanadoPresentarseError(errores.get(3));}else{formularioIzquierdo.setPuntosPartGanadoPresentarseError("");}

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
