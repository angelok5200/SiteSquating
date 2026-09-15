package org.tafel.squating.ports.outbound;

import java.util.UUID;

public interface EvidenceRepository {
    void save (
        UUID candidateId,
        String directory,
        UUID observationId
    );
}
