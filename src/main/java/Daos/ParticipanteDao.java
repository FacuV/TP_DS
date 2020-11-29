package Daos;

import Negocio.ParticipanteDTO;

public interface ParticipanteDao {
    boolean nombreUnico(ParticipanteDTO participanteDTO);
    boolean emailUnico(ParticipanteDTO participanteDTO);
}
