package Negocio;

import javax.persistence.Entity;

@Entity
public class Equipo extends Participante{
    public static final boolean TIPO = true;

    public Equipo() {
    }

    public Equipo(String nombre, String email){
        super(nombre,email);
    }
}
