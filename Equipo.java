
 //Representa el contrato base para todos los equipos del laboratorio.
 // Implementa Comparable para permitir ordenamiento por consumo eléctrico.
  
 // Esta clase define los atributos comunes y el comportamiento base que
 // todos los equipos deben tener, promoviendo la reutilización y el polimorfismo.
 
 
public abstract class Equipo implements Comparable<Equipo> {
    
    // Atributos protegidos para permitir acceso a subclases
    protected String identificador;
    protected String nombre;
    protected String tipo;
    protected String fabricante;
    protected double consumoElectrico; // en watts
    protected String resumenCaracteristicas;
    
    /**
     * Constructor de la clase Equipo
     * 
     * @param identificador Código único del equipo
     * @param nombre Nombre descriptivo del equipo
     * @param tipo Tipo o categoría del equipo
     * @param fabricante Empresa fabricante
     * @param consumoElectrico Consumo en watts
     * @param resumenCaracteristicas Descripción de capacidades y características
     */
    public Equipo(String identificador, String nombre, String tipo, 
                  String fabricante, double consumoElectrico, 
                  String resumenCaracteristicas) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.tipo = tipo;
        this.fabricante = fabricante;
        this.consumoElectrico = consumoElectrico;
        this.resumenCaracteristicas = resumenCaracteristicas;
    }
    
   
    
    public String getIdentificador() {
        return identificador;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public String getFabricante() {
        return fabricante;
    }
    
    public double getConsumoElectrico() {
        return consumoElectrico;
    }
    
    public String getResumenCaracteristicas() {
        return resumenCaracteristicas;
    }
    
   
    
    public void setConsumoElectrico(double consumoElectrico) {
        this.consumoElectrico = consumoElectrico;
    }
    
    public void setResumenCaracteristicas(String resumenCaracteristicas) {
        this.resumenCaracteristicas = resumenCaracteristicas;
    }
    
    //  MÉTODOS ABSTRACTOS     
    
    /**
     * Método abstracto que debe ser implementado por todas las subclases
     * para mostrar información detallada específica del equipo.
     * 
     * @return String con los detalles completos del equipo
     */
    public abstract String mostrarDetalles();
    
    // IMPLEMENTACIÓN DE COMPARABLE 
    
    /**
     * Compara este equipo con otro basándose en el consumo eléctrico.
     * Permite ordenar equipos de menor a mayor consumo.
     * 
     * @param otro El equipo con el que se va a comparar
     * @return Valor negativo si este consume menos, positivo si consume más, 0 si es igual
     */
    @Override
    public int compareTo(Equipo otro) {
        return Double.compare(this.consumoElectrico, otro.consumoElectrico);
    }
    
    
    
    /**
     * Representación en String del equipo con información básica.
     * 
     * @return String formateado con los datos principales del equipo
     */
    @Override
    public String toString() {
        return String.format("ID: %-10s | Nombre: %-25s | Tipo: %-15s | Consumo: %6.2fW | Fabricante: %s",
                identificador, nombre, tipo, consumoElectrico, fabricante);
    }
    
    /**
     * Compara si dos equipos son iguales basándose en su identificador.
     * 
     * @param obj Objeto a comparar
     * @return true si tienen el mismo identificador, false en caso contrario
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Equipo equipo = (Equipo) obj;
        return identificador.equals(equipo.identificador);
    }
    
    /**
     * Genera el hash code basado en el identificador.
     * 
     * @return código hash del equipo
     */
    @Override
    public int hashCode() {
        return identificador.hashCode();
    }
}