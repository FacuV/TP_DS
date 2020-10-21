package Negocio;

public class UsuarioDTO {
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
    public UsuarioDTO(String correoElectronico, String contraseña, String apellido, String nombre, String tipoDeDocumento, String documento, String localidad, String provincia, String pais) {
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
}
