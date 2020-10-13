package Negocio;

import java.util.List;

public class CompetenciaDTO {
    public String nombre;
    public int id_deporte;
    public List<DisponibilidadDTO> lugares_realización;
    public String reglamento;
    public int id_usuario;
    public int modalidad_competencia;
    public int forma_Puntuación;
    public int cantidad_máxima_sets;
    public int tantos_equipo_ganador_por_ausencia;
    public int puntos_partido_ganado;
    public int puntos_presentarse;
    public boolean permite_empate;
    public int puntos_partido_empatado;
}
