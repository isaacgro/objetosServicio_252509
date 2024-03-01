package itson.objectosServicio;

public class Periodo {

    private Fecha hasta;
    private Fecha desde;
    public Periodo(Fecha desde, Fecha hasta) {
        this.desde = desde;
        this.hasta = hasta;
    }

    public Fecha getDesde() {
        return desde;
    }

    public void setDesde(Fecha desde) {
        this.desde = desde;
    }

    public Fecha getHasta() {
        return hasta;
    }

    public void setHasta(Fecha hasta) {
        this.hasta = hasta;
    }


    public boolean contiene(Fecha fecha) {
        if (fecha.before(desde) || fecha.after(hasta))
            return false;
        return true;
    }
}