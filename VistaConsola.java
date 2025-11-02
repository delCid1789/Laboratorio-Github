import java.util.ArrayList;
import java.util.Scanner;


public class VistaConsola {
    
    private Scanner scanner;
    
    /**
     * Constructor de la vista
     * Inicializa el scanner para lectura de entrada
     */
    public VistaConsola() {
        this.scanner = new Scanner(System.in);
    }
    
    // Muestra menu principal
    public void mostrarMenu() {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║       SISTEMA DE GESTIÓN - LABORATORIO DE FÍSICA              ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.println("║  1. Listar todos los equipos                                  ║");
        System.out.println("║  2. Consultar equipo por identificador                        ║");
        System.out.println("║  3. Consultar equipo por nombre                               ║");
        System.out.println("║  4. Ordenar catálogo por consumo eléctrico                    ║");
        System.out.println("║  5. Mostrar estadísticas del catálogo                         ║");
        System.out.println("║  0. Salir del sistema                                         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
        System.out.print("Seleccione una opción: ");
    }
    
    /**
     * Muestra un mensaje genérico al usuario
     * 
     * @param mensaje El mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    
    /**
     * Muestra un mensaje de error con formato especial
     * 
     * @param error El mensaje de error a mostrar
     */
    public void mostrarError(String error) {
        System.out.println("\n⚠ ERROR: " + error);
    }
    
    /**
     * Muestra la lista completa de equipos en formato de tabla
     * 
     * @param equipos Lista de equipos a mostrar
     */
    public void mostrarListaEquipos(ArrayList<Equipo> equipos) {
        if (equipos == null || equipos.isEmpty()) {
            mostrarMensaje("\n⚠ No hay equipos en el catálogo.");
            return;
        }
        
        System.out.println("\n╔═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                        CATÁLOGO DE EQUIPOS                                                            ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╣");
        
        for (int i = 0; i < equipos.size(); i++) {
            System.out.println("║ " + (i + 1) + ". " + equipos.get(i).toString());
        }
        
        System.out.println("╚═══════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.println("Total de equipos: " + equipos.size());
    }
    
    /**
     * Muestra los detalles completos de un equipo específico
     * 
     * @param equipo El equipo del cual mostrar detalles
     */
    public void mostrarDetalleEquipo(Equipo equipo) {
        if (equipo == null) {
            mostrarError("El equipo no existe.");
            return;
        }
        
        // Utiliza el método mostrarDetalles() polimórfico de cada equipo
        System.out.println(equipo.mostrarDetalles());
        
        // Información adicional según las interfaces implementadas
        if (equipo instanceof ICalibrable) {
            ICalibrable calibrable = (ICalibrable) equipo;
            System.out.println("ℹ Este equipo es calibrable. Última calibración: " + 
                             calibrable.obtenerUltimaCalibracion());
        }
        
        if (equipo instanceof IOperableRemoto) {
            System.out.println("ℹ Este equipo soporta operación remota.");
        }
    }
    
    /**
     * Lee una opción numérica del usuario
     * 
     * @return La opción seleccionada
     */
    public int leerOpcion() {
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            return opcion;
        } catch (Exception e) {
            scanner.nextLine(); // Limpiar el buffer en caso de error
            return -1;
        }
    }
    
    /**
     * Lee un texto ingresado por el usuario
     * 
     * @param prompt El mensaje a mostrar antes de leer
     * @return El texto ingresado
     */
    public String leerTexto(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    
    // encabezado
    public void mostrarEncabezado() {
        System.out.println("\n");
        System.out.println("╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                ║");
        System.out.println("║         LABORATORIO DE FÍSICA - SISTEMA DE GESTIÓN             ║");
        System.out.println("║              Universidad del Valle de Guatemala               ║");
        System.out.println("║                    CC2008 - POO 2025                           ║");
        System.out.println("║                                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝");
    }
    
    // mensaje de despedida
    public void mostrarDespedida() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                ║");
        System.out.println("║          Gracias por usar el Sistema de Gestión                ║");
        System.out.println("║               ¡Hasta pronto!                                   ║");
        System.out.println("║                                                                ║");
        System.out.println("╚════════════════════════════════════════════════════════════════╝\n");
    }
    
    /**
     * Muestra estadísticas del catálogo
     * 
     * @param totalEquipos Total de equipos
     * @param consumoTotal Consumo total en watts
     * @param consumoPromedio Consumo promedio
     */
    public void mostrarEstadisticas(int totalEquipos, double consumoTotal, 
                                   double consumoPromedio) {
        System.out.println("\n╔═══════════════════════════════════════════════════════════════╗");
        System.out.println("║              ESTADÍSTICAS DEL CATÁLOGO                        ║");
        System.out.println("╠═══════════════════════════════════════════════════════════════╣");
        System.out.println(String.format("║ Total de equipos        : %-31d ║", totalEquipos));
        System.out.println(String.format("║ Consumo total           : %-27.2f W ║", consumoTotal));
        System.out.println(String.format("║ Consumo promedio        : %-27.2f W ║", consumoPromedio));
        System.out.println("╚═══════════════════════════════════════════════════════════════╝");
    }
    
    /**
     * Pausa la ejecución hasta que el usuario presione Enter
     */
    public void pausar() {
        System.out.print("\nPresione Enter para continuar...");
        scanner.nextLine();
    }
    
   
    public void cerrar() {
        if (scanner != null) {
            scanner.close();
        }
    }
}