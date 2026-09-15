package org.tafel.squating.generators;

import java.util.Set;

import org.tafel.squating.domain.enums.MutationType;

public interface TypoGenerator {
    MutationType mutationType();
    Set<String> generate(String domain);
}
