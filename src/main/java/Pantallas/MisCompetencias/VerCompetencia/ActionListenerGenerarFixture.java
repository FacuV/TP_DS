package Pantallas.MisCompetencias.VerCompetencia;

import GestorPantallas.Gestor;
import Helpers.CrearEncuentrosHelper;
import Negocio.Competencia;
import Negocio.Estado;
import Negocio.Fixture;
import Negocio.Individuo;
import Servicio.GestorCompetencia;
import com.amazonaws.services.dynamodbv2.xspec.S;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionListenerGenerarFixture implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Competencia competencia = GestorCompetencia.getCompetencia();
        if(competencia.getEstado() == Estado.FINALIZADA || competencia.getEstado() == Estado.EN_CURSO){
            JOptionPane.showMessageDialog(Gestor.peek(), "<html><center>No se puede volver a generar fixture <p> la competencia esta en curso o ya finalizo<html>","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(competencia.getParticipantes().size() <=1){
            JOptionPane.showMessageDialog(Gestor.peek(), "<html><center>No se puede volver a generar fixture <p> no hay participantes suficientes<html>","Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(competencia.getParticipantes().size() % 2 != 0) competencia.addParticipante(new Individuo("FANTASMA","FANTASMA@gmail.com"));

        Fixture fixture = new Fixture();
        fixture.setEncuentros(CrearEncuentrosHelper.crearEncuentros(competencia.getParticipantes()));
        System.out.println(fixture.getEncuentros());
        JOptionPane.showMessageDialog(Gestor.peek(), "<html><center>Fixture creado con exito<html>");

    }
}
