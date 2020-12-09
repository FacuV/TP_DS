package Negocio;
import Daos.DeportePostgreSQLDao;
import Helpers.CompetenciaHelper;

import java.util.List;

public class CompetenciaDTO {
    public int id_competencia;
    public String nombre;
    public int id_deporte;
    public List<DisponibilidadDTO> disponibilidades;
    public String reglamento;
    public int id_usuario;
    public String deporte;
    public String estado;
    public int modalidad_competencia;
    public int forma_Puntuación;
    public int cantidad_máxima_sets;
    public int tantos_equipo_ganador_por_ausencia;
    public int puntos_partido_ganado;
    public int puntos_presentarse;
    public boolean permite_empate;
    public int puntos_partido_empatado;
    public List<ParticipanteDTO> participantesDTO;
    public List<DisponibilidadDTO> disponibilidadesDTO;

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
    };

    public CompetenciaDTO(){

    };

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDeprote(String deporte) { this.deporte = deporte; };

    public int getId_deporte() {
        return id_deporte;
    }

    public void setId_deporte(int id_deporte) {
        this.id_deporte = id_deporte;
    };

    public void setDeporte(String deporte) {
        if (!deporte.isEmpty()) {
            this.id_deporte = DeportePostgreSQLDao.getDeporteId(deporte);
        }
    };

    public List<DisponibilidadDTO> getDisponibilidades() {
        return disponibilidades;
    }

    public void setDisponibilidades(List<DisponibilidadDTO> disponibilidades) {
        this.disponibilidades = disponibilidades;
    }

    public String getReglamento() {
        return reglamento;
    }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getModalidadCompetencia() {
        return modalidad_competencia;
    }

    public void setModalidadCompetencia(int modalidad_competencia) {
        this.modalidad_competencia = modalidad_competencia;
    }

    public void setModalidadCompetencia(String modalidad) {
        this.modalidad_competencia = CompetenciaHelper.getIdModalidad(modalidad);
    };

    public int getForma_Puntuación() {
        return forma_Puntuación;
    }

    public void setForma_Puntuación(int forma_Puntuación) {
        this.forma_Puntuación = forma_Puntuación;
    }

    public int getCantidad_máxima_sets() {
        return cantidad_máxima_sets;
    }

    public void setCantidad_máxima_sets(int cantidad_máxima_sets) {
        this.cantidad_máxima_sets = cantidad_máxima_sets;
    }

    public int getTantos_equipo_ganador_por_ausencia() {
        return tantos_equipo_ganador_por_ausencia;
    }

    public void setTantos_equipo_ganador_por_ausencia(int tantos_equipo_ganador_por_ausencia) {
        this.tantos_equipo_ganador_por_ausencia = tantos_equipo_ganador_por_ausencia;
    }

    public int getPuntos_partido_ganado() {
        return puntos_partido_ganado;
    }

    public void setPuntos_partido_ganado(int puntos_partido_ganado) {
        this.puntos_partido_ganado = puntos_partido_ganado;
    }

    public int getPuntos_presentarse() {
        return puntos_presentarse;
    }

    public void setPuntos_presentarse(int puntos_presentarse) {
        this.puntos_presentarse = puntos_presentarse;
    }

    public boolean isPermite_empate() {
        return permite_empate;
    }

    public void setPermite_empate(boolean permite_empate) {
        this.permite_empate = permite_empate;
    }

    public int getPuntos_partido_empatado() {
        return puntos_partido_empatado;
    }

    public void setPuntos_partido_empatado(int puntos_partido_empatado) {
        this.puntos_partido_empatado = puntos_partido_empatado;
    }
}

