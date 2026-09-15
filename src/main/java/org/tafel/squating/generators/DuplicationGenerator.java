package org.tafel.squating.generators;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.tafel.squating.domain.enums.MutationType;

@Component
public class DuplicationGenerator implements TypoGenerator {
    @Override
    public MutationType mutationType() {
        return MutationType.DUPLICATION;
    }

    @Override
    public Set<String> generate(String domain) {
        // Implementation for generating duplications
        Set<String> result = new HashSet<>();
        // Add generated duplications to the result set
        if (domain == null || domain.isBlank()) {
            return result;
        }
        for (int i = 0; i < domain.length(); i++) {
            result.add(domain.substring(0, i+1) + domain.charAt(i) + domain.substring(i));
        }
        return result;
    }
}
