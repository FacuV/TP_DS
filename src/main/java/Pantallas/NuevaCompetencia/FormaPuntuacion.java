package Pantallas.NuevaCompetencia;
import javax.swing.*;
import java.awt.*;

public class FormaPuntuacion extends JPanel {
    JPanel puntosGanados = new JPanel();

    public FormaPuntuacion () {
        setLayout(new GridBagLayout());

        JLabel subtitle = new JLabel("Forma de puntuación");
        GridBagConstraints subtitleConstraints = new GridBagConstraints();
        subtitleConstraints.gridy = 6;
        add(subtitle,subtitleConstraints);

        JPanel puntos = new JPanel();
        puntos.setLayout(new GridLayout(1,3));
        GridBagConstraints puntosConstraints = new GridBagConstraints();
        puntosConstraints.gridy = 7;
        puntosConstraints.weightx = 1;
        puntosConstraints.fill = GridBagConstraints.HORIZONTAL;
        JCheckBox hasPuntos = new JCheckBox();
        JLabel puntosLabel = new JLabel("Puntos victoria por ausencia",SwingConstants.LEFT);
        JTextField puntosCantidad = new JTextField();
        puntos.add(hasPuntos);
        puntos.add(puntosLabel);
        puntos.add(puntosCantidad);
        add(puntos,puntosConstraints);

        JPanel sets = new JPanel();
        sets.setLayout(new GridLayout(1,3));
        GridBagConstraints setsConstraints = new GridBagConstraints();
        setsConstraints.gridy = 8;
        setsConstraints.weightx = 1;
        setsConstraints.fill = GridBagConstraints.HORIZONTAL;
        JCheckBox hasSets = new JCheckBox();
        JLabel setsLabel = new JLabel("Cantidad máxima de sets.",SwingConstants.LEFT);
        JTextField setsCantidad = new JTextField();
        sets.add(hasSets);
        sets.add(setsLabel);
        sets.add(setsCantidad);
        add(sets,setsConstraints);

        JPanel finalResult = new JPanel();
        finalResult.setLayout(new GridLayout(1,3));
        GridBagConstraints finalResultConstraints = new GridBagConstraints();
        finalResultConstraints.gridy = 9;
        finalResultConstraints.weightx = 1;
        finalResultConstraints.fill = GridBagConstraints.HORIZONTAL;
        JCheckBox hasFinalResult = new JCheckBox();
        JLabel finalResultLabel = new JLabel("Resultado final.",SwingConstants.LEFT);
        finalResultLabel.setOpaque(true);
        finalResult.add(hasFinalResult);
        finalResult.add(finalResultLabel);
        finalResult.add(new JLabel(""));
        add(finalResult,finalResultConstraints);

        puntosGanados.setLayout(new GridLayout(2,2));
        puntosGanados.add(new Label("Puntos por partido ganado"));
        puntosGanados.add(new Label("Puntos por presentarse"));
        JTextField puntosPorGanar = new JTextField();
        puntosGanados.add(puntosPorGanar);
        JTextField puntosPorPresentarse = new JTextField();
        puntosGanados.add(puntosPorPresentarse);

        GridBagConstraints puntosGanadosConstraints = new GridBagConstraints();
        puntosGanadosConstraints.gridy = 10;
        puntosGanadosConstraints.weightx = 1;
        puntosGanadosConstraints.fill = GridBagConstraints.HORIZONTAL;

        add(puntosGanados,puntosGanadosConstraints);
    };

    public void hidePuntosGanados(boolean hidden) {
        puntosGanados.setVisible(hidden);
    };

    static public class Constraints extends GridBagConstraints {
        public Constraints () {
            weightx = 1;
            fill = GridBagConstraints.HORIZONTAL;
            gridy = 10;
        }
    };
};
