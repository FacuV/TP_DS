package Daos;

import Negocio.Pais;

public interface PaisDao {
    void createPais(Pais pais);
    Pais getOrCreatePais(String nombre);
    Pais getPais(String nombre);
    Pais getPais(int id_pais);
}
