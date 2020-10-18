package Pantallas.NuevaCompetencia;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormaPuntuacion extends JPanel {
    private GridBagConstraints gbc = new GridBagConstraints();
    private JPanel puntosGanados = new JPanel(new GridLayout(3,2));
    private JPanel tiePointsContainer = new JPanel(new GridLayout(1,2));

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
        setUpCheckBoxes();

        add(new JLabel("Forma de puntuación",SwingUtilities.CENTER),gbc);

        JPanel tipoPuntuacion = new JPanel();
        tipoPuntuacion.setLayout(new GridLayout(3,3));
        //Primera fila
        tipoPuntuacion.add(hasPuntos);
        tipoPuntuacion.add(new JLabel("PUntos victoria por ausencia"));
        tipoPuntuacion.add(puntosPorAusencia);
        //Segunda fila
        tipoPuntuacion.add(hasSets);
        tipoPuntuacion.add(new JLabel("Cantidad máxima de sets"));
        tipoPuntuacion.add(cantidadSets);
        //Tercera fila
        tipoPuntuacion.add(hasFinalResult);

        puntosGanados.add(new Label("Puntos por partido ganado"));
        puntosGanados.add(new Label("Puntos por presentarse"));
        puntosGanados.add(puntosPorGanar);
        puntosGanados.add(puntosPorPresentarse);
        puntosGanados.add(hasTie);
        tiePointsContainer.add(new JLabel("Puntos por empate"));
        tiePointsContainer.add(puntosPorEmpate);
        puntosGanados.add(tiePointsContainer);

        gbc.gridy = index++; add(tipoPuntuacion,gbc);
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
        hasSets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasFinalResult.setSelected(false);
                hasPuntos.setSelected(false);
            }
        });
        hasPuntos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasFinalResult.setSelected(false);
                hasSets.setSelected(false);
            }
        });
        hasFinalResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hasPuntos.setSelected(false);
                hasSets.setSelected(false);
            }
        });
    };

    public String getCantidadSets() {
        return this.cantidadSets.getText();
    };
    public void hidePuntosGanados(boolean hidden) {
        puntosGanados.setVisible(hidden);
    };
    public String getPuntosPorGanar() {
        return this.puntosPorGanar.getText();
    };
    public String getPuntosPorPresentarse() {
        return this.puntosPorPresentarse.getText();
    };
    public String getPuntosPorAusencia() {
        return this.puntosPorAusencia.getText();
    };
    public String getPuntosPorEmpate() {
        return this.puntosPorEmpate.getText();
    };
    public boolean getHasPuntos() {
        return this.hasPuntos.isSelected();
    };
    public boolean getHasSets() {
        return this.hasSets.isSelected();
    };
    public boolean getHasFinalResult() {
        return this.hasFinalResult.isSelected();
    };
    public boolean getHasTie(){
        return this.hasTie.isSelected();
    };
};
