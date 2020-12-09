package Negocio;

public class ParticipanteDTO {
    public String nombre;
    public String email;
    public int id_competencia;
    public boolean tipo;
    public ParticipanteDTO(String nombre, String email,int id_competencia,boolean tipo) {
        this.nombre = nombre;
        this.email = email;
        this.id_competencia = id_competencia;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
