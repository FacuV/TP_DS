package Exceptions;

public class CompetenciaVaciaException extends RuntimeException{
    public CompetenciaVaciaException(){
        super("No hay una competencia global en GestorCompetencias");
    }
}
