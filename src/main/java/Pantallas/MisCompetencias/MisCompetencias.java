package Pantallas.MisCompetencias;
import Interface.JPantalla;
import Negocio.Competencia;
import Pantallas.MisCompetencias.VerCompetencia.VerCompetencia;
import Servicio.GestorCompetencia;
import java.awt.*;

public class MisCompetencias extends JPantalla {
    private MisCompetencias self = this;
    private List Lista = new List(self);

    public MisCompetencias(){
        super("Mis competencias","Volver");
        body.setLayout(new GridBagLayout());
        body.add(new Header(Lista),new Header.Constraints());
        body.add(new Filters(Lista),new Filters.Constraints());
        body.add(Lista, new List.Constraints());
    };

    public void setCompetencia(Competencia competencia) {
        GestorCompetencia.setCompetencia(competencia);
        body.add(new VerCompetencia(this),new List.Constraints());
        body.remove(2);
        body.revalidate();
    };

    public void unsetCompetencia(Competencia competencia) {
        GestorCompetencia.setCompetencia(competencia);
        body.remove(2);
        body.add(Lista, new List.Constraints());
    };
};