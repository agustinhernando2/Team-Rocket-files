package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p2_ohm;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OhmToolModel {

    private double tension=0;
    private double resistance=0;
    private double current=0;
    private double power=0;

    public void setCurrent(String intensity){ current=Double.parseDouble(intensity); }
    public void setTension(String source){ tension=Double.parseDouble(source); }
    public void setResistance(String resistor){
        resistance=Double.parseDouble(resistor);
    }
    public void setPower(String pow){
        power=Double.parseDouble(pow);
    }

    public String getTension(){
        return String.format("%.2f", tension);
    }
    public String getCurrent(){
        return String.format("%.2f", current);
    }
    public String getResistance(){
        return String.format("%.2f", resistance);
    }
    public String getPower(){return String.format("%.2f", power);}

    public void calculateAll(List<Boolean> selected){
        if(Collections.frequency(selected, true)==2){
            if(selected.get(0)){ // resistencia seleccionada
                if(selected.get(1)){current=tension/resistance; power=Math.pow(tension,2)/resistance;} //tension seleccionada
                else if(selected.get(2)){tension=current*resistance; power=Math.pow(current,2)*resistance;} // corriente seleccionada
                else if(selected.get(3)){tension=Math.sqrt(power*resistance); current=Math.sqrt(power/resistance);} // power seleccionada
            }
            else if(selected.get(1)){ // tension seleccionada
                if(selected.get(2)){resistance=tension/current; power=tension*current;} // corriente seleccionada
                else if(selected.get(3)){resistance=Math.pow(tension,2)/power; current=power/tension;} // power seleccionda
            }
            else if(selected.get(2) && selected.get(3)){ // corriente y power
                resistance=power/Math.pow(current,2);
                tension=power/current;
            }
        }
    }
}
