package org.tafel.squating.generators;

import java.util.Set;

public interface CandidateGenerator {
    Set<String> generate (String domain);
}
