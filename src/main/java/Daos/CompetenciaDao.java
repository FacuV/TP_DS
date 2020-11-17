package Daos;

import Negocio.Competencia;
import Negocio.Usuario;
import java.util.List;

public interface CompetenciaDao {
    Competencia createCompetencia(Competencia competencia);
    void deleteCompetencia(Competencia competencia);
    Competencia getCompetencia(int id_competencia);
    Competencia getCompetencia(String nombre);
    List<Competencia> getCompetencias(Usuario usuario);
    List<Competencia> getCompetencias();
    List<Competencia> getByCriteria(String consulta);
    void updateCompetencia(Competencia competencia);
    boolean nombreUnico(String nombre);
}