package Servicio;

import Daos.UsuarioDao;
import Daos.UsuarioPostgreSQLDao;
import Errores.Error;
import Errores.ErrorEmail;
import Negocio.Usuario;

import java.util.ArrayList;
import java.util.List;


public abstract class GestorUsuarios {
    private Usuario usuarioLogueado;
    private static UsuarioDao usuarioDao = new UsuarioPostgreSQLDao();

    public static List<Error> autenticarUsuario(String correoElectronico, String password){
        List<Error> listaErrores = new ArrayList<>();
        //Validacion de email
        if(!usuarioDao.validarEmail(correoElectronico)){
            listaErrores.add(new ErrorEmail("El email ingresado no esta asociado a ningun usuario"));
            return listaErrores;
        }
        if()
        return listaErrores;
    }


    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }
}
