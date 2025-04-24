public class TiqueteMulta {
    private static final int MULTA_PRIMERA_HORA = 25000;
    private static final int MULTA_HORA_ADICIONAL = 10000;
    private static final int MINUTOS_POR_HORA = 60;

    private CarroParqueado carro;
    private String nombreOficial;
    private String placaOficial;
    private int minutosExcedidos;
    private double valorMulta;

    public TiqueteMulta(CarroParqueado carro, String nombreOficial, String placaOficial, int minutosExcedidos) {
        this.carro = carro;
        this.nombreOficial = nombreOficial;
        this.placaOficial = placaOficial;
        this.minutosExcedidos = minutosExcedidos;
        this.valorMulta = calcularMulta();
    }

    private double calcularMulta() {
        if (minutosExcedidos <= 0) {
            return 0;
        }

        // Calcula las horas completas (redondeado hacia arriba)
        int horasCompletas = (int) Math.ceil(minutosExcedidos / (double) MINUTOS_POR_HORA);
        
        // La primera hora tiene un costo diferente
        double multa = MULTA_PRIMERA_HORA;
        
        // Si hay más de una hora, suma el costo adicional por cada hora extra
        if (horasCompletas > 1) {
            multa += (horasCompletas - 1) * MULTA_HORA_ADICIONAL;
        }
        
        return multa;
    }

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

    // Getters
    public CarroParqueado getCarro() {
        return carro;
    }

    public String getNombreOficial() {
        return nombreOficial;
    }

    public String getPlacaOficial() {
        return placaOficial;
    }

    public int getMinutosExcedidos() {
        return minutosExcedidos;
    }

    public double getValorMulta() {
        return valorMulta;
    }

    @Override
    public String toString() {
        return generarReporte();
    }
} 