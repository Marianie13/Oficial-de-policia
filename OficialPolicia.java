/**
 * Representa un oficial de policía autorizado para emitir multas.
 */
public class OficialPolicia {
    // Atributos del oficial
    private String nombre;     // Nombre del oficial de policía
    private String placa;      // Número de placa o identificación del oficial

    /**
     * Constructor de la clase OficialPolicia
     * @param nombre Nombre completo del oficial
     * @param placa Número de placa o identificación del oficial
     */
    public OficialPolicia(String nombre, String placa) {
        this.nombre = nombre;
        this.placa = placa;
    }

    /**
     * @return Nombre del oficial
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return Número de placa del oficial
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Emite una multa si el tiempo de parqueo excede el tiempo pagado.
     * @return TiqueteMulta si hay infracción, null si no hay infracción
     */
    public TiqueteMulta emitirMulta(CarroParqueado carro, Parquimetro parquimetro) {
        int minutosParqueado = carro.getMinutosParqueado();
        int minutosPagados = parquimetro.getMinutosPagados();
        
        if (minutosParqueado > minutosPagados) {
            int minutosExcedidos = minutosParqueado - minutosPagados;
            return new TiqueteMulta(this, carro, minutosExcedidos);
        }
        return null;
    }

    /**
     * Método principal para demostrar el funcionamiento del sistema
     */
    public static void main(String[] args) {
        // Crear un oficial de policía
        OficialPolicia oficial = new OficialPolicia("Juan Pérez", "OP-123");
        
        // Crear un carro para el ejemplo
        CarroParqueado carro = new CarroParqueado("Toyota", "Corolla", "Rojo", "ABC-123");
        
        // Crear un parquímetro y agregar tiempo
        Parquimetro parquimetro = new Parquimetro();
        parquimetro.agregarMinutos(60); // Agregar 1 hora de tiempo
        
        System.out.println("=== Sistema de Control de Parqueo ===");
        System.out.println("Oficial a cargo: " + oficial.getNombre());
        System.out.println("Placa oficial: " + oficial.getPlaca());
        
        // Simular paso del tiempo (2 segundos para el ejemplo)
        try {
            System.out.println("\nRevisando vehículo...");
            Thread.sleep(2000);
            
            // Revisar el carro y emitir multa si es necesario
            TiqueteMulta multa = oficial.emitirMulta(carro, parquimetro);
            
            if (multa != null) {
                System.out.println("\n¡Se ha detectado una infracción!");
                System.out.println(multa.generarReporte());
            } else {
                System.out.println("\nEl vehículo está dentro del tiempo permitido");
                System.out.println("Tiempo pagado: " + parquimetro.getMinutosPagados() + " minutos");
                System.out.println("Tiempo usado: " + carro.getMinutosParqueado() + " minutos");
            }
            
        } catch (InterruptedException e) {
            System.out.println("Error en la simulación del tiempo: " + e.getMessage());
        }
    }
} 