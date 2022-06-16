package org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface SolverStrategy {

    Set<String> solve(List<Integer> mintermsIn, List<Integer> dontCareConditionsIn);

}
