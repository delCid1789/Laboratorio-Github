import java.util.ArrayList;


public class ControladorLaboratorio {
    
    
    private Catalogo catalogo;      
    private VistaConsola vista;     
    
    /**
     * Constructor del controlador
     * 
     * @param catalogo El modelo con el catálogo de equipos
     * @param vista La vista para interacción con el usuario
     */
    public ControladorLaboratorio(Catalogo catalogo, VistaConsola vista) {
        this.catalogo = catalogo;
        this.vista = vista;
    }
    
    
    public void inicializar() {
        vista.mostrarEncabezado();
        vista.mostrarMensaje("Iniciando sistema...");
        cargarDatosIniciales();
        vista.mostrarMensaje("✓ Sistema inicializado correctamente.");
        vista.mostrarMensaje("✓ " + catalogo.getTotalEquipos() + " equipos cargados en el catálogo.\n");
        vista.pausar();
    }
    
    /**
     * Ejecuta el ciclo principal del sistema
     * Muestra el menú y procesa las opciones del usuario
     */
    public void ejecutar() {
        int opcion;
        
        do {
            vista.mostrarMenu();
            opcion = vista.leerOpcion();
            
            switch (opcion) {
                case 1:
                    listarTodosEquipos();
                    break;
                case 2:
                    consultarEquipoPorId();
                    break;
                case 3:
                    consultarEquipoPorNombre();
                    break;
                case 4:
                    ordenarPorConsumo();
                    break;
                case 5:
                    mostrarEstadisticas();
                    break;
                case 0:
                    vista.mostrarDespedida();
                    break;
                default:
                    vista.mostrarError("Opción inválida. Por favor, intente de nuevo.");
            }
            
            if (opcion != 0 && opcion >= 1 && opcion <= 5) {
                vista.pausar();
            }
            
        } while (opcion != 0);
        
        // Cerrar recursos
        vista.cerrar();
    }
    
    /**
     * Carga los datos iniciales del catálogo
     * Crea al menos un equipo de cada tipo según los requisitos
     */
    private void cargarDatosIniciales() {
        // Crear péndulos
        catalogo.agregarEquipo(new Pendulo(
            "PEN-001",
            "Péndulo Simple Digital",
            "PASCO Scientific",
            15.5,
            "Encoder óptico de alta precisión, interfaz USB",
            0.75,
            "Óptico Incremental",
            180.0
        ));
        
        catalogo.agregarEquipo(new Pendulo(
            "PEN-002",
            "Péndulo de Torsión",
            "Vernier Software",
            12.0,
            "Medición de momentos de inercia, calibración automática",
            0.50,
            "Magnético",
            360.0
        ));
        
        // Crear fotopuertas
        catalogo.agregarEquipo(new Fotopuerta(
            "FP-001",
            "Fotopuerta Dual Infrarroja",
            "PASCO Scientific",
            8.5,
            "Detección por infrarrojo, modo dual para velocidad",
            1.0,
            "Dual",
            2
        ));
        
        catalogo.agregarEquipo(new Fotopuerta(
            "FP-002",
            "Fotopuerta Multi-Canal",
            "Vernier Software",
            10.0,
            "4 canales independientes, alta precisión temporal",
            0.5,
            "Multi-canal",
            4
        ));
        
        // Crear osciloscopios
        catalogo.agregarEquipo(new Osciloscopio(
            "OSC-001",
            "Osciloscopio Digital 100MHz",
            "Tektronix",
            45.0,
            "Pantalla LCD 7 pulgadas, interfaz USB y Ethernet",
            100.0,
            4,
            1.0
        ));
        
        catalogo.agregarEquipo(new Osciloscopio(
            "OSC-002",
            "Osciloscopio de Almacenamiento",
            "Rigol",
            38.0,
            "Memoria profunda, análisis FFT incluido",
            50.0,
            2,
            0.5
        ));
        
        // Crear generadores
        catalogo.agregarEquipo(new Generador(
            "GEN-001",
            "Generador de Funciones 25MHz",
            "Agilent",
            35.0,
            "Señales sinusoidales, cuadradas y triangulares",
            "Sinusoidal/Cuadrada/Triangular",
            25.0,
            10.0
        ));
        
        catalogo.agregarEquipo(new Generador(
            "GEN-002",
            "Generador de Forma Arbitraria",
            "Keysight",
            42.0,
            "Formas de onda arbitrarias, modulación AM/FM",
            "Arbitraria",
            50.0,
            20.0
        ));
        
        // Crear simuladores
        catalogo.agregarEquipo(new Simulador(
            "SIM-001",
            "Simulador de Movimiento Armónico",
            "PhET Interactive",
            75.0,
            "Simulación interactiva de péndulos y sistemas masa-resorte",
            "Java/HTML5",
            "Movimiento Armónico Simple",
            true
        ));
        
        catalogo.agregarEquipo(new Simulador(
            "SIM-002",
            "Simulador de Circuitos RLC",
            "National Instruments",
            80.0,
            "Análisis de circuitos AC/DC, respuesta en frecuencia",
            "LabVIEW",
            "Circuitos Eléctricos",
            false
        ));
        
        catalogo.agregarEquipo(new Simulador(
            "SIM-003",
            "Simulador de Óptica Geométrica",
            "Wolfram Research",
            90.0,
            "Trazado de rayos, lentes, espejos y prismas",
            "Mathematica",
            "Óptica Geométrica",
            true
        ));
    }
    
