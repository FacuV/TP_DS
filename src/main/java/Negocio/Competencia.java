package Negocio;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "competencia")
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Competencia {
    @Id
    @Column(name = "id_competencia")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id_competencia;
    @Column(name = "nombre")
    protected String nombre;
    @Column(name = "reglamento")
    protected String reglamento;
    @Column(name = "baja_logica")
    protected boolean baja_logica;
    @OneToOne
    @JoinColumn(name = "id_puntuacion")
    protected Puntuacion puntuacion;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    protected Estado estado;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    protected Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_deporte")
    protected Deporte deporte;
    @OneToMany(mappedBy = "competencia")
    protected List<Disponibilidad> disponibilidades;
    @ManyToMany
    @JoinTable(name = "participantes_competencia", joinColumns = @JoinColumn(name = "id_participante"),
            inverseJoinColumns = @JoinColumn(name = "id_competencia"))
    protected List<Participante> participantes;
    @OneToOne
    @JoinColumn(name = "id_fixture")
    protected Fixture fixture;

    protected Competencia() {
    }
    protected Competencia(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte, List<Disponibilidad> disponibilidades, List<Participante> participantes) {
        this.nombre = nombre;
        this.reglamento = reglamento;
        this.puntuacion = puntuacion;
        this.estado = estado;
        this.usuario = usuario;
        this.deporte = deporte;
        this.disponibilidades = disponibilidades;
        this.participantes = participantes;
    }
    protected Competencia(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte){
        this(nombre,reglamento,puntuacion,estado,usuario,deporte,new ArrayList<>(), new ArrayList<>());
    }

    public int getId_competencia() {
        return id_competencia;
    }

    public void setId_competencia(int id_competencia) {
        this.id_competencia = id_competencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReglamento() {
        return reglamento;
    }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento;
    }

    public boolean isBaja_logica() {
        return baja_logica;
    }

    public void setBaja_logica(boolean baja_logica) {
        this.baja_logica = baja_logica;
    }

    public Puntuacion getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Puntuacion puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public List<Disponibilidad> getDisponibilidades() {
        return disponibilidades;
    }

    public void setDisponibilidades(List<Disponibilidad> disponibilidades) {
        this.disponibilidades = disponibilidades;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    @Override
    public String toString() {
        return "Competencia{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
