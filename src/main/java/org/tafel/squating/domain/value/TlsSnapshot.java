package org.tafel.squating.domain.value;

import java.time.Instant;
import java.util.List;

public record  TlsSnapshot(
    String issuer,
    String subject,
    List<String> SubjectAlternativeNames,
    Instant validFrom,
    Instant validTo,
    String certificateFingerprint
) {
    public TlsSnapshot{
        SubjectAlternativeNames = List.copyOf(SubjectAlternativeNames);
    }
}