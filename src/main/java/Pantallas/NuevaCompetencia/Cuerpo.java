package Pantallas.NuevaCompetencia;
import GestorPantallas.Gestor;
import Negocio.CompetenciaDTO;
import Servicio.GestorCompetencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Cuerpo extends JPanel {
    FormularioIzquierdo formularioIzquierdo = new FormularioIzquierdo();
    FormularioDerecho formularioDerecho = new FormularioDerecho();
    CompetenciaDTO competencia = new CompetenciaDTO();

    public Cuerpo() {
        setLayout(new GridLayout(1,2));
        add(formularioIzquierdo);
        add(formularioDerecho);
        formularioDerecho.onAceptar(new onAceptar());
    }

    static public class Constraints extends GridBagConstraints {
        public Constraints(){
            weightx = 1;
            weighty = 1;
            gridy = 1;
            fill = GridBagConstraints.BOTH;
        }
    }

    private class onAceptar implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            competencia.setNombre(formularioIzquierdo.getNombre());
            competencia.setModalidadCompetencia(formularioIzquierdo.getModalidad());
            competencia.setDeporte(formularioIzquierdo.getDeporte());
            competencia.setPuntos_partido_ganado(Integer.parseInt((formularioIzquierdo.getPuntosPorGanar().isEmpty())?"0":formularioIzquierdo.getPuntosPorGanar()));
            competencia.setPuntos_partido_empatado(Integer.parseInt((formularioIzquierdo.getPuntosPorEmpate().isEmpty())?"0":formularioIzquierdo.getPuntosPorEmpate()));
            competencia.setPuntos_presentarse(Integer.parseInt((formularioIzquierdo.getPuntosPorPresentarse().isEmpty())?"0":formularioIzquierdo.getPuntosPorPresentarse()));
            competencia.setTantos_equipo_ganador_por_ausencia(Integer.parseInt((formularioIzquierdo.getPuntosPorAusencia().isEmpty())?"0":formularioIzquierdo.getPuntosPorAusencia()));
            competencia.setCantidad_máxima_sets(Integer.parseInt((formularioIzquierdo.getCantidadSets().isEmpty())?"0":formularioIzquierdo.getCantidadSets()));
            competencia.setForma_Puntuación(formularioIzquierdo.getHasPuntos() ? 0 : formularioIzquierdo.getHasSets() ? 1 : formularioIzquierdo.getHasFinalResult() ? 3 : -1);
            competencia.setPermite_empate(formularioIzquierdo.getHasTie());
            competencia.setDisponibilidades(formularioDerecho.getDisponibilidades());
            competencia.setReglamento(formularioDerecho.getReglamento());

            if (!checkSyntaxis()) return;

            ArrayList<String> errores = GestorCompetencia.crearComp(competencia);
            if (showErrors(errores)); // Gestor.pop();
        }
    }

    private boolean showErrors(ArrayList<String> errores) {
        boolean correct = true;
        System.out.println(errores);
        if (errores.get(3) != null) {
            formularioIzquierdo.setErrorPuntos(errores.get(3));
            correct = false;
        } else formularioIzquierdo.setErrorPuntos("");

        return correct;
    }

    private boolean checkSyntaxis () {
        boolean correct = true;
        if (competencia.getNombre().isEmpty()) {
            correct = false;
            formularioIzquierdo.setNombreError("El nombre no puede estar vacío");
        } else formularioIzquierdo.setNombreError("");;
        if (competencia.getForma_Puntuación() == 1 && competencia.getCantidad_máxima_sets() == 0) {
            correct = false;
            formularioIzquierdo.setErrorFormaPuntuacion("Necesita un minimo de sets");
        } else if (competencia.getForma_Puntuación() == -1) {
            correct = false;
            formularioIzquierdo.setErrorFormaPuntuacion("Tenés que elegir una forma de puntuación");
        } else formularioIzquierdo.setErrorFormaPuntuacion("");
        if (competencia.getDisponibilidades().size() == 0) {
            correct = false;
            formularioDerecho.setLugaresError("Tenés que cargar por lo menos una competencia.");
        } else formularioDerecho.setLugaresError("");

        return correct;
    }
}
