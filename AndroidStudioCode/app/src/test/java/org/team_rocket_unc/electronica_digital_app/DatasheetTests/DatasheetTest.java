package org.team_rocket_unc.electronica_digital_app.DatasheetTests;

import org.junit.Assert;
import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_5_datasheets.DataSheetsToolModel;

public class DatasheetTest {

    @Test
    public void setPdfTest() {
        DataSheetsToolModel model = new DataSheetsToolModel();
        model.setPdf(0);
        Assert.assertEquals("cd4011", model.getPdfName());
        model.setPdf(4);
        Assert.assertEquals("cd4075", model.getPdfName());
        model.setPdf(8);
        Assert.assertEquals("lm35", model.getPdfName());
    }

}
