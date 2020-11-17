package Negocio;

public class UsuarioDTO {
    public Integer id_usuario;
    public String correoElectronico;
    public String contraseña;
    public String apellido;
    public String nombre;
    public String tipoDeDocumento;
    public String documento;
    public String localidad;
    public String provincia;
    public String pais;

    public UsuarioDTO() {}
    public UsuarioDTO(Integer id_usuario,String correoElectronico, String contraseña, String apellido, String nombre, String tipoDeDocumento, String documento, String localidad, String provincia, String pais) {
        this.id_usuario = id_usuario;
        this.correoElectronico = correoElectronico;
        this.contraseña = contraseña;
        this.apellido = apellido;
        this.nombre = nombre;
        this.tipoDeDocumento = tipoDeDocumento;
        this.documento = documento;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }

    @Override
    public String toString() {
        return (nombre+" "+apellido);
    }
}
