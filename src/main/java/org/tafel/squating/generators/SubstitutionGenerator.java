package org.tafel.squating.generators;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.tafel.squating.domain.enums.MutationType;

@Component
public class SubstitutionGenerator implements TypoGenerator {
    
    private static final Map<Character, String> SUBSTITUTIONS = Map.ofEntries(
        Map.entry('a', "e"),
        Map.entry('e', "a"),

        Map.entry('i', "y"),
        Map.entry('y', "i"),

        Map.entry('o', "a"),
        Map.entry('a', "o"),

        Map.entry('u', "o"),
        Map.entry('o', "u"),

        Map.entry('c', "k"),
        Map.entry('k', "c"),

        Map.entry('c', "s"),
        Map.entry('s', "c"),

        Map.entry('s', "z"),
        Map.entry('z', "s"),

        Map.entry('f', "v"),
        Map.entry('v', "f"),

        Map.entry('b', "p"),
        Map.entry('p', "b"),

        Map.entry('t', "d"),
        Map.entry('d', "t"),

        Map.entry('g', "k"),
        Map.entry('k', "g"),

        Map.entry('n', "m"),
        Map.entry('m', "n")
    );

    @Override
    public MutationType mutationType() {
        // TODO Auto-generated method stub
        return MutationType.SUBSTITUTION;
    }

    @Override
    public Set<String> generate(String domain) {
        // TODO Auto-generated method stub
        Set<String> result = new HashSet<>();
        if (domain == null || domain.isBlank()) {
            return result;
        }

        String normalized = domain.toLowerCase();
        for (int i = 0; i < normalized.length(); i++) {
            char current = normalized.charAt(i);
            String replacement = SUBSTITUTIONS.get(current);
            
            if (replacement == null) {
                continue;
            }
            for (char r : replacement.toCharArray()) {
                result.add(normalized.substring(0, i) + r + normalized.substring(i + 1));
            }
        }

        return result;
    }
}
