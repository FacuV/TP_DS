package Negocio;

import java.util.ArrayList;

public class EliminatoriaDoble extends Competencia{
    protected EliminatoriaDoble(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte, ArrayList<Disponibilidad> disponibilidades, ArrayList<Participante> participantes) {
        super(nombre, reglamento, puntuacion, estado, usuario, deporte, disponibilidades, participantes);
    }
    protected EliminatoriaDoble(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte) {
        this(nombre,reglamento,puntuacion,estado,usuario,deporte,new ArrayList<Disponibilidad>(), new ArrayList<Participante>());
    }
}
