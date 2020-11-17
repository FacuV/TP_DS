package Daos;

import Negocio.Usuario;

import java.util.List;

public interface UsuarioDao {
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(Usuario usuario);
    Usuario getUsuario(int id_usuario);
    Usuario getUsuario(String nombre);
    Usuario getUsuarioByEmail(String correoElectronico);
    List<Usuario> getUsuarios();
    void updateUsuario(Usuario usuario);
    boolean validarEmail(String correoElectronico);
    Usuario validarContraseña(String correoElectronico, String password);
}
