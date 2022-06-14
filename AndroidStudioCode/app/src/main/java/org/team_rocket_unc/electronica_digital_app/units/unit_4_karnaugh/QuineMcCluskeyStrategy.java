package org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QuineMcCluskeyStrategy implements SolverStrategy {


    public Set<String> solve(List<Integer> mintermsIn, List<Integer> dontCareConditionsIn){

        printAlgorithmData(mintermsIn, dontCareConditionsIn);

        mintermsIn.addAll(dontCareConditionsIn);
        Collections.sort(mintermsIn);

        Set<String> primes = new HashSet<>();

        Map<Integer,Set<String>> nextTable = createGroup(mintermsIn);
        Map<Integer, Set<String>> table = new HashMap<>();
        while(!isEmpty(nextTable)) {
            table = new HashMap<>(nextTable);
            printGroups(table);
            MergeResponse mergeResponse = merge(table);
            nextTable = mergeResponse.getMerged();
            primes.addAll(mergeResponse.getPrimes());
        }
        Map<Integer, Set<String>> finalTable = new HashMap<>(table);

        System.out.println(finalTable);

        for(Set<String> value : finalTable.values()) {
            primes.addAll(value);
        }
        System.out.println(primes);

        HashMap<List<Integer>,String> relations= new HashMap<>();
        HashMap<List<Integer>,Boolean> essentials = new HashMap<>();

        for(String f:primes){
            List<Integer> str2dec = stringToDec(f);
            relations.put(str2dec,f);
            essentials.put(str2dec,false);
        }

        int control =0;
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
                for(Integer i:aux)
                    mintermsIn.remove(i);
                j=0;
                control=0;
            }
            else
                control++;
        }

        System.out.println("Minterms: " + mintermsIn);
        System.out.println("Essentials: " + essentials);

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
            functions.add(string2Function(relations.get(it)));
        }
        System.out.printf("Implicantes esenciales: %s\n",finals);
        System.out.print("Función lógica simplificada: ");
        System.out.print("F= ");
        int reg = 0;
        for(String s:functions){
            reg++;
            System.out.print(s);
            if(reg< functions.size())
                System.out.print("+");
        }
        System.out.println("\n----------------------------------------------------------");
        return functions;
    }

    private static String changesOneBit(String currentBinary, String comparedBinary) {
        List<Integer> changesIndex = new ArrayList<>();
        for(int charIndex = 0; charIndex < currentBinary.length(); charIndex++) {
            if(comparedBinary.charAt(charIndex) != currentBinary.charAt(charIndex)) {
                changesIndex.add(charIndex);
            }
        }
        if(changesIndex.size() == 1) {
            StringBuilder generalizedBinary = new StringBuilder(currentBinary);
            generalizedBinary.setCharAt(changesIndex.get(0), '-');
            return generalizedBinary.toString();
        }
        return null;
    }

    private boolean isEmpty(Map<Integer, Set<String>> table) {
        for(Set<String> set : table.values()) {
            if(!set.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private Map<Integer, Set<String>> createGroup(List<Integer> mintermsIn) {
        Map<Integer,Set<String>> groups = new HashMap<>();
        for(int i = 0; i < 5; i++) {
            Set<String> binaries = new HashSet<>();
            groups.put(i,binaries);
        }
        for(Integer in:mintermsIn){
            String binary = String.format("%4s",Integer.toBinaryString(in)).replace(' ','0');
            int group = 0;
            for(int i=0;i<binary.length();i++){
                if(binary.charAt(i)=='1')
                    group++;
            }
            groups.get(group).add(binary);
        }
        return groups;
    }

    private MergeResponse merge(Map<Integer, Set<String>> groups) {
        Map<Integer, Set<String>> implications = new HashMap<>();
        Set<String> primes = new HashSet<>();
        for(Set<String> value : groups.values()) {
            primes.addAll(value);
        }
        for(int i = 0; i < groups.size() - 1; i++) {
            Set<String> currentSet = groups.get(i);
            Set<String> nextSet = groups.get(i + 1);
            Set<String> newBinariesSet = new HashSet<>();
            for(String currentBinary : currentSet) {
                for(String comparedBinary : nextSet) {
                    String changesOneBit = changesOneBit(currentBinary, comparedBinary);
                    if(changesOneBit != null) {
                        newBinariesSet.add(changesOneBit);
                        primes.remove(comparedBinary);
                        primes.remove(currentBinary);
                    }
                }
            }
            implications.put(i, newBinariesSet);
        }
        return new MergeResponse(primes, implications);
    }

    private void printAlgorithmData(List<Integer> mintermsIn, List<Integer> dontCareConditionsIn) {
        System.out.println("-----------------------------------------");
        System.out.println("Solución por algoritmo QuineMcCluskey");
        System.out.printf("Minterms: %s\n",mintermsIn.toString());
        System.out.printf("Don't care conditions: %s\n",dontCareConditionsIn.toString());
        System.out.println("-----------------------------------------");
    }

    private void printGroups(Map<Integer, Set<String>> groups) {
        System.out.printf("%s %14s\n","Grupo N°","Minterms");
        System.out.println("=========================================");
        for(Integer g:groups.keySet()) {
            if (!groups.get(g).isEmpty()) {
                System.out.printf("%d\n", g);
                for (String s : groups.get(g))
                    System.out.printf("%20s\n", s);
            }
            else
                groups.remove(groups.get(g));
        }
        System.out.println("----------------------------------------------------------");
    }

    public List<Integer> stringToDec(String s) {
        List<String> strings = new ArrayList<>();
        strings.add(s);
        boolean hasConditionals = true;
        while(hasConditionals) {
            hasConditionals = false;
            List<String> newStrings = new ArrayList<>();
            for(String currentString : strings) {
                if(currentString.contains("-")) {
                    newStrings.add(currentString.replaceFirst("-", "1"));
                    newStrings.add(currentString.replaceFirst("-", "0"));
                    hasConditionals = true;
                } else {
                    newStrings.add(currentString);
                }
            }
            strings = new ArrayList<>(newStrings);
        }
        List<Integer> dec = new ArrayList<>();
        for(String string : strings) {
            dec.add(Integer.parseInt(string, 2));
        }
        return dec;
    }

    public String string2Function(String s){
        String[] lyrics = {"A","B","C","D"};
        String[] not = {"'" ,""};
        StringBuilder out= new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)!='-'){
                out.append(lyrics[i]);
                out.append(not[Character.getNumericValue(s.charAt(i))]);
            }
        }
        return out.toString();
    }

}