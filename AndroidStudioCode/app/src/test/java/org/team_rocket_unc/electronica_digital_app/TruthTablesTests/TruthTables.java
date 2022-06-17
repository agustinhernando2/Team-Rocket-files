package org.team_rocket_unc.electronica_digital_app.TruthTablesTests;

import org.junit.Assert;
import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_3_logic_functions.p2_truth_tables.TruthTablesToolModel;

public class TruthTables {

    @Test
    public void testSetGate() {
        TruthTablesToolModel model = new TruthTablesToolModel();
        model.setGate(0);
        Assert.assertEquals("AND", model.getGate());
        model.setGate(2);
        Assert.assertEquals("NAND", model.getGate());
        model.setGate(4);
        Assert.assertEquals("NOT", model.getGate());
    }

}
