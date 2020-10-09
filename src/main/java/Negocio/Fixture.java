package Negocio;

import javax.persistence.*;
import java.util.ArrayList;
@Entity
@Table(name = "fixture")
public class Fixture{
    @Id
    @Column(name = "id_fixture")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_fixture;
    @OneToMany
    @JoinTable(name = "encuentro_en_fixture", joinColumns = @JoinColumn(name = "id_encuentro"),
            inverseJoinColumns = @JoinColumn(name = "id_fixture"))
    private ArrayList<Encuentro> encuentros;

    public Fixture() {
    }

    public Fixture(ArrayList<Encuentro> encuentros){
        this.encuentros = encuentros;
    }

    public int getId_fixture() {
        return id_fixture;
    }

    public void setId_fixture(int id_fixture) {
        this.id_fixture = id_fixture;
    }

    public ArrayList<Encuentro> getEncuentros() {
        return encuentros;
    }

    public void setEncuentros(ArrayList<Encuentro> encuentros) {
        this.encuentros = encuentros;
    }
}
