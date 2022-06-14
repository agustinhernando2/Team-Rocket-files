package org.team_rocket_unc.electronica_digital_app.units.unit_4_karnaugh;

import java.util.Map;
import java.util.Set;

public class MergeResponse {

    private final Set<String> primes;
    private final Map<Integer, Set<String>> merged;

    public MergeResponse(Set<String> primes, Map<Integer, Set<String>> merged) {
        this.primes = primes;
        this.merged = merged;
    }

    public Set<String> getPrimes() {
        return primes;
    }

    public Map<Integer, Set<String>> getMerged() {
        return merged;
    }

}
