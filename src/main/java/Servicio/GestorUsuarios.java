package Servicio;

import Daos.*;
import Errores.Error;
import Errores.ErrorAutenticacion;
import Errores.ErrorEmail;
import Errores.ErrorHash;
import Helpers.Normalizador;
import Negocio.*;
import java.util.ArrayList;
import java.util.List;

public abstract class GestorUsuarios {
    private static Usuario usuarioLogueado;
    private static UsuarioDao usuarioDao = new UsuarioPostgreSQLDao();
    private static PaisDao  paisDao = new PaisPostgreSQLDao();
    private static ProvinciaDao provinciaDao = new ProvinciaPostgreSQLDao();
    private static LocalidadDao localidadDao = new LocalidadPostgreSQLDao();

    public static void guardarUsuarioDeIngreso(UsuarioDTO usuarioDTO){
        usuarioLogueado = usuarioDao.getUsuario(usuarioDTO.id_usuario);
    }
    public static List<CompetenciaDTO> getCompetenciasDTO(){
        List<CompetenciaDTO> competenciasDTO = new ArrayList<>();
        for(Competencia competencia:usuarioLogueado.getCompetencias()){
            CompetenciaDTO competenciaDTO = new CompetenciaDTO();
            competenciaDTO.id_competencia=competencia.getId_competencia();
            competenciaDTO.nombre = competencia.getNombre();
            competenciaDTO.deporte = competencia.getDeporte().getNombre();
            competenciaDTO.estado = competencia.getEstado().toString();
            competenciasDTO.add(competenciaDTO);
        }
        return competenciasDTO;
    }
    public static List<LugarRealizacionDTO> getLugaresRealizacionDTO(){
        List<LugarRealizacionDTO> lugaresRealizacionDTO = new ArrayList<>();
        for(LugarRealizacion lugarRealizacion:usuarioLogueado.getLugaresRealizacion()){
            LugarRealizacionDTO lugarRealizacionDTO = new LugarRealizacionDTO();
            lugarRealizacionDTO.id_lugar_realizacion=lugarRealizacion.getId_lugar_realizacion();
            lugarRealizacionDTO.nombre = lugarRealizacion.getNombre();
            lugarRealizacionDTO.descripcion = lugarRealizacion.getDescripcion();
            lugarRealizacionDTO.deportesDTO = new ArrayList<>();
            for(Deporte deporte:lugarRealizacion.getDeportes()){
                lugarRealizacionDTO.deportesDTO.add(new DeporteDTO(deporte.getId_deporte(),deporte.getNombre()));
            }
            lugaresRealizacionDTO.add(lugarRealizacionDTO);
        }
        return lugaresRealizacionDTO;
    }

    public static Error autenticarUsuario(String correoElectronico, String password){
        Error error = null;
        //Validacion de email
        if(!usuarioDao.validarEmail(correoElectronico)){
            error = new ErrorAutenticacion("El usuario o la contraseña no son válidos");
            return error;
        }
        usuarioLogueado = usuarioDao.validarContraseña(correoElectronico, password);
        if(usuarioLogueado == null){
            error = new ErrorAutenticacion("El usuario o la contraseña no son válidos");
        }
        return error;
    }

    public static ArrayList<Error> registrarUsuario(UsuarioDTO usuarioDTO){
        ArrayList<Error> errores = new ArrayList<>();
        ////Validaciones
        //validacion de correo electronico
        if(usuarioDao.validarEmail(usuarioDTO.correoElectronico)){
            errores.add(new ErrorEmail("El email ya se encuentra registrado en la aplicacion"));
        }
        //retorno de errores
        if(!errores.isEmpty()){
            return errores;
        }
        //Obtencion o creacion de la localidad y relacionados
        Pais pais = paisDao.getOrCreatePais(Normalizador.normalizar(usuarioDTO.pais));
        Provincia provincia = provinciaDao.getOrCreateProvincia(Normalizador.normalizar(usuarioDTO.provincia),pais);
        Localidad localidad = localidadDao.getOrCreateLocalidad(Normalizador.normalizar(usuarioDTO.localidad),provincia);
        //Hasheo de la contraseña
        String hash;
        try {
            hash = Password.getSaltedHash(usuarioDTO.contraseña);
        } catch (Exception e) {
            e.printStackTrace();
            errores.add(new ErrorHash("Fallo el proceso de hashing de la contraseña"));
            return errores;
        }
        //Si  pasa las validaciones creamos el usuario
        Usuario usuario = new Usuario(usuarioDTO.nombre,usuarioDTO.apellido,usuarioDTO.correoElectronico,hash,usuarioDTO.documento,TipoDeDocumento.valueOf(usuarioDTO.tipoDeDocumento),localidad);
        usuarioDao.createUsuario(usuario);
        return errores;
    }
    public static List<UsuarioDTO> getUsuarios(){
        List<UsuarioDTO> usuariosDTO = new ArrayList<>();
        for (Usuario usuario:usuarioDao.getUsuarios()){
            UsuarioDTO usuarioDTO = new UsuarioDTO();
            usuarioDTO.id_usuario = usuario.getId_usuario();
            usuarioDTO.nombre = usuario.getNombre();
            usuarioDTO.apellido = usuario.getApellido();
            usuariosDTO.add(usuarioDTO);
        }
        return usuariosDTO;
    }

    public static Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public static void setUsuarioLogueado(Usuario usuarioLogueado) {
        GestorUsuarios.usuarioLogueado = usuarioLogueado;
    }
}
