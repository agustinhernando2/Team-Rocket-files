package org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh;

import java.util.List;
import java.util.Map;
import java.util.Set;

public final class KarnaughPrinter {

    private KarnaughPrinter() {
    }


    public static void printAlgorithmData(List<Integer> mintermsIn, List<Integer> dontCareConditionsIn) {
        System.out.println("-----------------------------------------");
        System.out.println("Solución por algoritmo QuineMcCluskey");
        System.out.printf("Minterms: %s\n",mintermsIn.toString());
        System.out.printf("Don't care conditions: %s\n",dontCareConditionsIn.toString());
        System.out.println("-----------------------------------------");
    }

    public static void printGroups(Map<Integer, Set<String>> groups) {
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

    public static void printConclusion(Set<String> finals, Set<String> functions) {
        System.out.printf("Implicantes esenciales: %s\n",finals);
        System.out.print("Función lógica simplificada: ");
        System.out.print("F= ");
        int reg = 0;
        for(String s : functions){
            reg++;
            System.out.print(s);
            if(reg < functions.size())
                System.out.print("+");
        }
        System.out.println("\n----------------------------------------------------------");
    }


}
