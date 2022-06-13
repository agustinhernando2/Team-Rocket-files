package org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KarnaughMap {

    private final SolverStrategy algorithm;
    private final List<Integer> mintermsIn;
    private final List<Integer> dontCareConditionsIn;

    public static class InvalidKarnaughInputException extends Exception {}

    public KarnaughMap(String minterms, String dontCareConditions, SolverStrategy algorithm) throws InvalidKarnaughInputException {
        this.algorithm=algorithm;
        this.mintermsIn = parseInt(minterms);
        this.dontCareConditionsIn = parseInt(dontCareConditions);
        Collections.sort(mintermsIn);
        Collections.sort(dontCareConditionsIn);
        if(overflowsLimits(mintermsIn) || overflowsLimits(dontCareConditionsIn) || mintermsIn.size() == 0) {
            throw new InvalidKarnaughInputException();
        }
    }


    private List<Integer> parseInt(String s) throws InvalidKarnaughInputException{
        String[] inputs = s.split(",");
        List<Integer> parsedInputs = new ArrayList<>();
        if(s.equals("")) {
            return parsedInputs;
        }
        for(String input : inputs) {
            try {
                parsedInputs.add(Integer.parseInt(input.trim()));
            } catch(NumberFormatException e) {
                throw new InvalidKarnaughInputException();
            }
        }
        return parsedInputs;
    }

    private boolean overflowsLimits(List<Integer> list) {
        for(Integer it:list)
            if(it>15 || it<0)
                return true;
        return false;
    }

    public Set<String> calculateLogicFunction(){
        return algorithm.solve(mintermsIn, dontCareConditionsIn);
    }

}
