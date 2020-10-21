package Daos;

import Negocio.Deporte;
import Negocio.LugarRealizacion;
import Negocio.Usuario;
import Servicio.Password;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuarioPostgreSQLDao implements UsuarioDao{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private EntityManager manager;
    @Override
    public Usuario createUsuario(Usuario usuario) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        manager.getTransaction().begin();
        usuario = (Usuario) manager.createQuery("FROM Usuario WHERE nombre = '"+usuario.getNombre()+"'").getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return usuario;
    }
    @Override
    public void deleteUsuario(Usuario usuario) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(usuario);
        manager.getTransaction().commit();
        manager.close();
    }
    @Override
    public Usuario getUsuario(int id_usuario) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Usuario usuario = manager.find(Usuario.class,id_usuario);
        manager.getTransaction().commit();
        manager.close();
        return usuario;
    }

    @Override
    public Usuario getUsuario(String nombre) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Usuario usuario = (Usuario) manager.createQuery("FROM Usuario WHERE nombre = '"+nombre+"'").getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return usuario;
    }
    @Override
    public Usuario getUsuarioByEmail(String correoElectronico){
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Usuario usuario = (Usuario) manager.createQuery("FROM Usuario WHERE email = '"+correoElectronico+"'").getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return usuario;
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.getTransaction().commit();
        manager.close();
    }

    public boolean validarEmail(String correoElectronico){
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        boolean rtn = !(manager.createQuery("FROM Usuario WHERE email = '"+correoElectronico+"'").getResultList().isEmpty());
        manager.getTransaction().commit();
        manager.close();
        return rtn;
    }

    @Override
    public Usuario validarContraseña(String correoElectronico, String password){
        Usuario usuario = getUsuarioByEmail(correoElectronico);
        try {
            if(!Password.check(password,usuario.getContraseña())){
                usuario = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }
}
