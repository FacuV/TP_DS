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
    @JoinTable(name = "lugar_realizando_deporte", joinColumns = @JoinColumn(name = "id_deporte"),
            inverseJoinColumns = @JoinColumn(name = "id_lugar_realizacion"))
    private ArrayList<Encuentro> encuentros;
    public Fixture(ArrayList<Encuentro> encuentros){
        this.encuentros = encuentros;
    }
}
