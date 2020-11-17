package Daos;

import Negocio.Pais;
import Negocio.Provincia;

public interface ProvinciaDao {
    void createProvincia(Provincia provincia);
    Provincia getOrCreateProvincia(String nombre,Pais pais);
    Provincia getProvincia(String nombre);
    Provincia getProvincia(int id_provincia);
}
