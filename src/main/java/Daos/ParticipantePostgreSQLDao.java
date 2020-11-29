package Daos;

import Negocio.Competencia;
import Negocio.Participante;
import Negocio.ParticipanteDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ParticipantePostgreSQLDao implements ParticipanteDao{
    private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
    private EntityManager manager;
    @Override
    public boolean nombreUnico(ParticipanteDTO participanteDTO) {
        boolean rtn = false;
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Competencia competencia = manager.find(Competencia.class,participanteDTO.id_competencia);
        for(Participante participante:competencia.getParticipantes()){
            if(participante.getNombre().equals(participanteDTO.nombre)) rtn=true;
        }
        manager.getTransaction().commit();
        manager.close();
        return rtn;
    }

    @Override
    public boolean emailUnico(ParticipanteDTO participanteDTO) {
        boolean rtn = false;
        manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();
        Competencia competencia = manager.find(Competencia.class,participanteDTO.id_competencia);
        for(Participante participante:competencia.getParticipantes()){
            if(participante.getEmail().equals(participanteDTO.email)) rtn=true;
        }
        manager.getTransaction().commit();
        manager.close();
        return rtn;
    }
}
