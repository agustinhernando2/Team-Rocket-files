package org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuineMcCluskeyStrategy implements SolverStrategy {

    @Override
    public Set<String> solve(List<Integer> mintermsIn, List<Integer> dontCareConditionsIn) {
        HashSet<String> responseSet = new HashSet<>();
        responseSet.add("AUN NO SE HIZO");
        return responseSet;
    }
}