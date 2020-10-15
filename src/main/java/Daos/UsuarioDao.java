package Daos;

import Negocio.Usuario;

public interface UsuarioDao {
    Usuario createUsuario(Usuario usuario);
    void deleteUsuario(Usuario usuario);
    Usuario getUsuario(int id_usuario);
    Usuario getUsuario(String nombre);
    void updateUsuario(Usuario usuario);
}
