package Negocio;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
@Entity
@Table(name = "auditoria")
public class Auditoria {
    @Id
    @Column(name = "id_auditoria")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_auditoria;
    @Column(name = "fecha_ingreso")
    private LocalDate fecha_ingreso;
    @Column(name = "hora_ingreso")
    private LocalTime hora_ingreso;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Auditoria() {}

    public Auditoria(LocalDate fecha_ingreso, LocalTime hora_ingreso, Usuario usuario) {
        this.fecha_ingreso = fecha_ingreso;
        this.hora_ingreso = hora_ingreso;
        this.usuario = usuario;
    }

    public int getId_auditoria() {
        return id_auditoria;
    }

    public void setId_auditoria(int id_auditoria) {
        this.id_auditoria = id_auditoria;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public LocalTime getHora_ingreso() {
        return hora_ingreso;
    }

    public void setHora_ingreso(LocalTime hora_ingreso) {
        this.hora_ingreso = hora_ingreso;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
