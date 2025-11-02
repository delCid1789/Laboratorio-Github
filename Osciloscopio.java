public class Osciloscopio extends Equipo implements IOperableRemoto {
    
    // Atributos específicos del osciloscopio
    private double anchoBanda; // en MHz
    private int numeroCanales;
    private double tasaMuestreo; // en GS/s (Giga Samples por segundo)
    private boolean operacionRemotaActiva;
    
    /**
     * Constructor de Osciloscopio
     * 
     * @param identificador Código único del osciloscopio
     * @param nombre Nombre del osciloscopio
     * @param fabricante Empresa fabricante
     * @param consumoElectrico Consumo en watts
     * @param resumenCaracteristicas Descripción de características
     * @param anchoBanda Ancho de banda en MHz
     * @param numeroCanales Número de canales
     * @param tasaMuestreo Tasa de muestreo en GS/s
     */
    public Osciloscopio(String identificador, String nombre, String fabricante,
                        double consumoElectrico, String resumenCaracteristicas,
                        double anchoBanda, int numeroCanales, double tasaMuestreo) {
        super(identificador, nombre, "Osciloscopio", fabricante, 
              consumoElectrico, resumenCaracteristicas);
        this.anchoBanda = anchoBanda;
        this.numeroCanales = numeroCanales;
        this.tasaMuestreo = tasaMuestreo;
        this.operacionRemotaActiva = false;
    }
    
    
    
    public double getAnchoBanda() {
        return anchoBanda;
    }
    
    public int getNumeroCanales() {
        return numeroCanales;
    }
    
    public double getTasaMuestreo() {
        return tasaMuestreo;
    }
    
    public boolean isOperacionRemotaActiva() {
        return operacionRemotaActiva;
    }
    
    
    
    @Override
    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔═══════════════════════════════════════════════════════════════╗\n");
        sb.append("║                  DETALLES DEL OSCILOSCOPIO                    ║\n");
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Identificador       : %-39s ║\n", identificador));
        sb.append(String.format("║ Nombre              : %-39s ║\n", nombre));
        sb.append(String.format("║ Tipo                : %-39s ║\n", tipo));
        sb.append(String.format("║ Fabricante          : %-39s ║\n", fabricante));
        sb.append(String.format("║ Consumo Eléctrico   : %-39s ║\n", consumoElectrico + " W"));
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Ancho de Banda      : %-39s ║\n", anchoBanda + " MHz"));
        sb.append(String.format("║ Número de Canales   : %-39s ║\n", numeroCanales));
        sb.append(String.format("║ Tasa de Muestreo    : %-39s ║\n", tasaMuestreo + " GS/s"));
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
            System.out.println("✓ Operación remota iniciada para osciloscopio: " + nombre);
            System.out.println("  Conectando al puerto de control...");
            System.out.println("  Estableciendo protocolo de comunicación...");
            System.out.println("  ¡Listo para control remoto!");
        } else {
            System.out.println("⚠ La operación remota ya está activa.");
        }
    }
    
    @Override
    public void detenerOperacionRemota() {
        if (operacionRemotaActiva) {
            operacionRemotaActiva = false;
            System.out.println("✓ Operación remota detenida para osciloscopio: " + nombre);
            System.out.println("  Cerrando conexión...");
            System.out.println("  Retornando a modo local.");
        } else {
            System.out.println("⚠ La operación remota no está activa.");
        }
    }
    
    
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Ancho Banda: %.0fMHz | Canales: %d", 
                                                 anchoBanda, numeroCanales);
    }
}