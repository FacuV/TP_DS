package Daos;

import Negocio.LugarRealizacion;

public interface LugarRealizacionDao{
    LugarRealizacion createLugarRealizacion(LugarRealizacion lugarRealizacion);
    void deleteLugarRealizacion(LugarRealizacion lugarRealizacion);
    LugarRealizacion getLugarRealizacion(int id_lugar_realizacion);
    LugarRealizacion getLugarRealizacion(String nombre);
    void updateLugarRealizacion(LugarRealizacion lugarRealizacion);
}
