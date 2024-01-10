public class Radio implements IRadio{
    private boolean state;
    private boolean station;
    private double listAM [];
    private double listFM [];
    private double numberStation;


    public Radio(boolean state, boolean station, double listAM[], double listFM[], double numberStation) {
        this.state = state;
        this.station = station;
        this.listAM = new double[12];
        this.listFM = new double[12];
        this.numberStation = numberStation;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isAm'");
    }


    /**
     * Método que permite saber si está apagado o encencido el radio.
     */
    @Override
    public boolean isOn() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isOn'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'switchOnOff'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextStation'");
    }



}
