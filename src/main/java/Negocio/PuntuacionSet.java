package Negocio;

public class PuntuacionSet extends Puntuacion{
    private int cant_sets_max;
    public PuntuacionSet(int cant_sets_max) {
        super();
        this.cant_sets_max = cant_sets_max;
    }
    public int getcant_sets_max() {
        return cant_sets_max;
    }
}
