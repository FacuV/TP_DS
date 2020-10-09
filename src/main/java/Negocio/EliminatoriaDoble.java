package Negocio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "eliminatoria_doble")
@PrimaryKeyJoinColumn(name="id_competencia")
public class EliminatoriaDoble extends Competencia{
    public EliminatoriaDoble(){
        super();
    }
    public EliminatoriaDoble(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte, List<Disponibilidad> disponibilidades, List<Participante> participantes) {
        super(nombre, reglamento, puntuacion, estado, usuario, deporte, disponibilidades, participantes);
    }
    public EliminatoriaDoble(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte) {
        this(nombre,reglamento,puntuacion,estado,usuario,deporte,new ArrayList<Disponibilidad>(), new ArrayList<Participante>());
    }
}
