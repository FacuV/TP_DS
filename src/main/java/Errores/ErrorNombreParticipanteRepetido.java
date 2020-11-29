package Errores;

public class ErrorNombreParticipanteRepetido extends Error{
    public ErrorNombreParticipanteRepetido() {
        super("Este nombre ya existe en otro participante");
    }
}
