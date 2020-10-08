package Negocio;

import java.util.ArrayList;

public class CompetenciaDTO {
    public String nombre;
    public int id_deporte;
    public ArrayList<DisponibilidadDTO> lugares_realizacion;
    public String reglamento;
    public int id_usuario;
    public int modalidad_competencia;
    public int forma_puntuacion;
    public int cantidad_maxima_sets;
    public int tantos_equipo_ganador_por_ausencia;
    public int puntos_partido_ganado;
    public int puntos_presentarse;
    public boolean empate_permitido;
    public int puntos_empate;
}
