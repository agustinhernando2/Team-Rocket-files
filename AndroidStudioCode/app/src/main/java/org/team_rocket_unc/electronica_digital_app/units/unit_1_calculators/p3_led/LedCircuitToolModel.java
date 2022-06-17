package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p3_led;

import java.util.Arrays;
import java.util.List;

public class LedCircuitToolModel {
    private static final List<Double> LED_TENSIONS = Arrays.asList(1.9, 1.7, 2.4, 2.4,3.4, 3.6);
    private double ledTension = 1.9;
    private double resistance=0;

    public void setLedTension(int dropButtonSelected) {
        ledTension = LED_TENSIONS.get(dropButtonSelected);
    }

    public String getLedTension(){
        return Double.toString(ledTension);
    }

    public void calculate(String current, String sourceTension) throws NumberFormatException{
        try {
            this.resistance = (Double.parseDouble(sourceTension) - this.ledTension) / Double.parseDouble(current);
        } catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    public String getResistance() {
        return Integer.toString((int) Math.round(resistance));
    }
}
