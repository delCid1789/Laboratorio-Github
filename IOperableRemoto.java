public interface IOperableRemoto {
    
    /*
     * Inicia la operación remota del equipo.
     * Configura el equipo para ser controlado a distancia.
     */
    void iniciarOperacionRemota();
    
    /*
     * Detiene la operación remota del equipo.
     * Finaliza la sesión de control remoto y retorna el equipo a modo local.
     */
    void detenerOperacionRemota();
}