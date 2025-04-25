# Sistema de Control de Parqueo 🚗

Este sistema permite gestionar el control de parqueo de vehículos, incluyendo la emisión de multas por tiempo excedido.

## Descripción 📝

El sistema está diseñado para controlar el tiempo de estacionamiento de vehículos y la emisión de multas cuando se excede el tiempo pagado. Incluye funcionalidades para:
- Registro de vehículos parqueados
- Control de tiempo mediante parquímetro
- Emisión de multas por oficiales de policía
- Generación de reportes de infracciones

## Estructura del Proyecto 🏗️

El proyecto está compuesto por las siguientes clases principales:

### CarroParqueado
- Gestiona la información de los vehículos estacionados
- Mantiene registro de marca, modelo, color, placa y hora de entrada
- Calcula el tiempo de estacionamiento

### Parquimetro
- Controla el tiempo pagado por estacionamiento
- Permite agregar minutos de parqueo
- Verifica el estado del tiempo pagado

### OficialPolicia
- Representa al oficial autorizado
- Puede emitir multas
- Mantiene registro de nombre y placa del oficial

### TiqueteMulta
- Registra las infracciones
- Calcula el monto de la multa
- Genera reportes detallados

## Diagrama de Clases 📊

El proyecto incluye un diagrama UML (`diagrama.puml`) que muestra la estructura y relaciones entre las clases. Para visualizarlo:

1. Usando VS Code:
   - Instalar la extensión PlantUML
   - Abrir `diagrama.puml`
   - Presionar `Alt+D` (Windows/Linux) o `Option+D` (macOS)

2. Usando servicio web:
   - Visitar [PlantText](https://www.planttext.com/)
   - Copiar el contenido de `diagrama.puml`

## Cómo Usar el Sistema 🚀

1. **Registro de Vehículo**:
```java
CarroParqueado carro = new CarroParqueado("Toyota", "Corolla", "Rojo", "ABC123");
```

2. **Control de Tiempo**:
```java
Parquimetro parquimetro = new Parquimetro();
parquimetro.agregarMinutos(60); // Agregar 1 hora de tiempo
```

3. **Emisión de Multa**:
```java
OficialPolicia oficial = new OficialPolicia("Juan Pérez", "12345");
TiqueteMulta multa = oficial.emitirMulta(carro, parquimetro);
```

## Requisitos 📋

- Java JDK 8 o superior
- IDE compatible con Java (Eclipse, IntelliJ IDEA, VS Code, etc.)

## Instalación 💻

1. Clonar el repositorio:
```bash
git clone [URL-del-repositorio]
```

2. Compilar los archivos:
```bash
javac *.java
```

3. Ejecutar el programa:
```bash
java Main
```

## Interfaz de Usuario 🖥️

El sistema ofrece dos opciones de interfaz:
1. **Consola**: Usando la clase `Scanner`
2. **Gráfica**: Usando `JOptionPane`

## Contribuir 🤝

Si deseas contribuir al proyecto:
1. Haz un Fork del repositorio
2. Crea una nueva rama para tus cambios
3. Envía un Pull Request

## Licencia 📄

Este proyecto está bajo la Licencia MIT - ver el archivo LICENSE.md para más detalles.



## Autores ✒️

* **Sergio Andres Silva** - *Desarrollador*
* **Marianie Vasquez** - *Desarrolladora*

