package Daos;

import Negocio.Competencia;
import Negocio.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class CompetenciaPostgreSQLDao implements CompetenciaDao{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private EntityManager manager;
    @Override
    public Competencia createCompetencia(Competencia competencia) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(competencia);
        manager.getTransaction().commit();
        manager.getTransaction().begin();
        competencia = (Competencia) manager.createQuery("FROM Competencia WHERE nombre = '"+competencia.getNombre()+"'").getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return competencia;
    }

    @Override
    public void deleteCompetencia(Competencia competencia) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        manager.remove(competencia);
        manager.getTransaction().commit();
        manager.close();
    }

    @Override
    public Competencia getCompetencia(int id_competencia) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Competencia competencia = manager.find(Competencia.class,id_competencia);
        manager.getTransaction().commit();
        manager.close();
        return competencia;
    }

    @Override
    public Competencia getCompetencia(String nombre) {
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Competencia competencia = (Competencia) manager.createQuery("FROM Competencia WHERE nombre = '"+nombre+"'").getSingleResult();
        manager.getTransaction().commit();
        manager.close();
        return competencia;
    }
    @Override
    public List<Competencia> getCompetencias(Usuario usuario) {
        List competencias;
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        competencias = manager.createQuery("FROM Competencia WHERE baja_logica = false and id_usuario = "+ String.valueOf(usuario.getId_usuario())).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return competencias;
    }
    @Override
    public List<Competencia> getCompetencias(){
        List competencias;
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        competencias = manager.createQuery("FROM Competencia WHERE baja_logica = false").getResultList();
        manager.getTransaction().commit();
        manager.close();
        return competencias;
    }

    @Override
    public List<Competencia> getByCriteria(String consulta) {
        List competencias;
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        competencias = manager.createQuery(consulta).getResultList();
        manager.getTransaction().commit();
        manager.close();
        return competencias;
    }

    @Override
    public Competencia updateCompetencia(Competencia competencia){
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Competencia rtn = manager.merge(competencia);
        manager.getTransaction().commit();
        manager.close();
        return rtn;
    }

    @Override
    public boolean nombreUnico(String nombre) {
        boolean rtn = true;
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        if(manager.createQuery("FROM Competencia WHERE nombre = '"+nombre+"'").getResultList().isEmpty())rtn = false;
        manager.getTransaction().commit();
        manager.close();
        return rtn;
    }
}