package Helpers;

import java.text.Normalizer;

public abstract class Normalizador {
    /**
     *
     * @param string una cadena que se quiera normalizar
     * @return una cadena normalizada y en mayusculas
     */
    public static String normalizar(String string){
        String rtn = string.toUpperCase();
        rtn = cleanString(rtn);
        return rtn;
    }
    public static String cleanString(String texto) {
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }
}
