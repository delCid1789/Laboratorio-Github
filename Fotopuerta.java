import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Fotopuerta extends Equipo implements ICalibrable {
    
    // Atributos específicos de la fotopuerta
    private double precisionTemporal; // en microsegundos
    private String modoOperacion; 
    private int numeroCanales;
    private String ultimaCalibracion;
    
    /**
     * Constructor de Fotopuerta
     * 
     * @param identificador Código único de la fotopuerta
     * @param nombre Nombre de la fotopuerta
     * @param fabricante Empresa fabricante
     * @param consumoElectrico Consumo en watts
     * @param resumenCaracteristicas Descripción de características
     * @param precisionTemporal Precisión en microsegundos
     * @param modoOperacion Modo de operación
     * @param numeroCanales Número de canales disponibles
     */
    public Fotopuerta(String identificador, String nombre, String fabricante,
                      double consumoElectrico, String resumenCaracteristicas,
                      double precisionTemporal, String modoOperacion, 
                      int numeroCanales) {
        super(identificador, nombre, "Fotopuerta", fabricante, 
              consumoElectrico, resumenCaracteristicas);
        this.precisionTemporal = precisionTemporal;
        this.modoOperacion = modoOperacion;
        this.numeroCanales = numeroCanales;
        this.ultimaCalibracion = "Sin calibrar";
    }
    
  
    
    public double getPrecisionTemporal() {
        return precisionTemporal;
    }
    
    public String getModoOperacion() {
        return modoOperacion;
    }
    
    public int getNumeroCanales() {
        return numeroCanales;
    }
    
    //  IMPLEMENTACIÓN DE MÉTODOS ABSTRACTOS 
    
    @Override
    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔═══════════════════════════════════════════════════════════════╗\n");
        sb.append("║                   DETALLES DE LA FOTOPUERTA                   ║\n");
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Identificador       : %-39s ║\n", identificador));
        sb.append(String.format("║ Nombre              : %-39s ║\n", nombre));
        sb.append(String.format("║ Tipo                : %-39s ║\n", tipo));
        sb.append(String.format("║ Fabricante          : %-39s ║\n", fabricante));
        sb.append(String.format("║ Consumo Eléctrico   : %-39s ║\n", consumoElectrico + " W"));
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Precisión Temporal  : %-39s ║\n", precisionTemporal + " μs"));
        sb.append(String.format("║ Modo de Operación   : %-39s ║\n", modoOperacion));
        sb.append(String.format("║ Número de Canales   : %-39s ║\n", numeroCanales));
        sb.append(String.format("║ Última Calibración  : %-39s ║\n", ultimaCalibracion));
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Características     : %-39s ║\n", 
                  resumenCaracteristicas.length() > 39 ? 
                  resumenCaracteristicas.substring(0, 36) + "..." : 
                  resumenCaracteristicas));
        sb.append("╚═══════════════════════════════════════════════════════════════╝\n");
        return sb.toString();
    }
    
   
    
    @Override
    public void calibrar() {
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.ultimaCalibracion = ahora.format(formato);
        System.out.println("✓ Fotopuerta calibrada exitosamente en: " + this.ultimaCalibracion);
    }
    
    @Override
    public String obtenerUltimaCalibracion() {
        return ultimaCalibracion;
    }
    
 
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Precisión: %.2fμs | Canales: %d", 
                                                 precisionTemporal, numeroCanales);
    }
}