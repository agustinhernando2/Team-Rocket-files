package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p2_ohm;

import org.team_rocket_unc.electronica_digital_app.utils.KeyboardUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

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

    public String getCurrent(){
        return KeyboardUtils.DECIMAL_FORMAT.format(current);
    }
    public String getTension(){
        return KeyboardUtils.DECIMAL_FORMAT.format(tension);
    }
    public String getResistance(){
        return KeyboardUtils.DECIMAL_FORMAT.format(resistance);
    }
    public String getPower(){
        return KeyboardUtils.DECIMAL_FORMAT.format(power);
    }

    public void calculateAll(boolean[] inputSelected){
            if(inputSelected[0]){ // Current seleccionada
                //tension seleccionada
                if(inputSelected[1]){resistance=tension/current; power=tension*current;}
                // resistencia seleccionada
                else if(inputSelected[2]){tension=current*resistance; power=Math.pow(current,2)*resistance;}
                // power seleccionada
                else if(inputSelected[3]){resistance=power/Math.pow(current,2);  tension=power/current;}
            }
            else if(inputSelected[1]){ // tension seleccionada
                // resistance seleccionada
                if(inputSelected[2]){current=tension/resistance; power=Math.pow(tension,2)/resistance;}
                // power seleccionda
                else if(inputSelected[3]){resistance=Math.pow(tension,2)/power; current=power/tension;}
            }
            else if(inputSelected[2] && inputSelected[3]){
                // resistance y power
                tension=Math.sqrt(power*resistance); current=Math.sqrt(power/resistance);
            }

    }
}
