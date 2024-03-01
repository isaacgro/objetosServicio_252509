package itson.objectosServicio;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha extends GregorianCalendar {

    public Fecha() {
        super();
        set(Calendar.HOUR_OF_DAY, 0);
        set(Calendar.MINUTE, 0);
        set(Calendar.SECOND, 0);
    }

    public Fecha(int dia, int mes, int anio) {
        super(anio, mes - 1, dia, 0, 0, 0);
    }

    public Fecha(Fecha otraFecha) {
        super(otraFecha.get(Calendar.YEAR), otraFecha.get(Calendar.MONTH), otraFecha.get(Calendar.DAY_OF_MONTH));
    }

    public int getDia() {
        return get(Calendar.DAY_OF_MONTH);
    }

    public int getMes() {
        return get(Calendar.MONTH) + 1;
    }

    public int getAnio() {
        return get(Calendar.YEAR);
    }

    public void sumarUnAnio(){
        this.add(Calendar.YEAR, 1);
    }
    public void setDia(int dia) {
        set(Calendar.DAY_OF_MONTH, dia);
    }

    public void setMes(int mes) {
        set(Calendar.MONTH, mes - 1);
    }

    public void setAnio(int anio) {
        set(Calendar.YEAR, anio);
    }

    public boolean esFechaValida() {
        try {
            getTime(); // Este método lanzará una excepción si la fecha es inválida
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public Fecha vencimiento(int dias, int meses, int anios) {
        Fecha nuevaFecha = new Fecha(this);
        nuevaFecha.add(Calendar.DAY_OF_MONTH, dias);
        nuevaFecha.add(Calendar.MONTH, meses);
        nuevaFecha.add(Calendar.YEAR, anios);
        return nuevaFecha;
    }

    public Fecha vencimiento(int dias, int meses){
        return this.vencimiento(dias, meses, 0);
    }

    public Fecha vencimiento(int dias){
        return this.vencimiento(dias, 0);
    }

    public int lapso(Fecha desde){
        long desdeInMilis = desde.getTimeInMillis();
        long thisInMilis = this.getTimeInMillis();
        long diferenciaInmilis = thisInMilis - desdeInMilis;
        long segundos = diferenciaInmilis / 1000;
        long minutos = segundos / 60;
        long horas = minutos / 60;
        long diasTranscurridos = horas / 24;
        return (int) diasTranscurridos;
    }

    // Definición de la clase Periodo
    public class Periodo {
        public Fecha desde;
        public Fecha hasta;

        public Periodo(Fecha desde, Fecha hasta) {
            this.desde = desde;
            this.hasta = hasta;
        }

        // Métodos getters y setters para desde y hasta
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
    }

    @Override
    public String toString() {
        return getDia() + "/" + getMes() + "/" + getAnio();
    }
}
