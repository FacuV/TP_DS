package Pantallas.MisCompetencias;
import GestorPantallas.Gestor;
import Interface.JPantalla;
import Negocio.Competencia;
import Pantallas.MisCompetencias.VerCompetencia.VerCompetencia;
import Servicio.GestorCompetencia;
import org.hibernate.cfg.JPAIndexHolder;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MisCompetencias extends JPantalla {
    private MisCompetencias self = this;
    private List Lista = new List(self);
    private JButton AgregarCompetencia = new JButton("Agregar competencia");
    private GridBagConstraints gbc = new GridBagConstraints();
    private MainView mainView = new MainView(this);

    public MisCompetencias(){
        super("Mis competencias","Volver");
        body.setLayout(new GridBagLayout());
        body.add(new Header(Lista),new Header.Constraints());
        body.add(new Filters(Lista),new Filters.Constraints());
        body.add(mainView, MainView.getConstraints()); mainView.add(Lista);
        gbc.gridy = 2;
        gbc.gridx = 0;
        body.add(AgregarCompetencia,gbc);
        AgregarCompetencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gestor.push("nueva_competencia");
            }
        });
    };
    private static class MainView extends JPanel {
        GridBagConstraints gbc = new GridBagConstraints();

        public MainView(MisCompetencias misCompetencias) {
            super(new GridBagLayout());
            setBorder(new EmptyBorder(20,20,20,20));
                gbc.weightx = 1;
                gbc.weighty = 1;
                gbc.fill = GridBagConstraints.BOTH;
        };

        @Override
        public Component add(Component comp) {
            super.add(comp,gbc);
            return comp;
        };

        public static GridBagConstraints getConstraints() {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weightx = 3;
            gbc.weighty = 1;
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridheight = 2;
            return gbc;
        };
    } ;

    public void setCompetencia(Competencia competencia) {
        GestorCompetencia.setCompetencia(competencia);
        mainView.remove(0);
        mainView.add(new VerCompetencia(this));
        revalidate();
    }

    public void unsetCompetencia() {
        GestorCompetencia.setCompetencia(null);
        mainView.remove(0);
        mainView.add(Lista);
        revalidate();
    };
};
