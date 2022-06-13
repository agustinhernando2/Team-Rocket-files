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
        System.out.println("-----------------------------------------");
        System.out.println("Solución por algoritmo QuineMcCluskey");
        System.out.printf("Minterms: %s\n",mintermsIn.toString());
        System.out.printf("Don't care conditions: %s\n",dontCareConditionsIn.toString());
        System.out.println("-----------------------------------------");
        mintermsIn.addAll(dontCareConditionsIn);
        Collections.sort(mintermsIn);

        Map<Integer,List<String>> groups = new HashMap<>();
        for(int i=0;i<6;i++){
            ArrayList<String> binaries = new ArrayList<>();
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
        System.out.println("-----------------------------------------");


        Map<Integer, List<String>> implications = new HashMap<>();

        for(int i = 0; i < groups.size() - 2; i++) {
            List<String> currentList = groups.get(i);
            List<String> nextList = groups.get(i + 1);
            List<String> newListBinaries = new ArrayList<>();
            for(String currentBinary : currentList) {
                for(String comparedBinary : nextList) {
                    String changesOneBit = changesOneBit(currentBinary, comparedBinary);
                    if(changesOneBit != null) {
                        newListBinaries.add(changesOneBit);
                    }
                }
                if(newListBinaries.size() == 0 )
                    newListBinaries.add(currentBinary);
            }
            implications.put(i, newListBinaries);
        }

        Set<String> finalGroups = new HashSet<>();

        List<String> implicationValues = new ArrayList<>();
        for(List<String> implicationValue : implications.values()) {
            implicationValues.addAll(implicationValue);
        }
        for(String currentBinary : implicationValues) {
            List<String> currentFinalGroups = new ArrayList<>();
            List<String> comparedValues = new ArrayList<>();
            for(List<String> comparedValue : implications.values()) {
                comparedValues.addAll(comparedValue);
            }
            for(String comparedBinary : comparedValues) {
                String changesOneBit = changesOneBit(currentBinary, comparedBinary);
                if(changesOneBit != null) {
                    currentFinalGroups.add(changesOneBit);
                }
            }
            if(currentFinalGroups.size() == 0) {
                finalGroups.add(currentBinary);
            } else {
                finalGroups.addAll(currentFinalGroups);
            }
        }


        System.out.printf("%s %14s\n","Grupo N°","Minterms");
        System.out.println("=========================================");
        for(Integer g:implications.keySet()) {
            if (!implications.get(g).isEmpty()) {
                System.out.printf("%d\n", g);
                for (String s : implications.get(g))
                    System.out.printf("%20s\n", s);
            }
            else
                implications.remove(implications.get(g));
        }
        System.out.println("----------------------------------------------------------");


        HashMap<ArrayList<Integer>,String> relations= new HashMap<>();
        HashMap<ArrayList<Integer>,Boolean> essentials = new HashMap<>();

        for(String f:finalGroups){
            ArrayList<Integer> str2dec = stringToDec(f);
            relations.put(str2dec,f);
            essentials.put(str2dec,false);
        }

        int control =0;
        for(int j=0; j<= mintermsIn.size();j++) {
            Integer mint = mintermsIn.get(control);
            int cont = 0;
            ArrayList<Integer> aux = new ArrayList<>();
            for (ArrayList<Integer> it : essentials.keySet()) {
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

        while(!mintermsIn.isEmpty()){
            Integer mint = mintermsIn.get(0);
            for (ArrayList<Integer> it : essentials.keySet()) {
                if (it.contains(mint)) {
                    for(Integer i:it){
                        mintermsIn.remove(i);
                    }
                    essentials.put(it, true);
                    break;
                }
            }
        }

        ArrayList<ArrayList<Integer>> toDelete = new ArrayList<>();
        for(ArrayList<Integer> it:essentials.keySet()){
            if(!essentials.get(it)){
                toDelete.add(it);
            }
        }
        for(ArrayList<Integer> it: toDelete){
            essentials.remove(it);
        }

        Set<String> finals = new HashSet<>();
        Set<String> functions = new HashSet<>();
        for(ArrayList<Integer> it:essentials.keySet()){
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

    private ArrayList<Integer> stringToDec(String s){
        int cont=0;
        for(int i=0; i<s.length(); i++)
            if(s.charAt(i)=='-')
                cont++;
        ArrayList<Integer> dec = new ArrayList<>();
        switch (cont){
            case 0:
                dec.add(bin2dec(s));
                break;
            case 1:
                dec.add(bin2dec(s.replace('-','0')));
                dec.add(bin2dec(s.replace('-','1')));
                break;
            case 2:
                for(int i=0;i<2;i++){
                    String dtemp = s.replaceFirst("-",i+"");
                    for(int j=0; j<2;j++){
                        char[] changes = {'0','1'};
                        dec.add(bin2dec(dtemp.replace('-',changes[j])));
                    }
                }
                break;
        }
        return dec;
    }

    private int bin2dec(String s){
        int dec=0;
        for(int i=0; i<s.length();i++){
            dec= (int) (dec+Character.getNumericValue(s.charAt(i))*Math.pow(2,3-i));
        }
        return dec;
    }

    private String string2Function(String s){
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
