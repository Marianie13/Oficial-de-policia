/**
 * Controla el tiempo pagado para el estacionamiento.
 */
public class Parquimetro {
    private int minutosPagados;
    private static final int MINUTOS_MAXIMOS = 120; // Máximo 2 horas de parqueo

    public Parquimetro() {
        this.minutosPagados = 0;
    }

    /**
     * Agrega minutos al tiempo pagado.
     * @return true si se agregaron los minutos correctamente
     */
    public boolean agregarMinutos(int minutos) {
        if (minutos < 0) {
            return false;
        }
        
        int nuevoTotal = minutosPagados + minutos;
        if (nuevoTotal <= MINUTOS_MAXIMOS) {
            minutosPagados = nuevoTotal;
            return true;
        }
        return false;
    }

    public boolean consumirMinuto() {
        if (minutosPagados > 0) {
            minutosPagados--;
            return true;
        }
        return false;
    }

    public int getMinutosPagados() {
        return Math.max(0, minutosPagados);
    }

    public boolean tieneTiempoDisponible() {
        return minutosPagados > 0;
    }

    @Override
    public String toString() {
        return "Tiempo pagado: " + minutosPagados + " minutos";
    }
} 