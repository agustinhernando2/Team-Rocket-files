package org.team_rocket_unc.electronica_digital_app.KarnaughTests;

import org.junit.Assert;
import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh.KarnaughMap;
import org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh.PetrickStrategy;
import org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh.QuineMcCluskeyStrategy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PetrickTests {

    private void assertSolve(String minterms, String dontCareConditions, String... expectedResults) throws KarnaughMap.InvalidKarnaughInputException {
        KarnaughMap karnaughMap = new KarnaughMap(minterms,dontCareConditions,new PetrickStrategy());
        Set<String> result = karnaughMap.calculateLogicFunction();
        Set<String> expectedResultsSet = new HashSet<>(Arrays.asList(expectedResults));
        Assert.assertEquals(expectedResultsSet, result);
    }

    @Test
    public void testPetrickCombination1() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("1,2,5,8,13,15","",
                "ABD", "AB'C'D'", "A'C'D", "A'B'CD'");
    }

    @Test
    public void testPetrickCombination2() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("1,2,5,8,13,15","3,10,11",
                "ABD", "AB'D'", "A'C'D", "B'C", "A'B'D");
    }

    @Test
    public void testPetrickCombination3() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("0,1,2,3,5,8,13","4,9,11",
                "C'D", "A'C'", "A'B'", "B'C'", "B'D");
    }

    @Test
    public void testPetrickCombination4() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("15","","ABCD");
    }

    @Test
    public void testPetrickCombination5() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("0","","A'B'C'D'");
    }

    @Test
    public void testPetrickCombination6() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("0,1,2,3,4,5,6,7,8,9,10,11,12,13,14","",
                "D'", "C'", "B'", "A'");
    }

    @Test
    public void testPetrickCombination7() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("1,2,6","",
                "A'B'C'D", "A'CD'");
    }

    @Test
    public void testPetrickCombination8() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("1,5,8,13,14","2,7",
                "BC'D", "AB'C'D'", "A'BD", "ABCD'", "A'C'D", "A'B'CD'");
    }

    @Test
    public void testPetrickCombination9() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("5,6,7,8,9,10","1,2",
                "A'CD'", "A'BD", "AB'D'", "A'C'D", "B'C'D");
    }

    @Test
    public void testPetrickCombination10() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("0,15","", "A'B'C'D'", "ABCD");
    }

    @Test
    public void testPetrickCombination11() throws KarnaughMap.InvalidKarnaughInputException {
        assertSolve("1,5,8,13","3,4,7,12,14",
                "BC'", "ABD'", "AC'D'", "A'D");
    }

}
