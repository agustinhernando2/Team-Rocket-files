package org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PetrickStrategy implements SolverStrategy{

    @Override
    public Set<String> solve(List<Integer> mintermsIn, List<Integer> dontCareConditionsIn) {

        KarnaughPrinter.printAlgorithmData(mintermsIn, dontCareConditionsIn);
        mintermsIn.addAll(dontCareConditionsIn);
        Collections.sort(mintermsIn);
        Set<String> stringEssentials = EssentialsProcessor.computeEssentials(mintermsIn);
        HashMap<List<Integer>,String> relations = new HashMap<>();
        HashMap<List<Integer>,Boolean> essentials = new HashMap<>();

        for(String stringEssential : stringEssentials){
            List<Integer> decimalEssentials = EssentialsProcessor.stringToDecimal(stringEssential);
            relations.put(decimalEssentials, stringEssential);
            essentials.put(decimalEssentials, false);
        }

        for(int minterm : mintermsIn) {
            List<List<Integer>> essentialsContainingMinTerm = new ArrayList<>();
            for(List<Integer> primes : essentials.keySet()) {
                if(primes.contains(minterm)) {
                    essentialsContainingMinTerm.add(primes);
                }
            }
            if(essentialsContainingMinTerm.size() == 1) {
                essentials.put(essentialsContainingMinTerm.get(0), true);
            }
        }

        List<Integer> unusedMinterms = new ArrayList<>(mintermsIn);
        while(unusedMinterms.size() > 0) {
            for(Map.Entry<List<Integer>, Boolean> entry : essentials.entrySet()) {
                if(entry.getValue()) {
                    unusedMinterms.removeAll(entry.getKey());
                }
            }

            List<Integer> maxAvailableEssential = new ArrayList<>();
            for(List<Integer> currentEssential : essentials.keySet()) {
                for(Integer unusedMinterm : unusedMinterms) {
                    if(currentEssential.contains(unusedMinterm)) {
                        if(currentEssential.size() >= maxAvailableEssential.size()) {
                            maxAvailableEssential = currentEssential;
                        }
                    }
                }
            }
            essentials.put(maxAvailableEssential, true);
        }

        for(List<Integer> list : essentials.keySet()) {
            if(!essentials.get(list)) {
                relations.remove(list);
            }
        }

        Set<String> finals = new HashSet<>();
        Set<String> functions = new HashSet<>();
        for(List<Integer> it : relations.keySet()){
            finals.add(relations.get(it));
            functions.add(EssentialsProcessor.string2Function(relations.get(it)));
        }

        KarnaughPrinter.printConclusion(finals, functions);
        return functions;
    }

}
