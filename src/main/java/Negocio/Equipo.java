package Negocio;

import javax.persistence.Entity;

@Entity
public class Equipo extends Participante{
    public Equipo(int id_participante,String nombre,String email){
        super(nombre,email);
    }
}
