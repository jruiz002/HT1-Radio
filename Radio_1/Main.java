import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{
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

                if (opcion == 1){

                }else if (opcion == 2){

                }else if (opcion == 3){
                    radio.nextStation();
                }else if (opcion == 4){
                    
                }else if (opcion == 5){
                    
                }else if (opcion == 6){
                    
                }else{
                    System.out.println("Opción no disponible, ingrese una opción válida.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida, debe ingresar un número entero.");
                sc.nextLine();
            }
        }

    }

    public static void Menu(){
        System.out.println("----------BIENVENIDO----------");
        System.out.println("1. Encencer/Apagar ");
        System.out.println("2. Cambiar frecuencia ");
        System.out.println("3. Cambiar estación ");
        System.out.println("4. Guardar estación ");
        System.out.println("5. Ver estaciones guardadas ");
        System.out.println("6. Salir ");
    }

}