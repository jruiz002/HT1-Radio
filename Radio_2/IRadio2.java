/**
 * Interfaz que define las operaciones básicas que debe implementar una clase que representa un radio.
 */
public interface IRadio2 {

     /**
     * Guarda la estación actual en un botón preestablecido.
     *
     * @param buttonId Número del botón en el que se almacenará la estación.
     * @param station  Número de la estación a ser almacenada.
     */
    void saveStation(int buttonId, double station);

    /**
     * Verifica si el radio está sintonizado en AM.
     *
     * @return true si la frecuencia es AM, false si es FM.
     */
    boolean isAm();

    /**
     * Verifica si el radio está encendido.
     *
     * @return true si el radio está encendido, false si está apagado.
     */
    boolean isOn();

    /**
     * Selecciona y devuelve la estación almacenada en el botón especificado.
     *
     * @param buttonId Número del botón que se desea seleccionar.
     * @return La estación almacenada en el botón especificado.
     */
    double selectStation(int buttonId);

    /**
     * Enciende o apaga el radio.
     */
    void switchOnOff();

    /**
     * Cambia la frecuencia del radio entre AM y FM.
     */
    void switchAMFM();

    /**
     * Cambia a la siguiente estación disponible en la frecuencia actual.
     *
     * @return La nueva estación seleccionada.
     */
    double nextStation();
}