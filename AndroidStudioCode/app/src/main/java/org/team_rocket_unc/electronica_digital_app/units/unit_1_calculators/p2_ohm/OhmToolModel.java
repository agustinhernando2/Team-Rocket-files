package org.team_rocket_unc.electronica_digital_app.units.unit_1_calculators.p2_ohm;

public class OhmToolModel {
    private double tension=0;
    private double resistance=0;
    private double current=0;
    private double power=0;

    public void setTension(String source){
        tension=Double.parseDouble(source);
    }
    public void setResistance(String resistor){
        resistance=Double.parseDouble(resistor);
    }
    public void setCurrent(String intensity){
        current=Double.parseDouble(intensity);
    }
    public void setPower(String pow){
        power=Double.parseDouble(pow);
    }

    public String getTension(){
        return Double.toString(tension);
    }
    public String getCurrent(){
        return Double.toString(current);
    }
    public String getResistance(){
        return Double.toString(resistance);
    }
    public String getPower(){
        return Double.toString(power);
    }

    public void calculateTension(){
        tension= ((current!=0 && resistance!=0) ? 0 : current*resistance);
        if(tension==0){
            if(resistance==0){tension=power/current;}
            else{tension=Math.sqrt(power/resistance);}
        }
    }
}
