package Negocio;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "encuentro")
public class Encuentro {
    @Id
    @Column(name = "id_encuentro")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_encuentro;
    @Column(name = "fecha")
    private LocalDate fecha;
    @Column(name = "fase")
    private Integer fase;
    @ManyToOne
    @JoinColumn(name = "id_participante_a")
    private Participante participanteA;
    @ManyToOne
    @JoinColumn(name = "id_participante_b")
    private Participante participanteB;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_resultado_final")
    private Resultado resultado_actual;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "encuentro")
    private List<Resultado> historial_resultados_modificados;
    @Enumerated(EnumType.STRING)
    @Column(name = "ronda")
    private Ronda ronda;
    @OneToOne
    @JoinColumn(name = "id_encuentro_proximo_ganador")
    private Encuentro encuentro_proximo_ganador;
    @OneToOne
    @JoinColumn(name = "id_encuentro_proximo_perdedor")
    private Encuentro encuentro_proximo_perdedor;
    @OneToOne
    @JoinColumn(name = "id_encuentro_ganador_anterior_a")
    private Encuentro encuentro_ganador_anterior_a;
    @OneToOne
    @JoinColumn(name = "id_encuentro_ganador_anterior_b")
    private Encuentro encuentro_ganador_anterior_b;
    @OneToOne
    @JoinColumn(name = "id_encuentro_perdedor_anterior_a")
    private Encuentro encuentro_perdedor_anterior_a;
    @OneToOne
    @JoinColumn(name = "id_encuentro_perdedor_anterior_b")
    private Encuentro encuentro_perdedor_anterior_b;

    public Encuentro() {}

    public Encuentro(LocalDate fecha, Integer fase, Participante participanteA, Participante participanteB, Resultado resultado_actual, ArrayList<Resultado> historial_resultados_modificados, Ronda ronda, Encuentro encuentro_proximo_ganador, Encuentro encuentro_proximo_perdedor, Encuentro encuentro_ganador_anterior_a, Encuentro encuentro_ganador_anterior_b, Encuentro encuentro_perdedor_anterior_a, Encuentro encuentro_perdedor_anterior_b) {
        this.fecha = fecha;
        this.fase = fase;
        this.participanteA = participanteA;
        this.participanteB = participanteB;
        this.resultado_actual = resultado_actual;
        this.historial_resultados_modificados = historial_resultados_modificados;
        this.ronda = ronda;
        this.encuentro_proximo_ganador = encuentro_proximo_ganador;
        this.encuentro_proximo_perdedor = encuentro_proximo_perdedor;
        this.encuentro_ganador_anterior_a = encuentro_ganador_anterior_a;
        this.encuentro_ganador_anterior_b = encuentro_ganador_anterior_b;
        this.encuentro_perdedor_anterior_a = encuentro_perdedor_anterior_a;
        this.encuentro_perdedor_anterior_b = encuentro_perdedor_anterior_b;
    }
    //Constructor para competencia liga
    public Encuentro(LocalDate fecha,int fase, Participante participanteA, Participante participanteB) {
        this(fecha,fase, participanteA, participanteB,null,new ArrayList<Resultado>(),null,null,null,null,null,null,null);
    }
    //Constructor para competencia eliminatoria simple
    public Encuentro(LocalDate fecha, Integer fase, Participante participanteA, Participante participanteB,Encuentro encuentro_proximo_ganador,Encuentro encuentro_ganador_anterior_a, Encuentro encuentro_ganador_anterior_b){
        this(fecha,fase,participanteA,participanteB,null,new ArrayList<Resultado>(), null,encuentro_proximo_ganador,null,encuentro_ganador_anterior_a,encuentro_ganador_anterior_b,null,null);
    }
    //Constructor para competencia eliminatoria doble
    public Encuentro(LocalDate fecha, Integer fase, Participante participanteA, Participante participanteB, Ronda ronda, Encuentro encuentro_proximo_ganador, Encuentro encuentro_proximo_perdedor, Encuentro encuentro_ganador_anterior_a, Encuentro encuentro_ganador_anterior_b, Encuentro encuentro_perdedor_anterior_a, Encuentro encuentro_perdedor_anterior_b) {
        this(fecha,fase,participanteA,participanteB,null,new ArrayList<Resultado>(),ronda,encuentro_proximo_ganador, encuentro_proximo_perdedor,encuentro_ganador_anterior_a,encuentro_ganador_anterior_b,encuentro_perdedor_anterior_a,encuentro_perdedor_anterior_b);
    }

    public int getId_encuentro() {
        return id_encuentro;
    }

    public void setId_encuentro(int id_encuentro) {
        this.id_encuentro = id_encuentro;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getFase() {
        return fase;
    }

    public void setFase(Integer fase) {
        this.fase = fase;
    }

    public Participante getParticipanteA() {
        return participanteA;
    }

    public void setParticipanteA(Participante participanteA) {
        this.participanteA = participanteA;
    }

    public Participante getParticipanteB() {
        return participanteB;
    }

    public void setParticipanteB(Participante participanteB) {
        this.participanteB = participanteB;
    }

    public Resultado getResultado_actual() {
        return resultado_actual;
    }

    public void setResultado_actual(Resultado resultado_actual) {
        this.resultado_actual = resultado_actual;
    }

    public List<Resultado> getHistorial_resultados_modificados() {
        return historial_resultados_modificados;
    }

    public void setHistorial_resultados_modificados(List<Resultado> historial_resultados_modificados) {
        this.historial_resultados_modificados = historial_resultados_modificados;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public Encuentro getEncuentro_proximo_ganador() {
        return encuentro_proximo_ganador;
    }

    public void setEncuentro_proximo_ganador(Encuentro encuentro_proximo_ganador) {
        this.encuentro_proximo_ganador = encuentro_proximo_ganador;
    }

    public Encuentro getEncuentro_proximo_perdedor() {
        return encuentro_proximo_perdedor;
    }

    public void setEncuentro_proximo_perdedor(Encuentro encuentro_proximo_perdedor) {
        this.encuentro_proximo_perdedor = encuentro_proximo_perdedor;
    }

    public Encuentro getEncuentro_ganador_anterior_a() {
        return encuentro_ganador_anterior_a;
    }

    public void setEncuentro_ganador_anterior_a(Encuentro encuentro_ganador_anterior_a) {
        this.encuentro_ganador_anterior_a = encuentro_ganador_anterior_a;
    }

    public Encuentro getEncuentro_ganador_anterior_b() {
        return encuentro_ganador_anterior_b;
    }

    public void setEncuentro_ganador_anterior_b(Encuentro encuentro_ganador_anterior_b) {
        this.encuentro_ganador_anterior_b = encuentro_ganador_anterior_b;
    }

    public Encuentro getEncuentro_perdedor_anterior_a() {
        return encuentro_perdedor_anterior_a;
    }

    public void setEncuentro_perdedor_anterior_a(Encuentro encuentro_perdedor_anterior_a) {
        this.encuentro_perdedor_anterior_a = encuentro_perdedor_anterior_a;
    }

    public Encuentro getEncuentro_perdedor_anterior_b() {
        return encuentro_perdedor_anterior_b;
    }

    public void setEncuentro_perdedor_anterior_b(Encuentro encuentro_perdedor_anterior_b) {
        this.encuentro_perdedor_anterior_b = encuentro_perdedor_anterior_b;
    }

    @Override
    public String toString() {
        return "["+fase+","+participanteA+","+participanteB+"]";
    }
}
