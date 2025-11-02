public class Generador extends Equipo implements IOperableRemoto {
    
    
    private String tipoSenal; 
    private double frecuenciaMaxima; // en MHz
    private double amplitudMaxima; // en Volts
    private boolean operacionRemotaActiva;
    
    /**
     * Constructor de Generador
     * 
     * @param identificador Código único del generador
     * @param nombre Nombre del generador
     * @param fabricante Empresa fabricante
     * @param consumoElectrico Consumo en watts
     * @param resumenCaracteristicas Descripción de características
     * @param tipoSenal Tipos de señal que puede generar
     * @param frecuenciaMaxima Frecuencia máxima en MHz
     * @param amplitudMaxima Amplitud máxima en Volts
     */
    public Generador(String identificador, String nombre, String fabricante,
                     double consumoElectrico, String resumenCaracteristicas,
                     String tipoSenal, double frecuenciaMaxima, 
                     double amplitudMaxima) {
        super(identificador, nombre, "Generador de Señales", fabricante, 
              consumoElectrico, resumenCaracteristicas);
        this.tipoSenal = tipoSenal;
        this.frecuenciaMaxima = frecuenciaMaxima;
        this.amplitudMaxima = amplitudMaxima;
        this.operacionRemotaActiva = false;
    }
    
    
    
    public String getTipoSenal() {
        return tipoSenal;
    }
    
    public double getFrecuenciaMaxima() {
        return frecuenciaMaxima;
    }
    
    public double getAmplitudMaxima() {
        return amplitudMaxima;
    }
    
    public boolean isOperacionRemotaActiva() {
        return operacionRemotaActiva;
    }
    
    
    
    @Override
    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔═══════════════════════════════════════════════════════════════╗\n");
        sb.append("║               DETALLES DEL GENERADOR DE SEÑALES               ║\n");
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Identificador       : %-39s ║\n", identificador));
        sb.append(String.format("║ Nombre              : %-39s ║\n", nombre));
        sb.append(String.format("║ Tipo                : %-39s ║\n", tipo));
        sb.append(String.format("║ Fabricante          : %-39s ║\n", fabricante));
        sb.append(String.format("║ Consumo Eléctrico   : %-39s ║\n", consumoElectrico + " W"));
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Tipo de Señal       : %-39s ║\n", tipoSenal));
        sb.append(String.format("║ Frecuencia Máxima   : %-39s ║\n", frecuenciaMaxima + " MHz"));
        sb.append(String.format("║ Amplitud Máxima     : %-39s ║\n", amplitudMaxima + " V"));
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
            System.out.println("✓ Operación remota iniciada para generador: " + nombre);
            System.out.println("  Estableciendo conexión GPIB/USB...");
            System.out.println("  Sincronizando parámetros de señal...");
            System.out.println("  ¡Listo para generar señales remotamente!");
        } else {
            System.out.println("⚠ La operación remota ya está activa.");
        }
    }
    
    @Override
    public void detenerOperacionRemota() {
        if (operacionRemotaActiva) {
            operacionRemotaActiva = false;
            System.out.println("✓ Operación remota detenida para generador: " + nombre);
            System.out.println("  Apagando salida de señal...");
            System.out.println("  Cerrando conexión remota...");
            System.out.println("  Retornando a modo local.");
        } else {
            System.out.println("⚠ La operación remota no está activa.");
        }
    }
    
    
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Señal: %s | Frec.Max: %.1fMHz", 
                                                 tipoSenal, frecuenciaMaxima);
    }
}