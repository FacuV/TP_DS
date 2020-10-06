package Negocio;

public class PuntuacionPuntaje extends Puntuacion{
    private int puntos_vic_ausencia;
    public PuntuacionPuntaje(int puntos_vic_ausencia) {
        super();
        this.puntos_vic_ausencia = puntos_vic_ausencia;
    }
    public int getPuntos_vic_ausencia() {
        return puntos_vic_ausencia;
    }
}
