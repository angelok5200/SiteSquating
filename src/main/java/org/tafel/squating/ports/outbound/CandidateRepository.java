package org.tafel.squating.ports.outbound;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.tafel.squating.domain.model.CandidateDomain;

public interface CandidateRepository {
    Optional<CandidateDomain> findById(UUID id);
    List<CandidateDomain> findByBrandId(UUID brandId);
    List<CandidateDomain> findAll();
    void save(CandidateDomain candidate);
}
