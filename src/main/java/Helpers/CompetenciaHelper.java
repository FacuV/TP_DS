package Helpers;

public class CompetenciaHelper {

    public static int getIdModalidad(String modalidad) {
        switch (modalidad) {
            case "Liga":
                return 0;
            case "Eliminatoria simple":
                return 1;
            case "Eliminatoria doble":
                return 2;
            default:
                return -1;
        }
    };

    public static int getIdFormaPuntuacion(String forma_puntuacion) {
        switch (forma_puntuacion) {
            case "Sistema de liga":
                return 0;
            case "Eliminatoria simple":
                return 1;
            case "Eliminatoria doble":
                return 2;
            default:
                return -1;
        }
    };
}
