import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * Representa un vehículo estacionado en el sistema.
 */
public class CarroParqueado {
    // Atributos que describen las características del carro
    private String marca;      // Marca del vehículo
    private String modelo;     // Modelo del vehículo
    private String color;      // Color del vehículo
    private String placa;      // Placa o matrícula del vehículo
    
    // Atributos para el control del tiempo
    private LocalDateTime horaEntrada;    // Momento exacto en que el carro ingresó

    /**
     * Constructor para crear un nuevo carro parqueado.
     */
    public CarroParqueado(String marca, String modelo, String color, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.placa = placa;
        this.horaEntrada = LocalDateTime.now();
    }

    /**
     * Actualiza el tiempo que el carro lleva parqueado
     * Calcula la diferencia entre la hora actual y la hora de entrada
     * Asegura que el tiempo nunca sea negativo
     */
    public void actualizarTiempoParqueado() {
        LocalDateTime ahora = LocalDateTime.now();
        Duration duracion = Duration.between(horaEntrada, ahora);
        this.minutosParqueado = Math.max(0, (int) duracion.toMinutes());
    }

    // Métodos getter para acceder a los atributos privados
    
    /**
     * @return La marca del vehículo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @return El modelo del vehículo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @return El color del vehículo
     */
    public String getColor() {
        return color;
    }

    /**
     * @return La placa del vehículo
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Obtiene los minutos que el carro lleva parqueado
     * Actualiza el tiempo antes de retornarlo
     * @return Cantidad de minutos que el carro lleva parqueado
     */
    public int getMinutosParqueado() {
        return (int) ChronoUnit.MINUTES.between(horaEntrada, LocalDateTime.now());
    }

    /**
     * Sobreescribe el método toString para mostrar la información del carro
     * Actualiza el tiempo parqueado antes de generar el string
     * @return String con toda la información del carro parqueado
     */
    @Override
    public String toString() {
        return "Vehículo: " + marca + " " + modelo + ", Color: " + color + ", Placa: " + placa;
    }
} 