import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Representa una multa por exceder el tiempo de parqueo.
 */
public class TiqueteMulta {
    private LocalDateTime fecha;
    private OficialPolicia oficial;
    private CarroParqueado carro;
    private int minutosExcedidos;
    private double montoMulta;
    private static final double TARIFA_POR_MINUTO = 100.0; // Tarifa en pesos por minuto excedido

    public TiqueteMulta(OficialPolicia oficial, CarroParqueado carro, int minutosExcedidos) {
        this.fecha = LocalDateTime.now();
        this.oficial = oficial;
        this.carro = carro;
        this.minutosExcedidos = minutosExcedidos;
        this.montoMulta = calcularMontoMulta();
    }

    private double calcularMontoMulta() {
        return minutosExcedidos * TARIFA_POR_MINUTO;
    }

    // Getters
    public LocalDateTime getFecha() { return fecha; }
    public OficialPolicia getOficial() { return oficial; }
    public CarroParqueado getCarro() { return carro; }
    public int getMinutosExcedidos() { return minutosExcedidos; }
    public double getMontoMulta() { return montoMulta; }

    /**
     * Genera un reporte detallado de la multa.
     */
    public String generarReporte() {
        return String.format("""
            === TIQUETE DE MULTA ===
            Fecha: %s
            Oficial: %s (Placa: %s)
            Vehículo: %s
            Minutos excedidos: %d
            Monto a pagar: $%.2f
            ====================
            """,
            fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
            oficial.getNombre(),
            oficial.getPlaca(),
            carro.toString(),
            minutosExcedidos,
            montoMulta
        );
    }

    @Override
    public String toString() {
        return generarReporte();
    }
} 