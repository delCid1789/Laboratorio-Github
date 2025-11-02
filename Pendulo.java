import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Pendulo extends Equipo implements ICalibrable {
    
    // Atributos específicos del péndulo
    private double longitudBrazo; // en metros
    private String tipoEncoder;
    private double rangoAngular; // en grados
    private String ultimaCalibracion;
    
    /**
     * Constructor de Pendulo
     * 
     * @param identificador Código único del péndulo
     * @param nombre Nombre del péndulo
     * @param fabricante Empresa fabricante
     * @param consumoElectrico Consumo en watts
     * @param resumenCaracteristicas Descripción de características
     * @param longitudBrazo Longitud del brazo en metros
     * @param tipoEncoder Tipo de encoder utilizado
     * @param rangoAngular Rango angular de operación en grados
     */
    public Pendulo(String identificador, String nombre, String fabricante,
                   double consumoElectrico, String resumenCaracteristicas,
                   double longitudBrazo, String tipoEncoder, double rangoAngular) {
        super(identificador, nombre, "Péndulo con Encoder", fabricante, 
              consumoElectrico, resumenCaracteristicas);
        this.longitudBrazo = longitudBrazo;
        this.tipoEncoder = tipoEncoder;
        this.rangoAngular = rangoAngular;
        this.ultimaCalibracion = "Sin calibrar";
    }
    
   
    
    public double getLongitudBrazo() {
        return longitudBrazo;
    }
    
    public String getTipoEncoder() {
        return tipoEncoder;
    }
    
    public double getRangoAngular() {
        return rangoAngular;
    }
    
    
    
    @Override
    public String mostrarDetalles() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n╔═══════════════════════════════════════════════════════════════╗\n");
        sb.append("║              DETALLES DEL PÉNDULO CON ENCODER                 ║\n");
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Identificador       : %-39s ║\n", identificador));
        sb.append(String.format("║ Nombre              : %-39s ║\n", nombre));
        sb.append(String.format("║ Tipo                : %-39s ║\n", tipo));
        sb.append(String.format("║ Fabricante          : %-39s ║\n", fabricante));
        sb.append(String.format("║ Consumo Eléctrico   : %-39s ║\n", consumoElectrico + " W"));
        sb.append("╠═══════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Longitud del Brazo  : %-39s ║\n", longitudBrazo + " m"));
        sb.append(String.format("║ Tipo de Encoder     : %-39s ║\n", tipoEncoder));
        sb.append(String.format("║ Rango Angular       : %-39s ║\n", rangoAngular + "°"));
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
        System.out.println("✓ Péndulo calibrado exitosamente en: " + this.ultimaCalibracion);
    }
    
    @Override
    public String obtenerUltimaCalibracion() {
        return ultimaCalibracion;
    }
    
    
    
    @Override
    public String toString() {
        return super.toString() + String.format(" | Longitud: %.2fm | Encoder: %s", 
                                                 longitudBrazo, tipoEncoder);
    }
}