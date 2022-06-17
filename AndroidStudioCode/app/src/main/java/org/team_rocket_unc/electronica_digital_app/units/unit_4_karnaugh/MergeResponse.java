package org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh;

import java.util.Map;
import java.util.Set;

public class MergeResponse {

    private final Set<String> essentials;
    private final Map<Integer, Set<String>> merged;

    public MergeResponse(Set<String> essentials, Map<Integer, Set<String>> merged) {
        this.essentials = essentials;
        this.merged = merged;
    }

    public Set<String> getEssentials() {
        return essentials;
    }

    public Map<Integer, Set<String>> getMerged() {
        return merged;
    }

}
