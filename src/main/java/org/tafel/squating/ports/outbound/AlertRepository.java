package org.tafel.squating.ports.outbound;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.tafel.squating.domain.model.Alert;

public interface AlertRepository {
    Optional<Alert> findById(UUID id);
    List<Alert> findByCandidateId(UUID candidateId);
    void save(Alert alert);
}
