package Servicio;

import Daos.UsuarioDao;
import Daos.UsuarioPostgreSQLDao;
import Errores.Error;
import Errores.ErrorAutenticacion;
import Negocio.Usuario;

public abstract class GestorUsuarios {
    private static Usuario usuarioLogueado;
    private static UsuarioDao usuarioDao = new UsuarioPostgreSQLDao();

    public static Error autenticarUsuario(String correoElectronico, String password){
        Error error = null;
        //Validacion de email
        if(!usuarioDao.validarEmail(correoElectronico)){
            error = new ErrorAutenticacion("El usuario o la contraseña no son válidos");
            return error;
        }
        usuarioLogueado = usuarioDao.validarContraseña(correoElectronico, password);
        if(usuarioLogueado == null){
            error = new ErrorAutenticacion("El usuario o la contraseña no son válidos");
        }
        return error;
    }

    public static Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public static void setUsuarioLogueado(Usuario usuarioLogueado) {
        GestorUsuarios.usuarioLogueado = usuarioLogueado;
    }
}
