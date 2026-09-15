package org.tafel.squating.generators;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.tafel.squating.domain.enums.MutationType;

@Component
public class TranspositionGenerator implements TypoGenerator {
    @Override
    public MutationType mutationType() {
        return MutationType.TRANSPOSITION;
    }

    @Override
    public Set<String> generate(String domain) {
        // Implementation for generating transpositions
        Set<String> result = new HashSet<>();
        // Add generated transpositions to the result set
        if (domain == null || domain.length() < 2) {
            return result;
        }
        for (int i = 0; i < domain.length() - 1; i++) {
            char[] chars = domain.toCharArray();
            // Swap adjacent characters
            char temp = chars[i];
            chars[i] = chars[i + 1];
            chars[i + 1] = temp;
            result.add(new String(chars));
        }
        return result;
    }
}
