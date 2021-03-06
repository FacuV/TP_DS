package Negocio;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "resultado")
public class Resultado {
    @Id
    @Column(name = "id_resultado")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id_resultado;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "hora")
    private LocalTime hora;
    @Enumerated(EnumType.STRING)
    @Column(name = "resolucion")
    private Resolucion resolucion;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "resultado")
    private List<Set> sets;
    @ManyToOne
    @JoinColumn(name = "id_encuentro")
    private Encuentro encuentro;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Resultado() {
    }

    public Resultado(LocalDate fecha, LocalTime hora, Resolucion resolucion, ArrayList<Set> sets, Encuentro encuentro, Usuario usuario){
        this.fecha = fecha;
        this.hora = hora;
        this.resolucion = resolucion;
        this.sets = sets;
        this.encuentro = encuentro;
        this.usuario = usuario;
    }
    public Resultado(Resolucion resolucion, ArrayList<Set> sets, Encuentro encuentro,Usuario usuario){
        this(LocalDate.now(),LocalTime.now(),resolucion,sets,encuentro,usuario);
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Resolucion getResolucion() {
        return resolucion;
    }

    public void setResolucion(Resolucion resolucion) {
        this.resolucion = resolucion;
    }

    public int getId_resultado() {
        return id_resultado;
    }

    public void setId_resultado(int id_resultado) {
        this.id_resultado = id_resultado;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    public Encuentro getEncuentro() {
        return encuentro;
    }

    public void setEncuentro(Encuentro encuentro) {
        this.encuentro = encuentro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
