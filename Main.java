import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear un oficial de policía
        System.out.println("=== Sistema de Control de Parqueo ===");
        System.out.println("Ingrese los datos del oficial:");
        System.out.print("Nombre del oficial: ");
        String nombreOficial = scanner.nextLine();
        System.out.print("Placa del oficial: ");
        String placaOficial = scanner.nextLine();
        
        OficialPolicia oficial = new OficialPolicia(nombreOficial, placaOficial);
        
        // Crear un carro parqueado
        System.out.println("\nIngrese los datos del vehículo:");
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Color: ");
        String color = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        
        CarroParqueado carro = new CarroParqueado(marca, modelo, color, placa);
        
        // Crear un parquímetro y agregar tiempo
        Parquimetro parquimetro = new Parquimetro();
        System.out.print("\nIngrese los minutos pagados: ");
        int minutosPagados = scanner.nextInt();
        
        if (parquimetro.agregarMinutos(minutosPagados)) {
            System.out.println("Tiempo agregado exitosamente");
        } else {
            System.out.println("Error: No se pudo agregar el tiempo");
            return;
        }
        
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
        
        scanner.close();
    }
}