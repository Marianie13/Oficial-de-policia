/**
 * Clase que representa un tiquete de multa por exceso de tiempo en el parqueadero.
 * Se encarga de calcular el valor de la multa y generar el reporte correspondiente.
 */
public class TiqueteMulta {
    // Constantes para el cálculo de la multa
    private static final int MULTA_PRIMERA_HORA = 25000;    // Valor a cobrar por la primera hora o fracción
    private static final int MULTA_HORA_ADICIONAL = 10000;  // Valor a cobrar por cada hora adicional o fracción
    private static final int MINUTOS_POR_HORA = 60;         // Cantidad de minutos en una hora

    // Atributos del tiquete
    private CarroParqueado carro;         // Vehículo que recibe la multa
    private String nombreOficial;         // Nombre del oficial que emite la multa
    private String placaOficial;          // Número de placa del oficial
    private int minutosExcedidos;         // Minutos que excedió el tiempo pagado
    private double valorMulta;            // Valor total de la multa calculada

    /**
     * Constructor de la clase TiqueteMulta
     * @param carro Vehículo que recibe la multa
     * @param nombreOficial Nombre del oficial que emite la multa
     * @param placaOficial Número de placa del oficial
     * @param minutosExcedidos Cantidad de minutos que excedió el tiempo pagado
     */
    public TiqueteMulta(CarroParqueado carro, String nombreOficial, String placaOficial, int minutosExcedidos) {
        this.carro = carro;
        this.nombreOficial = nombreOficial;
        this.placaOficial = placaOficial;
        this.minutosExcedidos = minutosExcedidos;
        this.valorMulta = calcularMulta();  // Calcula el valor de la multa al crear el tiquete
    }

    /**
     * Calcula el valor de la multa según las reglas establecidas:
     * - Primera hora o fracción: $25,000
     * - Cada hora adicional o fracción: $10,000
     * @return valor total de la multa calculada
     */
    private double calcularMulta() {
        if (minutosExcedidos <= 0) {
            return 0;  // Si no hay minutos excedidos, no hay multa
        }

        // Calcula las horas completas redondeando hacia arriba
        int horasCompletas = (int) Math.ceil(minutosExcedidos / (double) MINUTOS_POR_HORA);
        
        // La primera hora tiene un costo fijo
        double multa = MULTA_PRIMERA_HORA;
        
        // Por cada hora adicional, suma el valor correspondiente
        if (horasCompletas > 1) {
            multa += (horasCompletas - 1) * MULTA_HORA_ADICIONAL;
        }
        
        return multa;
    }

    /**
     * Genera un reporte detallado de la multa en formato de texto
     * Incluye información del vehículo, tiempo excedido, valor de la multa y datos del oficial
     * @return String con el reporte completo de la multa
     */
    public String generarReporte() {
        return "TICKET DE MULTA DE PARQUEO\n" +
               "========================\n" +
               "INFORMACIÓN DEL VEHÍCULO:\n" +
               "Marca: " + carro.getMarca() + "\n" +
               "Modelo: " + carro.getModelo() + "\n" +
               "Color: " + carro.getColor() + "\n" +
               "Placa: " + carro.getPlaca() + "\n\n" +
               "TIEMPO EXCEDIDO: " + minutosExcedidos + " minutos\n" +
               "VALOR DE LA MULTA: $" + String.format("%,.2f", valorMulta) + "\n\n" +
               "OFICIAL EMISOR:\n" +
               "Nombre: " + nombreOficial + "\n" +
               "Placa: " + placaOficial + "\n" +
               "========================\n" +
               "Fecha: " + java.time.LocalDateTime.now();
    }

    // Métodos getter para acceder a la información del tiquete
    
    /**
     * @return El vehículo multado
     */
    public CarroParqueado getCarro() {
        return carro;
    }

    /**
     * @return Nombre del oficial que emitió la multa
     */
    public String getNombreOficial() {
        return nombreOficial;
    }

    /**
     * @return Número de placa del oficial
     */
    public String getPlacaOficial() {
        return placaOficial;
    }

    /**
     * @return Minutos que excedió el tiempo pagado
     */
    public int getMinutosExcedidos() {
        return minutosExcedidos;
    }

    /**
     * @return Valor total de la multa
     */
    public double getValorMulta() {
        return valorMulta;
    }

    /**
     * Sobreescribe el método toString para mostrar el reporte de la multa
     * @return El reporte completo de la multa
     */
    @Override
    public String toString() {
        return generarReporte();
    }
} 