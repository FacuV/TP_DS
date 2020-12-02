package Pantallas.MisCompetencias;
import Daos.CompetenciaPostgreSQLDao;
import Negocio.Competencia;
import Negocio.CompetenciaDTO;
import Servicio.GestorUsuarios;

import javax.swing.*;
import java.awt.*;

public class List extends JScrollPane {
    private CompetenciaDTO competencias[];
    private JPanel View = new JPanel(new GridBagLayout());
    private GridBagConstraints gbc = new GridBagConstraints();

    public List() {
        super();
        gbc.gridy = 0; gbc.fill = GridBagConstraints.BOTH;
        View.setBackground(Color.pink);
        View.add(new ItemCompetencia("asdf"), gbc); gbc.gridy++;
        View.add(new ItemCompetencia("asdf"), gbc); gbc.gridy++;
        View.add(new ItemCompetencia("asdf"), gbc); gbc.gridy++;
        View.add(new ItemCompetencia("asdf"), gbc); gbc.gridy++;
        View.add(new ItemCompetencia("asdf"), gbc); gbc.gridy++;
        setViewportView(View);
    };

    public static class Constraints extends GridBagConstraints {
        public Constraints() {
            fill = GridBagConstraints.BOTH;
            gridx = 1;
            gridy = 1;
            weightx = 3;
            weighty = 1;
        };
    };
};
