import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.*;

public class RadioTest {

    /**
     * Prueba la funcionalidad del método nextStation() en la clase Radio con la
     * frecuencia AM
     */
    @Test
    public void testNextStationAM() {
        
        // Se crea una instancia de la clase Radio para realizar la prueba.
        Radio radio = new Radio();

        // Se enciende la radio antes de realizar la prueba.
        radio.switchOnOff();

        // Se verifica si el siguiente valor de estación es igual a 540.
        assertEquals(540, radio.nextStation());
    }

    /**
     * Prueba la funcionalidad del método nextStation() en la clase Radio con la
     * frecuencia FM
     */
    @Test
    public void testNextStationFM() {
        // Se crea una instancia de la clase Radio para realizar la prueba.
        Radio radio = new Radio();

        // Se enciende la radio antes de realizar la prueba.
        radio.switchOnOff();

        // Se cambia a la frecuencia FM del radio
        radio.switchAMFM();

        // Se verifica si el siguiente valor de estación es igual a 88.1
        assertEquals(87.9, radio.nextStation());
    }

    /*
     * Prueba la funcionalidad del metodo saveStation() en la clase radio con la frecuencia AM
     */
    @Test
    public void testSaveStation() {
        // Se crea una instancia de la clase Radio para realizar la prueba.
        Radio radio = new Radio();

        // Se enciende la radio antes de realizar la prueba.
        radio.switchOnOff();

        // Se establecen los valores predeterminados para guardar en la lista de frecuencias
        int buttonId = 1; 
        double station = 530; 

        // Se guarda la estacion 
        radio.saveStation(buttonId, station);

        // Se verifica si se guarda la estacion exitosamente en el boton deseado
        assertEquals(station, radio.listAM[buttonId - 1]);
    }
}