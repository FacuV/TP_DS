package Negocio;

public abstract class Participante {
    protected int id_participante;
    protected String nombre;
    protected String email;
    protected Participante(String nombre,String email){
        this.nombre = nombre;
        this.email = email;
    }
}
