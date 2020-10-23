package Pantallas.NuevaCompetencia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormaPuntuacion extends JPanel {
    private GridBagConstraints gbc = new GridBagConstraints();
    private JPanel puntosGanados = new JPanel(new GridLayout(3,2));
    private JPanel tiePointsContainer = new JPanel(new GridLayout(1,2));

    private JLabel errorFormaPuntuacion = new JLabel("");
    private JLabel errorPuntos = new JLabel("");
    private JLabel errorSets = new JLabel("");

    private JCheckBox hasSets = new JCheckBox("Sets");
    private JCheckBox hasPuntos = new JCheckBox("Puntos");
    private JCheckBox hasFinalResult = new JCheckBox("Resultado final");
    private JCheckBox hasTie = new JCheckBox("Empate");

    private JTextField puntosPorGanar = new JTextField();
    private JTextField puntosPorPresentarse = new JTextField();
    private JTextField cantidadSets = new JTextField();
    private JTextField puntosPorAusencia = new JTextField();
    private JTextField puntosPorEmpate = new JTextField();

    private int index = 0;

    public FormaPuntuacion () {
        setLayout(new GridBagLayout());
        gbc.gridy = index++; gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        errorFormaPuntuacion.setForeground(Color.red);
        setUpCheckBoxes();

        add(new JLabel("Forma de puntuación",SwingUtilities.CENTER),gbc);
        gbc.gridy = index++; add(errorFormaPuntuacion,gbc);
        gbc.gridy = index++; errorSets.setForeground(Color.red); add(errorSets,gbc);

        JPanel tipoPuntuacion = new JPanel();
        tipoPuntuacion.setLayout(new GridLayout(3,3));
        //Primera fila
        tipoPuntuacion.add(hasPuntos);
        tipoPuntuacion.add(new JLabel("Puntos victoria por ausencia"));
        tipoPuntuacion.add(puntosPorAusencia);
        //Segunda fila
        tipoPuntuacion.add(hasSets);
        tipoPuntuacion.add(new JLabel("Cantidad máxima de sets"));
        tipoPuntuacion.add(cantidadSets);
        //Tercera fila
        tipoPuntuacion.add(hasFinalResult);

        gbc.gridy = index++;
        errorPuntos.setForeground(Color.red);

        puntosGanados.add(new Label("Puntos por partido ganado"));
        puntosGanados.add(new Label("Puntos por presentarse"));
        puntosGanados.add(puntosPorGanar);
        puntosGanados.add(puntosPorPresentarse);
        puntosGanados.add(hasTie);
        tiePointsContainer.add(new JLabel("Puntos por empate"));
        tiePointsContainer.add(puntosPorEmpate);
        puntosGanados.add(tiePointsContainer);

//        puntosPartGanadoEmpatadoError.setForeground(Color.RED);
//        puntosGanados.add(puntosPartGanadoEmpatadoError);

        gbc.gridy = index++; add(tipoPuntuacion,gbc);
        gbc.gridy = index++; add(errorPuntos,gbc);
        gbc.gridy = index++; add(puntosGanados,gbc);
    };

    static public class Constraints extends GridBagConstraints {
        public Constraints () {
            weightx = 1;
            fill = GridBagConstraints.HORIZONTAL;
            gridy = 10;
        }
    };

    private void setUpCheckBoxes() {
        puntosPorAusencia.setEnabled(false);
        cantidadSets.setEnabled(false);
        hasSets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasFinalResult.setSelected(false);
                hasPuntos.setSelected(false); puntosPorAusencia.setEnabled(false);
                cantidadSets.setEnabled(true);
                if (!hasSets.isSelected()) cantidadSets.setEnabled((false));
            }
        });
        hasPuntos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasFinalResult.setSelected(false);
                hasSets.setSelected(false); cantidadSets.setEnabled(false);
                puntosPorAusencia.setEnabled(true);
                if (!hasPuntos.isSelected()) puntosPorAusencia.setEnabled((false));
            }
        });
        hasFinalResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasPuntos.setSelected(false); puntosPorAusencia.setEnabled(false);
                hasSets.setSelected(false); cantidadSets.setEnabled(false);
            }
        });
    };

    public String getCantidadSets() { return this.cantidadSets.getText(); };
    public void hidePuntosGanados(boolean hidden) { puntosGanados.setVisible(hidden); };
    public String getPuntosPorGanar() { return this.puntosPorGanar.getText(); };
    public String getPuntosPorPresentarse() { return this.puntosPorPresentarse.getText(); };
    public String getPuntosPorAusencia() { return this.puntosPorAusencia.getText(); };
    public String getPuntosPorEmpate() { return this.puntosPorEmpate.getText(); };
    public boolean getHasPuntos() { return this.hasPuntos.isSelected(); };
    public boolean getHasSets() { return this.hasSets.isSelected(); };
    public boolean getHasFinalResult() { return this.hasFinalResult.isSelected(); };
    public boolean getHasTie(){ return this.hasTie.isSelected(); };

    public void setErrorFormaPuntuacion(String error) {errorFormaPuntuacion.setText(error);};
    public void setErrorPuntos(String error) { this.errorPuntos.setText(error); };
    public void setErrorSets(String error) { this.errorSets.setText(error); };
//
//    public void setPuntosPartGanadoEmpatadoError(String error){puntosPartGanadoEmpatadoError.setText(error);}
//
//    public void setPuntosPartGanadoPresentarseError(String error){puntosPartGanadoPresentarseError.setText(error);}
};
