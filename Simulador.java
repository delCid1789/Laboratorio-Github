
public class Simulador extends Equipo implements IOperableRemoto {
    
    // Atributos específicos del simulador
    private String softwareBase; 
    private String fenomenoSimulado; 
    private boolean requiereInternet;
    private boolean operacionRemotaActiva;
    
    /**
     * Constructor de Simulador
     * 
     * @param identificador Código único del simulador
     * @param nombre Nombre del simulador
     * @param fabricante Desarrollador o proveedor
     * @param consumoElectrico Consumo en watts (del hardware que lo ejecuta)
     * @param resumenCaracteristicas Descripción de características
     * @param softwareBase Plataforma de software
     * @param fenomenoSimulado Fenómeno físico que simula
     * @param requiereInternet Si requiere conexión a internet
     */
    public Simulador(String identificador, String nombre, String fabricante,
                     double consumoElectrico, String resumenCaracteristicas,
                     String softwareBase, String fenomenoSimulado, 
                     boolean requiereInternet) {
        super(identificador, nombre, "Simulador", fabricante, 
              consumoElectrico, resumenCaracteristicas);
        this.softwareBase = softwareBase;
        this.fenomenoSimulado = fenomenoSimulado;
        this.requiereInternet = requiereInternet;
        this.operacionRemotaActiva = false;
    }
    
    
    
    public String getSoftwareBase() {
        return softwareBase;
    }
    
    public String getFenomenoSimulado() {
        return fenomenoSimulado;
    }
    
    public boolean requiereInternet() {
        return requiereInternet;
    }
    
    public boolean isOperacionRemotaActiva() {
        return operacionRemotaActiva;
    }
    
   
    
    @Override
    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔═══════════════════════════════════════════════════════════════╗\n");
        sb.append("║                     DETALLES DEL SIMULADOR                    ║\n");
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Identificador       : %-39s ║\n", identificador));
        sb.append(String.format("║ Nombre              : %-39s ║\n", nombre));
        sb.append(String.format("║ Tipo                : %-39s ║\n", tipo));
        sb.append(String.format("║ Fabricante          : %-39s ║\n", fabricante));
        sb.append(String.format("║ Consumo Eléctrico   : %-39s ║\n", consumoElectrico + " W"));
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Software Base       : %-39s ║\n", softwareBase));
        sb.append(String.format("║ Fenómeno Simulado   : %-39s ║\n", fenomenoSimulado));
        sb.append(String.format("║ Requiere Internet   : %-39s ║\n", 
                  requiereInternet ? "SÍ" : "NO"));
        sb.append(String.format("║ Operación Remota    : %-39s ║\n", 
                  operacionRemotaActiva ? "ACTIVA" : "INACTIVA"));
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Características     : %-39s ║\n", 
                  resumenCaracteristicas.length() > 39 ? 
                  resumenCaracteristicas.substring(0, 36) + "..." : 
                  resumenCaracteristicas));
        sb.append("╚═══════════════════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
    
    
    
    @Override
    public void iniciarOperacionRemota() {
        if (!operacionRemotaActiva) {
            operacionRemotaActiva = true;
            System.out.println("✓ Operación remota iniciada para simulador: " + nombre);
            System.out.println("  Lanzando entorno de simulación...");
            if (requiereInternet) {
                System.out.println("  Verificando conexión a internet...");
            }
            System.out.println("  Estableciendo sesión remota...");
            System.out.println("  ¡Simulador listo para ejecución remota!");
        } else {
            System.out.println("⚠ La operación remota ya está activa.");
        }
    }
    
    @Override
    public void detenerOperacionRemota() {
        if (operacionRemotaActiva) {
            operacionRemotaActiva = false;
            System.out.println("✓ Operación remota detenida para simulador: " + nombre);
            System.out.println("  Guardando estado de simulación...");
            System.out.println("  Cerrando sesión remota...");
            System.out.println("  Retornando a modo local.");
        } else {
            System.out.println("⚠ La operación remota no está activa.");
        }
    }
    
    
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Software: %s | Fenómeno: %s", 
                                                 softwareBase, fenomenoSimulado);
    }
}