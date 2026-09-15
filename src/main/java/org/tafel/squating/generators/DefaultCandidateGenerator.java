package org.tafel.squating.generators;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class DefaultCandidateGenerator implements CandidateGenerator {
    private final List<TypoGenerator> generators;


    public DefaultCandidateGenerator(List<TypoGenerator> generators) {
        this.generators = List.copyOf(generators);
    }    

    @Override
    public Set<String> generate(String domain) {
        Set<String> candidates = new HashSet<>();

        if (domain == null || domain.isBlank()) {
            return candidates;
        }

        for (TypoGenerator generator : generators) {
            candidates.addAll(generator.generate(domain));
        }

        candidates.remove(domain);

        return candidates;
    }
}
