package Negocio;

import javax.persistence.Entity;

@Entity
public class Individuo extends Participante{
    public static final boolean TIPO = false;

    public Individuo() {
    }

    public Individuo(String nombre, String email){
        super(nombre,email);
    }
}
