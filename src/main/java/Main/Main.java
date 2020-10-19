package Main;


import Negocio.Usuario;
import Servicio.GestorUsuarios;
import Servicio.Password;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println(GestorUsuarios.autenticarUsuario("pablodl77@gmail.com","pass123"));
        System.out.println(Password.check("pass123","xaJ7wMYOrY47mOEjz0w534i3/EhaCt2aQsnx1rstNsw=$TZCn4v7s9cIheD5OaUI2N4lxox5M6X/9fgUFkk7fSA4="));



    }
}
