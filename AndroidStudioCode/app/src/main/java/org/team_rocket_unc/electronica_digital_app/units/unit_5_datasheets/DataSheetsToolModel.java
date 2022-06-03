package org.team_rocket_unc.electronica_digital_app.units.unit_5_datasheets;

import java.util.Arrays;
import java.util.List;

public class DataSheetsToolModel {
    private static final List<String> PDF_LIST = Arrays.asList("cd4081","lm555","cd4011");

    private String name="cd4081";

    public void setPdf(int dropButtonSelected) {
        name = PDF_LIST.get(dropButtonSelected);
    }

    public String getPdfName(){
        return name;
    }
}
