package Daos;

public class CompetenciaPostgreSQLDao implements CompetenciaDao{

    @Override
    public boolean validarUnicidadNombre(String nombre) {
        return false;
    }
}