    /**
     * Lista todos los equipos del catálogo
     */
    private void listarTodosEquipos() {
        ArrayList<Equipo> equipos = catalogo.obtenerTodos();
        vista.mostrarListaEquipos(equipos);
    }
    
    /**
     * Consulta un equipo por su identificador
     */
    private void consultarEquipoPorId() {
        String id = vista.leerTexto("\nIngrese el identificador del equipo: ");
        Equipo equipo = catalogo.buscarPorIdentificador(id);
        
        if (equipo != null) {
            vista.mostrarDetalleEquipo(equipo);
        } else {
            vista.mostrarError("No se encontró un equipo con el identificador: " + id);
        }
    }
    
    /**
     * Consulta un equipo por su nombre
     * Demuestra el uso de overloading en buscarPorNombre
     */
    private void consultarEquipoPorNombre() {
        String nombre = vista.leerTexto("\nIngrese el nombre del equipo: ");
        
        // Primero intenta búsqueda exacta
        Equipo equipo = catalogo.buscarPorNombre(nombre, true);
        
        if (equipo != null) {
            vista.mostrarDetalleEquipo(equipo);
        } else {
            // Si no encuentra, intenta búsqueda parcial (overloading)
            vista.mostrarMensaje("\nNo se encontró coincidencia exacta. Buscando coincidencias parciales...");
            equipo = catalogo.buscarPorNombre(nombre, false);
            
            if (equipo != null) {
                vista.mostrarMensaje("✓ Se encontró: " + equipo.getNombre());
                vista.mostrarDetalleEquipo(equipo);
            } else {
                vista.mostrarError("No se encontró ningún equipo con ese nombre.");
            }
        }
    }
    
    /**
     * Ordena el catálogo por consumo eléctrico
     * Utiliza la implementación de Comparable en la clase Equipo
     */
    private void ordenarPorConsumo() {
        vista.mostrarMensaje("\nOrdenando catálogo por consumo eléctrico...");
        catalogo.ordenarPorConsumo();
        vista.mostrarMensaje("✓ Catálogo ordenado exitosamente.");
        vista.mostrarMensaje("\nCatálogo ordenado (de menor a mayor consumo):");
        listarTodosEquipos();
    }
    
    /**
     * Muestra estadísticas del catálogo
     */
    private void mostrarEstadisticas() {
        ArrayList<Equipo> equipos = catalogo.obtenerTodos();
        
        if (equipos.isEmpty()) {
            vista.mostrarError("No hay equipos en el catálogo.");
            return;
        }
        
        // Calcular estadísticas
        double consumoTotal = 0;
        for (Equipo equipo : equipos) {
            consumoTotal += equipo.getConsumoElectrico();
        }
        
        double consumoPromedio = consumoTotal / equipos.size();
        
        vista.mostrarEstadisticas(equipos.size(), consumoTotal, consumoPromedio);
    }
}