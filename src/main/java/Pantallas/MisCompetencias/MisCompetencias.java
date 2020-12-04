package Pantallas.MisCompetencias;
import Interface.JPantalla;
import java.awt.*;

public class MisCompetencias extends JPantalla {
    private List Lista = new List();

    public MisCompetencias(){
        super("Mis competencias","Volver");
        body.setLayout(new GridBagLayout());
        body.add(new Header(Lista),new Header.Constraints());
        body.add(new Filters(Lista),new Filters.Constraints());
        body.add(Lista, new List.Constraints());
    };
};