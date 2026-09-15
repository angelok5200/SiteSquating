package org.tafel.squating.ports.outbound;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.tafel.squating.domain.model.DomainObservation;

public interface ObservationRepository {
    Optional<DomainObservation> findById(UUID id);
    Optional<DomainObservation> findLatestByCandidateId(UUID candidateId);
    List<DomainObservation> findCandidateId(UUID candidateId);
    void save(DomainObservation observation);
}
