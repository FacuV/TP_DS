package Negocio;


import java.util.List;

public class CompetenciaDTO {
    public String nombre;
    public int id_deporte;
    public List<DisponibilidadDTO> disponibilidades;
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

    public CompetenciaDTO(String nombre, int id_deporte, List<DisponibilidadDTO> disponibilidades, String reglamento, int id_usuario, int modalidad_competencia, int forma_Puntuación, int cantidad_máxima_sets, int tantos_equipo_ganador_por_ausencia, int puntos_partido_ganado, int puntos_presentarse, boolean permite_empate, int puntos_partido_empatado) {
        this.nombre = nombre;
        this.id_deporte = id_deporte;
        this.disponibilidades = disponibilidades;
        this.reglamento = reglamento;
        this.id_usuario = id_usuario;
        this.modalidad_competencia = modalidad_competencia;
        this.forma_Puntuación = forma_Puntuación;
        this.cantidad_máxima_sets = cantidad_máxima_sets;
        this.tantos_equipo_ganador_por_ausencia = tantos_equipo_ganador_por_ausencia;
        this.puntos_partido_ganado = puntos_partido_ganado;
        this.puntos_presentarse = puntos_presentarse;
        this.permite_empate = permite_empate;
        this.puntos_partido_empatado = puntos_partido_empatado;
    }
}

