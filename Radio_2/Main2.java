import java.util.InputMismatchException;
import java.util.Scanner;
import org.junit.runner.JUnitCore;
import java.text.DecimalFormat;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @author José Ruiz, Gerardo Fernández y Alexander de la Cruz
 * @version 1.0
 * Fecha creación: 10/01/2024
 * 
 */

/**
 * Clase principal que contiene el método main para ejecutar el programa de
 * control de un radio.
 */
public class Main2 {
    /**
     * Método principal que inicia el programa y controla el flujo del mismo.
     */
    public static void main(String[] args) {

        // Inicio del programa
        // Variables de clase
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;
        int opcion = 0;
        Radio2 radio = new Radio2();

        // Loop que controla el flujo del programa
        while (continueProgram) {
            try {
                DecimalFormat df = new DecimalFormat("#.#");
                String formattedStation = df
                        .format(!radio.amfm ? radio.numberAM : radio.numberFM);

                System.err.println("\nEl radio se encuentra: " + (radio.isOn() ? "Encendido" : "Apagado") + "\n" +
                        "Frecuencia: " + (radio.amfm ? "AM" : "FM") + "\n" +
                        "Estación actual: " + formattedStation);
                Menu();
                opcion = sc.nextInt();

                if (opcion == 1) {
                    radio.switchOnOff();

                } else if (opcion == 2) {
                    radio.switchAMFM();
                } else if (opcion == 3) {
                    radio.nextStation();
                } else if (opcion == 4) {
                    if (radio.isOn()) {
                        System.out.println("Ingresa un valor entre 1-12 para guardar la estación actual en el botón: ");
                        int optionSelectStation = sc.nextInt();
                        if (!radio.amfm) { // AM
                            radio.saveStation(optionSelectStation, radio.numberAM);
                        } else { // FM
                            radio.saveStation(optionSelectStation, radio.numberFM);
                        }
                    } else {
                        System.out.println("El radio esta apagado.");
                    }

                } else if (opcion == 5) {
                    if (radio.isOn()) {
                        System.out.println("Ingresa un valor entre 1-12 para ver la estación guardada en el botón: ");
                        int optionSelectStation = sc.nextInt();
                        radio.selectStation(optionSelectStation);

                    } else {
                        System.out.println("El radio esta apagado.");
                    }

                } else if (opcion == 6) {
                    continueProgram = false;
                    System.out.println("¡Gracias por usar el programa!");

                } else {
                    System.out.println("Opción no disponible, ingrese una opción válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, debe ingresar un número entero.");
                sc.nextLine();
            }
        }
    }

    /**
     * Muestra el menú de opciones disponibles.
     */
    public static void Menu() {
        System.out.println();
        System.out.println("----------BIENVENIDO----------");
        System.out.println("1. Encencer/Apagar ");
        System.out.println("2. Cambiar frecuencia ");
        System.out.println("3. Cambiar estación ");
        System.out.println("4. Guardar estación ");
        System.out.println("5. Reproducir estación guardada ");
        System.out.println("6. Salir ");
    }
}