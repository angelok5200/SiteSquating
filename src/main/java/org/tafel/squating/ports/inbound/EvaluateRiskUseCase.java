package org.tafel.squating.ports.inbound;

import java.util.UUID;

public interface EvaluateRiskUseCase {
    void evaluate (UUID observationId);
}
