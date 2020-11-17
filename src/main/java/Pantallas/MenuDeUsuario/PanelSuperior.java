package Pantallas.MenuDeUsuario;

import GestorPantallas.Gestor;
import Negocio.UsuarioDTO;
import Servicio.GestorUsuarios;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class PanelSuperior extends JPanel{
    JLabel seleccionarUsuario = new JLabel("Seleccione un usuario para iniciar");
    JLabel error = new JLabel("");
    JComboBox listaUsuarios = new JComboBox();
    public PanelSuperior(){
        super();
        seleccionarUsuario.setFont(new Font(Font.DIALOG,Font.PLAIN,30));
        setLayout(new GridBagLayout());
        //Cargar usuarios al comboBox
        List<UsuarioDTO> usuariosDTO = GestorUsuarios.getUsuarios();
        for(UsuarioDTO usuarioDTO: usuariosDTO) listaUsuarios.addItem(usuarioDTO);

        GridBagConstraints gridBagConstraintLabel = new GridBagConstraints();
            gridBagConstraintLabel.weightx = 1;
            gridBagConstraintLabel.gridy = 1;
            gridBagConstraintLabel.insets = new Insets(50,50,30,50);
        add(seleccionarUsuario,gridBagConstraintLabel);
        GridBagConstraints gridBagConstraintError = new GridBagConstraints();
            gridBagConstraintError.weightx = 1;
            gridBagConstraintError.gridy = 2;
            gridBagConstraintError.insets = new Insets(5,50,5,50);
        add(error,gridBagConstraintError);
        GridBagConstraints gridBagConstraintCombo = new GridBagConstraints();
            gridBagConstraintCombo.weightx = 1;
            gridBagConstraintCombo.gridy = 3;
        add(listaUsuarios,gridBagConstraintCombo);
    }
    public void setError(String mensajeError){error.setText(mensajeError);}
    public UsuarioDTO getUsuarioSeleccionado(){return (UsuarioDTO) listaUsuarios.getSelectedItem();}
    static public class Constraints extends GridBagConstraints {
        public Constraints(){
            weightx = 1;
            weighty = 1.5;
            gridy = 1;
            fill = GridBagConstraints.VERTICAL;
            anchor = GridBagConstraints.CENTER;
            insets = new Insets(0,50,0,50);
        }
    }
}
