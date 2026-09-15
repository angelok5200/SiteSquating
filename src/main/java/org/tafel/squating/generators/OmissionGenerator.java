package org.tafel.squating.generators;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.tafel.squating.domain.enums.MutationType;

@Component
public class OmissionGenerator implements TypoGenerator {
    @Override
    public MutationType mutationType() {
        return MutationType.OMISSION;
    }

    @Override
    public Set<String> generate(String domain) {
        // Implementation for generating omissions
        Set<String> result = new HashSet<>();
        // Add generated omissions to the result set
        if (domain == null || domain.length() < 2) {
            return result;
        }
        for (int i = 0; i < domain.length(); i++) {
            result.add(domain.substring(0, i) + domain.substring(i + 1));
        }
        return result;
    }
}
