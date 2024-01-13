import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Clase que representa el radio.
 */
public class Radio implements IRadio {
    private boolean state;
    private boolean frecuence;
    private int numberStationAM;
    private double listAM[];
    private double listFM[];
    private double numberStationFM;

    /**
     * Constructor de la clase Radio.
     * Inicializa los atributos con valores predeterminados.
     */
    public Radio() {
        this.state = false;
        this.frecuence = true;
        this.listAM = new double[12];
        this.listFM = new double[12];
        this.numberStationFM = 87.9;
        this.numberStationAM = 530;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveStation(int buttonId, double station) {
        Scanner sc = new Scanner(System.in);
        try {
            if (buttonId >= 1 && buttonId <= 12) {
                if (frecuence) {// AM
                    listAM[(buttonId - 1)] = station;
                    System.out.println("\nEl botón " + buttonId + " almacena el número de estación " + station);
                } else {// FM
                    listFM[(buttonId - 1)] = station;
                    DecimalFormat df = new DecimalFormat("#.#");
                    String formattedStation = df.format(station);
                    System.out
                            .println("\nEl botón " + buttonId + " almacena el número de estación " + formattedStation);
                }

            } else {
                System.out.println("\nOpción no válida. ");
            }

        } catch (Exception e) {
            System.out.println("\nEntrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAm() {
        if (frecuence) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isOn() {
        if (state) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double selectStation(int buttonId) {
        Scanner sc = new Scanner(System.in);      
        try {
            if (buttonId >= 1 && buttonId <= 12) {
                if (isAm()) { // LISTA AM
                    if (listAM[(buttonId - 1)] != 0.0) {
                        System.out.println(
                                "\nLa emisora puesta en el botón " + buttonId + " es la " + listAM[(buttonId - 1)]);
                    } else {
                        System.out.println("\nActualmente no se encuentra ninguna emisora en el botón " + buttonId);
                    }
                    return listAM[(buttonId - 1)];

                } else { // LISTA FM
                    if (listFM[(buttonId - 1)] != 0.0) {
                        DecimalFormat df = new DecimalFormat("#.#");
                        String formattedStation = df.format(listFM[(buttonId - 1)]);
                        System.out.println(
                                "\nLa emisora puesta en el botón " + buttonId + " es la " + formattedStation);
                    } else {
                        System.out.println("\nactualmente no se encuentra ninguna emisora en el botón " + buttonId);
                    }
                    return listFM[(buttonId - 1)];
                }
            } else {
                System.out.println("\nOpción no válida. ");
            }

        } catch (InputMismatchException e) {
            System.out.println("\nEntrada inválida, debe ingresar un número entero.");
            sc.nextLine();
        }
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchOnOff() {
        if (state) {
            state = false;
        } else {
            state = true;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void switchAMFM() {
        if (isOn()) {
            if (frecuence) {
                frecuence = false;
            } else {
                frecuence = true;
            }
        } else {
            System.out.println("\nEl radio está apagado.");
        }
    }

    /**
     * {@inheritDoc}
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
                return numberStationAM;
            } else {
                if (numberStationFM == 107.9) {
                    numberStationFM = 87.9;
                } else {
                    numberStationFM += 0.2;
                }
                return numberStationFM;
            }
        } else {
            System.out.println("\nEl radio esta apagado.");
        }
        return 0;
    }

    /**
     * Obtiene el valor de la frecuencia actual.
     */
    public boolean getFrecuence() {
        return this.frecuence;
    }

    /**
     * Obtiene el número de estación actual en AM.
     */
    public int getNumberStationAM() {
        return this.numberStationAM;
    }

    /**
     * Obtiene el número de estación actual en FM.
     */
    public double getNumberStationFM() {
        return this.numberStationFM;
    }

    public double[] getListAM() {
        return this.listAM;
    }

    public double[] getListFM() {
        return this.listFM;
    }
}
