package Daos;

import Negocio.Localidad;
import Negocio.Pais;
import Negocio.Provincia;

public interface LocalidadDao {
    void createLocalidad(Localidad localidad);
    Localidad getOrCreateLocalidad(String nombre, Provincia provincia);
    Localidad getLocalidad(String nombre);
    Localidad getLocalidad(int id_localidad);
}
