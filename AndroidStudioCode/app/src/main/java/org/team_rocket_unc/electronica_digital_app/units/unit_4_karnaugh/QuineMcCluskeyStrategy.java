package org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuineMcCluskeyStrategy implements SolverStrategy {

    public Set<String> solve(List<Integer> mintermsIn, List<Integer> dontCareConditionsIn){
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

        int control = 0;
        for(int j=0; j< mintermsIn.size();j++) {
            Integer mint = mintermsIn.get(control);
            int cont = 0;
            List<Integer> aux = new ArrayList<>();
            for (List<Integer> it : essentials.keySet()) {
                if (it.contains(mint)) {
                    cont++;
                    aux = it;
                }
            }
            if (cont == 1) {
                essentials.put(aux, true);
                for(Integer i : aux)
                    mintermsIn.remove(i);
                j=0;
                control=0;
            }
            else
                control++;
        }

        while(!mintermsIn.isEmpty()){
            Integer mint = mintermsIn.get(0);
            for (List<Integer> it : essentials.keySet()) {
                if (it.contains(mint)) {
                    for(Integer i:it){
                        mintermsIn.remove(i);
                    }
                    essentials.put(it,true);
                    break;
                }
            }
        }

        List<List<Integer>> toDelete = new ArrayList<>();
        for(List<Integer> it:essentials.keySet()){
            if(!essentials.get(it)){
                toDelete.add(it);
            }
        }
        for(List<Integer> it: toDelete){
            essentials.remove(it);
        }

        Set<String> finals = new HashSet<>();
        Set<String> functions = new HashSet<>();
        for(List<Integer> it:essentials.keySet()){
            finals.add(relations.get(it));
            functions.add(EssentialsProcessor.string2Function(relations.get(it)));
        }



        KarnaughPrinter.printConclusion(finals, functions);
        return functions;
    }

}