import java.util.ArrayList;
import java.util.Collections;


public class Catalogo {
    
    // Lista polimórfica única que almacena todos los equipos
    private ArrayList<Equipo> equipos;
    
  
    public Catalogo() {
        this.equipos = new ArrayList<>();
    }
    
    /**
     * Agrega un equipo al catálogo
     * 
     * @param equipo El equipo a agregar
     */
    public void agregarEquipo(Equipo equipo) {
        if (equipo != null) {
            equipos.add(equipo);
        }
    }
    
    /**
     * Busca un equipo por su identificador único
     * 
     * @param identificador El ID del equipo a buscar
     * @return El equipo encontrado o null si no existe
     */
    public Equipo buscarPorIdentificador(String identificador) {
        for (Equipo equipo : equipos) {
            if (equipo.getIdentificador().equalsIgnoreCase(identificador)) {
                return equipo;
            }
        }
        return null;
    }
    
    /**
     * Busca un equipo por nombre (búsqueda exacta por defecto)
     * 
     * @param nombre El nombre del equipo a buscar
     * @return El equipo encontrado o null si no existe
     */
    public Equipo buscarPorNombre(String nombre) {
        return buscarPorNombre(nombre, true);
    }
    
    /**
     * Busca un equipo por nombre con opción de búsqueda exacta o parcial
     * Este método demuestra el uso de overloading
     * 
     * @param nombre El nombre del equipo a buscar
     * @param exacto true para búsqueda exacta, false para búsqueda parcial
     * @return El equipo encontrado o null si no existe
     */
    public Equipo buscarPorNombre(String nombre, boolean exacto) {
        for (Equipo equipo : equipos) {
            if (exacto) {
                // Búsqueda exacta (ignora mayúsculas/minúsculas)
                if (equipo.getNombre().equalsIgnoreCase(nombre)) {
                    return equipo;
                }
            } else {
                // Búsqueda parcial (contiene el texto)
                if (equipo.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                    return equipo;
                }
            }
        }
        return null;
    }
    
    /**
     * Obtiene todos los equipos del catálogo
     * 
     * @return ArrayList con todos los equipos
     */
    public ArrayList<Equipo> obtenerTodos() {
        return new ArrayList<>(equipos); // Retorna una copia para encapsulación
    }
    
  
    public void ordenarPorConsumo() {
        Collections.sort(equipos);
    }
    
    /**
     * Obtiene el número total de equipos en el catálogo
     * 
     * @return Cantidad de equipos
     */
    public int getTotalEquipos() {
        return equipos.size();
    }
    
    /**
     * Verifica si existe un equipo con el identificador dado
     * 
     * @param identificador El ID a verificar
     * @return true si existe, false en caso contrario
     */
    public boolean existeIdentificador(String identificador) {
        return buscarPorIdentificador(identificador) != null;
    }
    
    /**
     * Representación en String del catálogo
     * 
     * @return Resumen del catálogo
     */
    @Override
    public String toString() {
        return String.format("Catálogo de Laboratorio - Total de equipos: %d", equipos.size());
    }
}