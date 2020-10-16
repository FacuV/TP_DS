package Pantallas.NuevaCompetencia;
import javax.swing.*;
import java.awt.*;

public class FormaPuntuacion extends JPanel {
    JPanel puntosGanados = new JPanel();
    JCheckBox hasFinalResult = new JCheckBox();
    JCheckBox hasSets = new JCheckBox();
    JCheckBox hasPuntos = new JCheckBox();
    JCheckBox hasTie = new JCheckBox();
    JTextField puntosPorGanar = new JTextField();
    JTextField puntosPorPresentarse = new JTextField();
    JTextField cantidadSets = new JTextField();
    JTextField puntosPorAusencia = new JTextField();
    JTextField puntosPorEmpate = new JTextField();
    private int index = 0;

    public FormaPuntuacion () {
        setLayout(new GridBagLayout());

        JLabel subtitle = new JLabel("Forma de puntuación");
        GridBagConstraints subtitleConstraints = new GridBagConstraints();
        subtitleConstraints.gridy = index++;
        add(subtitle,subtitleConstraints);

        JPanel puntos = new JPanel();
        puntos.setLayout(new GridLayout(1,3));
        GridBagConstraints puntosConstraints = new GridBagConstraints();
        puntosConstraints.gridy = index++;
        puntosConstraints.weightx = 1;
        puntosConstraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel puntosLabel = new JLabel("Puntos victoria por ausencia",SwingConstants.LEFT);

        puntos.add(hasPuntos);
        puntos.add(puntosLabel);
        puntos.add(puntosPorAusencia);
        add(puntos,puntosConstraints);

        JPanel sets = new JPanel();
        sets.setLayout(new GridLayout(1,3));
        GridBagConstraints cantidadSetsConstraints = new GridBagConstraints();
        cantidadSetsConstraints.gridy = index++;
        cantidadSetsConstraints.weightx = 1;
        cantidadSetsConstraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel setsLabel = new JLabel("Cantidad máxima de sets.",SwingConstants.LEFT);

        sets.add(hasSets);
        sets.add(setsLabel);
        sets.add(cantidadSets);
        add(sets,cantidadSetsConstraints);

        JPanel finalResult = new JPanel();
        finalResult.setLayout(new GridLayout(1,3));
        GridBagConstraints finalResultConstraints = new GridBagConstraints();
        finalResultConstraints.gridy = index++;
        finalResultConstraints.weightx = 1;
        finalResultConstraints.fill = GridBagConstraints.HORIZONTAL;

        JLabel finalResultLabel = new JLabel("Resultado final.",SwingConstants.LEFT);
        finalResultLabel.setOpaque(true);
        finalResult.add(hasFinalResult);
        finalResult.add(finalResultLabel);
        finalResult.add(new JLabel(""));
        add(finalResult,finalResultConstraints);

        puntosGanados.setLayout(new GridLayout(2,2));
        puntosGanados.add(new Label("Puntos por partido ganado"));
        puntosGanados.add(new Label("Puntos por presentarse"));
        puntosGanados.add(puntosPorGanar);
        puntosGanados.add(puntosPorPresentarse);

        GridBagConstraints puntosGanadosConstraints = new GridBagConstraints();
        puntosGanadosConstraints.gridy = index++;
        puntosGanadosConstraints.weightx = 1;
        puntosGanadosConstraints.fill = GridBagConstraints.HORIZONTAL;

        add(puntosGanados,puntosGanadosConstraints);

        JPanel tie = new JPanel();
        tie.setLayout(new GridLayout(1,4));
        tie.add(hasTie);
        tie.add(new JLabel("Empate Permitido"));
        tie.add(new JLabel("Puntos por empate"));
        tie.add(puntosPorEmpate);

        GridBagConstraints tieConstraints = new GridBagConstraints();
        tieConstraints.gridy = index++;
        tieConstraints.weightx = 1;
        tieConstraints.fill = GridBagConstraints.HORIZONTAL;
        
        add(tie,tieConstraints);
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

    static public class Constraints extends GridBagConstraints {
        public Constraints () {
            weightx = 1;
            fill = GridBagConstraints.HORIZONTAL;
            gridy = 10;
        }
    };
};
