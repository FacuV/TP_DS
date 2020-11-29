package Pantallas.NuevoParticipante;

import Errores.Error;
import Errores.ErrorEmailParticipanteRepetido;
import Errores.ErrorNombreParticipanteRepetido;
import GestorPantallas.Gestor;
import Interface.JPantalla;
import Negocio.ParticipanteDTO;
import Servicio.GestorCompetencia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PantallaNuevoParticipante extends JPantalla {
    public static final String PERSONA = "PERSONA";
    public static final String EQUIPO = "EQUIPO";
    JLabel titulo = new JLabel("Nuevo Participante");
    JLabel tipoLabel = new JLabel("Tipo de Participante");
    JComboBox<String> tipoCombo = new JComboBox<String>();
    JLabel nombreLabel = new JLabel("Nombre");
    JLabel nombreLabelError = new JLabel("");
    JTextField nombreTextField = new JTextField();
    JLabel emailLabel = new JLabel("Email");
    JLabel emailLabelError = new JLabel("");
    JTextField emailTextField = new JTextField();
    JButton aceptar = new JButton("Aceptar");
    public PantallaNuevoParticipante() {
        super("Nuevo Participante");
        body.setLayout(new GridBagLayout());
        tipoCombo.addItem(PERSONA);tipoCombo.addItem(EQUIPO);
        titulo.setFont(new Font(Font.DIALOG,Font.BOLD,40));
        nombreLabelError.setForeground(Color.RED);
        emailLabelError.setForeground(Color.RED);
        GridBagConstraints gbc = new GridBagConstraints();
            gbc.weightx = 1;gbc.weighty = 1;
            gbc.gridx = 2;gbc.gridy = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.CENTER;

            gbc.weightx++;gbc.weighty++;
            gbc.fill = GridBagConstraints.VERTICAL;
        body.add(titulo,gbc);
            gbc.gridy++;
            gbc.weightx--;gbc.weighty--;
            gbc.gridx--;
            gbc.anchor = GridBagConstraints.WEST;
            gbc.fill = GridBagConstraints.VERTICAL;
        body.add(tipoLabel,gbc);
            gbc.gridx++;gbc.gridx++;
        body.add(nombreLabel,gbc);
            gbc.gridy++;
            gbc.gridx--;gbc.gridx--;
        body.add(new JLabel(),gbc);
            gbc.gridx++;gbc.gridx++;
        body.add(nombreLabelError,gbc);
            gbc.gridy++;
            gbc.gridx--;gbc.gridx--;
            gbc.fill = GridBagConstraints.HORIZONTAL;
        body.add(tipoCombo,gbc);
            gbc.gridx++;gbc.gridx++;
        body.add(nombreTextField,gbc);
            gbc.gridy++;
            gbc.gridx--;
            gbc.fill = GridBagConstraints.VERTICAL;
        body.add(emailLabel,gbc);
            gbc.gridy++;
        body.add(emailLabelError,gbc);
            gbc.gridy++;
            gbc.fill = GridBagConstraints.HORIZONTAL;
        body.add(emailTextField,gbc);
            gbc.gridy++;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.VERTICAL;
        body.add(aceptar,gbc);
            gbc.gridy++;gbc.weighty=10;
        body.add(new JSeparator(),gbc);
            gbc.gridx++;gbc.gridx++;
            gbc.weightx=6;
        body.add(new JSeparator(),gbc);
            gbc.gridx=0;
        body.add(new JSeparator(),gbc);

        JFrame esteFrame = this;
        aceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 nombreLabelError.setText("");
                 emailLabelError.setText("");
                 if(nombreTextField.getText().isEmpty() || emailTextField.getText().isEmpty()){
                     if(nombreTextField.getText().isEmpty()) nombreLabelError.setText("Ingrese un nombre");
                     if(emailTextField.getText().isEmpty()) emailLabelError.setText("Ingrese un email");
                     return;
                 }
                /**
                 * False para persona o individuo
                 * True para equipo
                 */
                ParticipanteDTO participanteDTO;
                 if(tipoCombo.getSelectedItem().equals(PERSONA)) participanteDTO=new ParticipanteDTO(nombreTextField.getText(),emailTextField.getText(),GestorCompetencia.getCompetencia().getId_competencia(),false);
                 else participanteDTO=new ParticipanteDTO(nombreTextField.getText(),emailTextField.getText(),GestorCompetencia.getCompetencia().getId_competencia(),true);
                 List<Error> errorList = GestorCompetencia.crearPart(participanteDTO);
                 if(!errorList.isEmpty()){
                     for (Error error:errorList){
                         if(error instanceof ErrorNombreParticipanteRepetido)nombreLabelError.setText(error.getMensajeError());
                         if(error instanceof ErrorEmailParticipanteRepetido)emailLabelError.setText(error.getMensajeError());
                     }
                     return;
                 }
                JOptionPane.showMessageDialog(esteFrame, "Competencia creada con exito");
                notifyAll();
                Gestor.pop();
            }
        });
    }
}
