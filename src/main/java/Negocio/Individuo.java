package Negocio;

import javax.persistence.Entity;

@Entity
public class Individuo extends Participante{
    public Individuo(String nombre,String email){
        super(nombre,email);
    }
}
