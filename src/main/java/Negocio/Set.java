package Negocio;

import javax.persistence.*;

@Entity
@Table(name = "set")
public class Set {
    @Id
    @Column(name = "id_set")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    protected int id_set;
    @Column(name = "puntos_participante_a")
    private int puntos_participanteA;
    @Column(name = "puntos_participante_b")
    private int puntos_participanteB;
    @ManyToOne
    @JoinColumn(name = "id_resultado")
    private Resultado resultado;

    public Set() {
    }

    public Set(int puntos_participanteA, int puntos_participanteB, Resultado resultado) {
        this.puntos_participanteA = puntos_participanteA;
        this.puntos_participanteB = puntos_participanteB;
        this.resultado = resultado;
    }

    public int getId_set() {
        return id_set;
    }

    public void setId_set(int id_set) {
        this.id_set = id_set;
    }

    public int getPuntos_participanteA() {
        return puntos_participanteA;
    }

    public void setPuntos_participanteA(int puntos_participanteA) {
        this.puntos_participanteA = puntos_participanteA;
    }

    public int getPuntos_participanteB() {
        return puntos_participanteB;
    }

    public void setPuntos_participanteB(int puntos_participanteB) {
        this.puntos_participanteB = puntos_participanteB;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }
}
