package org.team_rocket_unc.electronica_digital_app.KarnaughTests;

import org.junit.Assert;
import org.junit.Test;
import org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh.KarnaughMap;
import org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh.QuineMcCluskeyStrategy;

import java.util.Optional;


public class QuineMcCluskeyTests {

    @Test
    public void testQuineMcCluskey(){
        Assert.assertEquals("BC'D,ABD,AB'C'D',A'C'D,A'B'CD',",getResult("1,2,5,8,13,15",""));
        Assert.assertEquals("BC'D,ACD,AB'D',A'C'D,B'C,",getResult("1,2,5,8,13,15","3,10,11"));
        Assert.assertEquals("C'D,A'C',A'B',B'C',B'D,",getResult("0,1,2,3,5,8,13","4,9,11"));
        Assert.assertEquals("ABCD,",getResult("15",""));
        Assert.assertEquals("A'B'C'D',",getResult("0",""));
        Assert.assertEquals("D',C',B',A',",getResult("0,1,2,3,4,5,6,7,8,9,10,11,12,13,14",""));
        Assert.assertEquals("A'B'C'D,A'CD',",getResult("1,2,6",""));
        Assert.assertEquals("BC'D,AB'C'D',A'BD,ABCD',A'C'D,A'B'CD',",getResult("1,5,8,13,14","2,7"));
        Assert.assertEquals("B'CD',AB'C',A'BC,A'C'D,B'C'D,",getResult("5,6,7,8,9,10","1,2"));
        Assert.assertEquals("A'B'C'D',ABCD,",getResult("0,15",""));
        Assert.assertEquals("D',",getResult("0,2,4,6,8,10,12,14",""));
        Assert.assertEquals("BC',ABD',AC'D',A'D,",getResult("1,5,8,13","3,4,7,12,14"));
    }

    public String getResult(String minterms, String dontCareConditions){
        try{
            KarnaughMap karnaughMap = new KarnaughMap(minterms,dontCareConditions,new QuineMcCluskeyStrategy());
            String result="";
            for(String r: karnaughMap.calculateLogicFunction())
                result = result + (r + ",");
            return result;
        }catch(KarnaughMap.InvalidKarnaughInputException i){
            i.printStackTrace();
            return null;
        }
    }
}
