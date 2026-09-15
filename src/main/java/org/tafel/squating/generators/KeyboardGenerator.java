package org.tafel.squating.generators;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.tafel.squating.domain.enums.MutationType;

@Component
public class KeyboardGenerator implements TypoGenerator {
        
    private static final Map<Character, List<Character>> NEIGHBORS = Map.ofEntries(
        Map.entry('q', List.of('w', 'a')),
        Map.entry('w', List.of('q', 'a', 's', 'e')),
        Map.entry('e', List.of('w', 's', 'd', 'r')),
        Map.entry('r', List.of('e', 'd', 'f', 't')),
        Map.entry('t', List.of('r', 'f', 'g', 'z')),
        Map.entry('z', List.of('t', 'u', 'g', 'h')),
        Map.entry('u', List.of('z', 'i', 'h', 'j')),
        Map.entry('i', List.of('u', 'j', 'k', 'o')),
        Map.entry('o', List.of('i', 'k', 'l')),
        Map.entry('p', List.of('o', 'l')),

        Map.entry('a', List.of('q', 'w', 's')),
        Map.entry('s', List.of('w', 'a', 'e', 'd', 'x')),
        Map.entry('d', List.of('s', 'e', 'r', 'f', 'c')),
        Map.entry('f', List.of('d', 'r', 't', 'g', 'v')),
        Map.entry('g', List.of('f', 't', 'z', 'h', 'b')),
        Map.entry('h', List.of('g', 'y', 'u', 'j', 'n')),
        Map.entry('j', List.of('h', 'u', 'i', 'k', 'm')),
        Map.entry('k', List.of('j', 'i', 'o', 'l')),
        Map.entry('l', List.of('k', 'o', 'p')),

        Map.entry('y', List.of('x')),
        Map.entry('x', List.of('y', 's', 'd', 'c')),
        Map.entry('c', List.of('x', 'd', 'f', 'v')),
        Map.entry('v', List.of('c', 'f', 'g', 'b')),
        Map.entry('b', List.of('v', 'g', 'h', 'n')),
        Map.entry('n', List.of('b', 'h', 'j', 'm')),
        Map.entry('m', List.of('n', 'j', 'k'))
    );

    @Override
    public MutationType mutationType() {
        return MutationType.KEYBOARD;
    }

    @Override
    public Set<String> generate(String domain) {
        Set<String> result = new HashSet<>();
        if (domain == null || domain.isBlank()) {
            return result;
        }

        String normalized = domain.toLowerCase();
        for (int i = 0; i < normalized.length(); i++) {
            char current = normalized.charAt(i);
            List<Character> neighbors = NEIGHBORS.get(current);
            
            if (neighbors == null) {
                continue;
            }
            for (char r : neighbors) {
                result.add(normalized.substring(0, i) + r + normalized.substring(i + 1));
            }
        }

        return result;
    }
}

