package org.team_rocket_unc.electronica_digital_app.units.unit_5_datasheets;

import java.util.Arrays;
import java.util.List;

public class DataSheetsToolModel {

    private static final List<String> PDF_LIST = Arrays.asList(
            "cd4011","cd4013","cd4025"
            ,"cd4071","cd4075","cd4081",
            "cd4511","lm555","lm35");

    private String name="cd4011";

    public void setPdf(int dropButtonSelected) {
        name = PDF_LIST.get(dropButtonSelected);
    }

    public String getPdfName(){
        return name;
    }

}
