import java.util.InputMismatchException;
import java.util.Scanner;

public class Radio implements IRadio {
    private boolean state;
    private boolean frecuence;
    private int numberStationAM;
    private double listAM[];
    private double listFM[];
    private double numberStationFM;

    public Radio() {
        this.state = false;
        this.frecuence = true;
        this.listAM = new double[12];
        this.listFM = new double[12];
        this.numberStationFM = 87.9;
        this.numberStationAM = 530;
    }

    @Override
    public void saveStation(int buttonId, double station) {
        Scanner sc = new Scanner(System.in);
        try {
            if (buttonId >= 1 && buttonId <= 12) {
                if (frecuence) {//AM
                    listAM[(buttonId-1)]= station;
                    System.out.println("El botón " + buttonId + " almacena el número de estación " + station);
                }else{//FM
                    listFM[(buttonId-1)]= station;
                    System.out.println("El botón " + buttonId + " almacena el número de estación " + station);
                }

            } else {
                System.out.println("Opción no válida. ");
            }

        } catch (Exception e) {
            System.out.println("Entrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }

    }

    /**
     * Método que permite ver la frecuencia en la que se encuentra el radio.
     */
    @Override
    public boolean isAm() {
        if (frecuence) {
            return true;
        }
        return false;
    }

    /**
     * Método que permite saber si está apagado o encencido el radio.
     */
    @Override
    public boolean isOn() {
        if (state) {
            return true;
        }
        return false;
    }

    /**
     * Método que permite seleccionar una estación guardada en los 12 botones
     */
    @Override
    public double selectStation(int buttonId) {
        Scanner sc = new Scanner(System.in);
        try {
            if (buttonId >= 1 && buttonId <= 12) {
                if (isAm()) { // LISTA AM
                    if (listAM[(buttonId - 1)] != 0.0) {
                        System.out.println(
                                "La emisora puesta en el botón " + buttonId + " es la " + listAM[(buttonId - 1)]);
                    } else {
                        System.out.println("Actualmente no se encuentra ninguna emisora en el botón " + buttonId);
                    }

                } else { // LISTA FM
                    if (listFM[(buttonId - 1)] != 0.0) {
                        System.out.println(
                                "La emisora puesta en el botón " + buttonId + " es la " + listFM[(buttonId - 1)]);
                    } else {
                        System.out.println("Actualmente no se encuentra ninguna emisora en el botón " + buttonId);
                    }

                }
            } else {
                System.out.println("Opción no válida. ");
            }

        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }
        return 0;
    }

    @Override
    public void switchOnOff() {
        if (state) {
            state = false;
            System.out.println("El radio se apagó. ");
        } else {
            state = true;
            System.out.println("El radio se encendió. ");
        }
    }

    @Override
    public void switchAMFM() {
        if (isOn()) {
            if (frecuence) {
                frecuence = false;
                System.out.println("Frecuencia actual FM");
            } else {
                frecuence = true;
                System.out.println("Frecuencia actual AM");
            }
        } else {
            System.out.println("El radio esta apagado.");
        }

    }

    /**
     * Método que permite cambiar la estación
     */
    @Override
    public double nextStation() {
        if (isOn()) {
            if (isAm()) {
                if (numberStationAM == 1610) {
                    numberStationAM = 530;
                } else {
                    numberStationAM += 10;
                }
                System.err.println("Estacion actual:" + numberStationAM);
                return numberStationAM;
            } else {
                if (numberStationFM == 107.9) {
                    numberStationFM = 87.9;
                } else {
                    numberStationFM += 0.2;
                }
                System.err.println("Estacion actual:" + numberStationFM);
                return numberStationFM;
            }
        } else {
            System.out.println("El radio esta apagado.");
        }
        return 0;
    }

    /*Función GET para obtener los valores de frecuencia y los numeros de estaciones */

    

    public boolean getFrecuence() {
        return this.frecuence;
    }
    public int getNumberStationAM() {
        return this.numberStationAM;
    }
    public double getNumberStationFM() {
        return this.numberStationFM;
    }


}
