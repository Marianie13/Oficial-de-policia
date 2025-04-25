/**
 * Clase que representa un oficial de policía que inspecciona los carros parqueados.
 * Se encarga de verificar el tiempo de parqueo y emitir multas cuando es necesario.
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
     * Revisa si un carro ha excedido su tiempo de parqueo permitido
     * @param carro El carro parqueado a revisar
     * @param parquimetro El parquímetro asociado al espacio de parqueo
     * @return true si el carro ha excedido el tiempo pagado, false en caso contrario
     */
    public boolean revisarCarroParqueado(CarroParqueado carro, Parquimetro parquimetro) {
        // Obtener tiempo real de parqueo
        int minutosParqueados = carro.getMinutosParqueado();
        // Obtener tiempo pagado
        int minutosPagados = parquimetro.getMinutosPagados();
        
        // Determinar si ha excedido el tiempo
        return minutosParqueados > minutosPagados;
    }

    /**
     * Emite una multa si el carro ha excedido su tiempo de parqueo
     * @param carro El carro parqueado a multar
     * @param parquimetro El parquímetro asociado al espacio de parqueo
     * @return TiqueteMulta si el carro excedió el tiempo, null en caso contrario
     */
    public TiqueteMulta emitirMulta(CarroParqueado carro, Parquimetro parquimetro) {
        if (revisarCarroParqueado(carro, parquimetro)) {
            int minutosExcedidos = carro.getMinutosParqueado() - parquimetro.getMinutosPagados();
            return new TiqueteMulta(carro, nombre, placa, minutosExcedidos);
        }
        return null;
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