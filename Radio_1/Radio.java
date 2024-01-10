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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveStation'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'selectStation'");
    }

    @Override
    public void switchOnOff() {
        if (state){
            state = false;
            System.out.println("El radio se apagó. ");
        } else{
            state = true;
            System.out.println("El radio se encendió. ");
        }
    }

    @Override
    public void switchAMFM() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'switchAMFM'");
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
}
