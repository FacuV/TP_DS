package Negocio;

public class EncuentroDTO{
    public int id_encuentro;
    public int fase;
    public ParticipanteDTO participanteA;
    public ParticipanteDTO participanteB;
    public int id_lugarRealizacion;

    public EncuentroDTO() {
    }

    public EncuentroDTO(int id_encuentro, int fase, ParticipanteDTO participanteA, ParticipanteDTO participanteB, int id_lugarRealizacion) {
        this.id_encuentro = id_encuentro;
        this.fase = fase;
        this.participanteA = participanteA;
        this.participanteB = participanteB;
        this.id_lugarRealizacion = id_lugarRealizacion;
    }
}
