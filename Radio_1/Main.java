import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Variables de clase
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;
        int opcion = 0;
        Radio radio = new Radio();

        // Loop que controla el flujo del programa
        while (continueProgram) {
            try {
                Menu();
                opcion = sc.nextInt();

                if (opcion == 1) {
                    radio.switchOnOff();

                } else if (opcion == 2) {
                    radio.switchAMFM();
                } else if (opcion == 3) {
                    radio.nextStation();
                } else if (opcion == 4) {
                    if (radio.isOn()){
                        System.out.println("Ingresa un valor entre 1-12 para guardar la estación actual en el botón: ");
                        int optionSelectStation= sc.nextInt();
                        if(radio.getFrecuence()){ //AM
                            radio.saveStation(optionSelectStation, radio.getNumberStationAM());
                        }else{ //FM
                            radio.saveStation(optionSelectStation, radio.getNumberStationFM());
                        }
                    } else {
                        System.out.println("El radio esta apagado.");
                    }

                } else if (opcion == 5) {
                    if (radio.isOn()){
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

    public static void Menu() {
        System.out.println();
        System.out.println("----------BIENVENIDO----------");
        System.out.println("1. Encencer/Apagar ");
        System.out.println("2. Cambiar frecuencia ");
        System.out.println("3. Cambiar estación ");
        System.out.println("4. Guardar estación ");
        System.out.println("5. Ver estaciones guardadas ");
        System.out.println("6. Salir ");
    }

}