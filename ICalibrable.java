public interface ICalibrable {
    
    
      //Realiza el proceso de calibración del equipo.
     // Este método debe actualizar el estado de calibración interno del equipo.
     
    void calibrar();
    
    /**
     * Obtiene información sobre la última calibración realizada.
     * 
     * @return String con la fecha o información de la última calibración
     */
    String obtenerUltimaCalibracion();
}