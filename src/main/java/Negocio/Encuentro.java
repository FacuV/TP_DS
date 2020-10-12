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
    //seguir de aca
    @ManyToOne
    @JoinColumn(name = "id_participante_a")
    private Participante participanteA;
    @ManyToOne
    @JoinColumn(name = "id_participante_b")
    private Participante participanteB;
    @OneToOne
    @JoinColumn(name = "id_resultado_final")
    private Resultado resultado_actual;
    @OneToMany(mappedBy = "encuentro")
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
    @JoinColumn(name = "id_encuentro_anterior_ganador_participante_a")
    private Encuentro ganador_anterior_a;
    @OneToOne
    @JoinColumn(name = "id_encuentro_anterior_ganador_participante_b")
    private Encuentro ganador_anterior_b;
    @OneToOne
    @JoinColumn(name = "id_encuentro_anterior_perdedor_participante_a")
    private Encuentro perdedor_anterior_a;
    @OneToOne
    @JoinColumn(name = "id_encuentro_anterior_perdedor_participante_b")
    private Encuentro perdedor_anterior_b;

    public Encuentro() {}

    public Encuentro(LocalDate fecha, Integer fase, Participante participanteA, Participante participanteB, Resultado resultado_actual, ArrayList<Resultado> historial_resultados_modificados, Ronda ronda, Encuentro encuentro_proximo_ganador, Encuentro encuentro_proximo_perdedor, Encuentro ganador_anterior_a, Encuentro ganador_anterior_b, Encuentro perdedor_anterior_a, Encuentro perdedor_anterior_b) {
        this.fecha = fecha;
        this.fase = fase;
        this.participanteA = participanteA;
        this.participanteB = participanteB;
        this.resultado_actual = resultado_actual;
        this.historial_resultados_modificados = historial_resultados_modificados;
        this.ronda = ronda;
        this.encuentro_proximo_ganador = encuentro_proximo_ganador;
        this.encuentro_proximo_perdedor = encuentro_proximo_perdedor;
        this.ganador_anterior_a = ganador_anterior_a;
        this.ganador_anterior_b = ganador_anterior_b;
        this.perdedor_anterior_a = perdedor_anterior_a;
        this.perdedor_anterior_b = perdedor_anterior_b;
    }
    //Constructor para competencia liga
    public Encuentro(LocalDate fecha, Participante participanteA, Participante participanteB) {
        this(fecha,null, participanteA, participanteB,null,new ArrayList<Resultado>(),null,null,null,null,null,null,null);
    }
    //Constructor para competencia eliminatoria simple
    public Encuentro(LocalDate fecha, Integer fase, Participante participanteA, Participante participanteB,Encuentro encuentro_proximo_ganador,Encuentro ganador_anterior_a, Encuentro ganador_anterior_b){
        this(fecha,fase,participanteA,participanteB,null,new ArrayList<Resultado>(), null,encuentro_proximo_ganador,null,ganador_anterior_a, ganador_anterior_b, null, null);
    }
    //Constructor para competencia eliminatoria doble
    public Encuentro(LocalDate fecha, Integer fase, Participante participanteA, Participante participanteB, Ronda ronda, Encuentro encuentro_proximo_ganador, Encuentro encuentro_proximo_perdedor, Encuentro ganador_anterior_a, Encuentro ganador_anterior_b, Encuentro perdedor_anterior_a, Encuentro perdedor_anterior_b) {
        this(fecha,fase,participanteA,participanteB,null,new ArrayList<Resultado>(),ronda,encuentro_proximo_ganador, encuentro_proximo_perdedor, ganador_anterior_a,ganador_anterior_b,perdedor_anterior_a,perdedor_anterior_b);
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

    public Encuentro getGanador_anterior_a() {
        return ganador_anterior_a;
    }

    public void setGanador_anterior_a(Encuentro ganador_anterior_a) {
        this.ganador_anterior_a = ganador_anterior_a;
    }

    public Encuentro getGanador_anterior_b() {
        return ganador_anterior_b;
    }

    public void setGanador_anterior_b(Encuentro ganador_anterior_b) {
        this.ganador_anterior_b = ganador_anterior_b;
    }

    public Encuentro getPerdedor_anterior_a() {
        return perdedor_anterior_a;
    }

    public void setPerdedor_anterior_a(Encuentro perdedor_anterior_a) {
        this.perdedor_anterior_a = perdedor_anterior_a;
    }

    public Encuentro getPerdedor_anterior_b() {
        return perdedor_anterior_b;
    }

    public void setPerdedor_anterior_b(Encuentro perdedor_anterior_b) {
        this.perdedor_anterior_b = perdedor_anterior_b;
    }
}
