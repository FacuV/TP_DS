package Pantallas.NuevoParticipante;
import Errores.Error;
import Errores.ErrorEmailParticipanteRepetido;
import Errores.ErrorNombreParticipanteRepetido;
import GestorPantallas.Gestor;
import Interface.JPantalla;
import Negocio.ParticipanteDTO;
import Servicio.GestorCompetencia;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PantallaNuevoParticipante extends JPantalla {
    public static final String PERSONA = "PERSONA";
    public static final String EQUIPO = "EQUIPO";
    private GridBagConstraints gbc = new GridBagConstraints();
    private PantallaNuevoParticipante self = this;
    NombreLabel nombreLabel = new NombreLabel();
    NombreError nombreError = new NombreError();
    NombreInput nombreInput = new NombreInput();
    TipoLabel tipoLabel = new TipoLabel();
    TipoError tipoError = new TipoError();
    TipoInput tipoInput = new TipoInput();
    EmailLabel emailLabel = new EmailLabel();
    EmailError emailError = new EmailError();
    EmailInput emailInput = new EmailInput();
    AceptarButton aceptarButton = new AceptarButton();

    public PantallaNuevoParticipante() {
        super("Nuevo Participante");
        body.setLayout(new GridBagLayout());
        gbc.gridwidth = 2; gbc.gridy = 0; gbc.gridx = 0; body.add(new Titulo(),gbc);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridwidth = 1; gbc.gridy++; body.add(tipoLabel,gbc);
        gbc.gridx = 1; body.add(nombreLabel,gbc);
        gbc.gridx = 0; gbc.gridy++; body.add(tipoError,gbc);
        gbc.gridx = 1; body.add(nombreError,gbc);
        gbc.gridy++; gbc.gridx = 0; body.add(tipoInput,gbc);
        gbc.gridx = 1; body.add(nombreInput,gbc);
        gbc.gridy++; gbc.gridx = 0; gbc.gridwidth = 2; body.add(emailLabel,gbc);
        gbc.gridy++; body.add(emailError,gbc);
        gbc.gridy++; body.add(emailInput,gbc);
        gbc.gridy++; gbc.anchor = GridBagConstraints.CENTER; gbc.insets = new Insets(20,0,0,0); body.add(aceptarButton,gbc);
    };

    private class Titulo extends JLabel {
        public Titulo() {
            super("Nuevo Participante");
            setFont(new Font(Font.DIALOG,Font.BOLD,40));
            setBorder(new EmptyBorder(0,20,20,20));
        };
    };

    private class NombreLabel extends JLabel {
        public NombreLabel() {
            super("Nombre");
            setBorder(new EmptyBorder(0,10,10,0));
            setPreferredSize(new Dimension(500,this.getPreferredSize().height));
            setFont(new Font(Font.DIALOG,Font.PLAIN,20));
        };
    };

    private class NombreError extends JLabel {
        public NombreError() {
            super("");
            setBorder(new EmptyBorder(0,10,0,0));
            setForeground(Color.red);
        };
    };

    private class TipoError extends JLabel {
        public TipoError() {
            super("");
            setBorder(new EmptyBorder(0,10,0,0));
            setForeground(Color.red);
        };
    };

    private class EmailError extends JLabel {
        public EmailError() {
            super("");
            setBorder(new EmptyBorder(0,10,0,0));
            setForeground(Color.red);
        };
    };

    private class TipoLabel extends JLabel {
        public TipoLabel() {
            super("Tipo de participante");
            setBorder(new EmptyBorder(0,10,10,20));
            setPreferredSize(new Dimension(250,this.getPreferredSize().height));
            setFont(new Font(Font.DIALOG,Font.PLAIN,20));
        };
    };

    private class EmailLabel extends JLabel {
        public EmailLabel() {
            super("Email");
            setBorder(new EmptyBorder(0,10,0,0));
            setFont(new Font(Font.DIALOG,Font.PLAIN,20));
        };
    };

    private class TipoInput extends JComboBox {
        public TipoInput() {
            super();
            addItem(PERSONA);
            addItem(EQUIPO);
            setPreferredSize(new Dimension(250,this.getPreferredSize().height));
        };
    };

    private class NombreInput extends JTextField {
        public NombreInput() {
            super();
            setPreferredSize(new Dimension(500,this.getPreferredSize().height));
        };
    };

    private class EmailInput extends JTextField {
        public EmailInput() {
            super();
            setPreferredSize(new Dimension(750,this.getPreferredSize().height));
        };
    };
    private class AceptarButton extends JButton {
        public AceptarButton() {
            super("Aceptar");
            setFont(new Font(Font.DIALOG, Font.BOLD, 30));
            addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    nombreError.setText("");
                    emailError.setText("");
                    if (nombreInput.getText().isEmpty() || emailInput.getText().isEmpty()) {
                        if (nombreInput.getText().isEmpty()) nombreError.setText("Ingrese un nombre");
                        if (emailInput.getText().isEmpty()) emailError.setText("Ingrese un email");
                        return;
                    }
                    /**
                     * * False para persona o individuo
                     * * True para equipo
                     * */
                    ParticipanteDTO participanteDTO;
                    if (tipoInput.getSelectedItem().equals(PERSONA))
                        participanteDTO = new ParticipanteDTO(nombreInput.getText(), emailInput.getText(), GestorCompetencia.getCompetencia().getId_competencia(), false);
                    else
                        participanteDTO = new ParticipanteDTO(nombreInput.getText(), emailInput.getText(), GestorCompetencia.getCompetencia().getId_competencia(), true);
                    List<Error> errorList = GestorCompetencia.crearPart(participanteDTO);
                    if (!errorList.isEmpty()) {
                        for (Error error : errorList) {
                            if (error instanceof ErrorNombreParticipanteRepetido)
                                nombreError.setText(error.getMensajeError());
                            if (error instanceof ErrorEmailParticipanteRepetido)
                                emailError.setText(error.getMensajeError());
                        }
                        return;
                    }
                    JOptionPane.showMessageDialog(self, "Participante creado con éxito");
                    Gestor.pop();
                    JFrame pantallaParticipantes = Gestor.peek();
                    synchronized (pantallaParticipantes) {
                        pantallaParticipantes.notify();
                    }
                }
            });
        }
    }
}


