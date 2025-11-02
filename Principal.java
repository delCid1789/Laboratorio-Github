// Universidad del Valle de Guatemala
// POO
// Julio Eduardo del Cid Muñoz
// Carnet: 251496
// 1.0
// 2025-11-02

public class Principal {
    
    /**
     * Método principal que inicia la aplicación
     * 
     * @param args 
     */
    public static void main(String[] args) {
        // Mensaje inicial (único System.out.println permitido en Principal)
        System.out.println("Iniciando Sistema de Gestión del Laboratorio de Física...\n");
        
        // Crear componentes del patrón MVC
        Catalogo catalogo = new Catalogo();              // Modelo
        VistaConsola vista = new VistaConsola();         // Vista
        ControladorLaboratorio controlador =             // Controlador
            new ControladorLaboratorio(catalogo, vista);
        
        // Inicializar el sistema (carga de datos iniciales)
        controlador.inicializar();
        
        // Ejecutar el ciclo principal del sistema
        controlador.ejecutar();
    }
}