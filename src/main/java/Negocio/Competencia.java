package Negocio;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
@Table(name = "competencia")
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
    protected ArrayList<Disponibilidad> disponibilidades;

    protected ArrayList<Participante> participantes;
    protected Fixture fixture;

    protected Competencia(String nombre, String reglamento, Puntuacion puntuacion, Estado estado, Usuario usuario, Deporte deporte, ArrayList<Disponibilidad> disponibilidades, ArrayList<Participante> participantes) {
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
        this(nombre,reglamento,puntuacion,estado,usuario,deporte,new ArrayList<Disponibilidad>(), new ArrayList<Participante>());
    }
}
