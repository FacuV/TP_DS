package Errores;

public class ErrorEmailParticipanteRepetido extends Error{
    public ErrorEmailParticipanteRepetido() {
        super("Este email ya existe en otro participante");
    }
}
