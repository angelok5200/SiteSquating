package org.tafel.squating.domain.model;

import java.time.Instant;
import java.util.UUID;

import org.tafel.squating.domain.enums.CandidateStatus;
import org.tafel.squating.domain.enums.MutationType;

public class CandidateDomain {
    private UUID id;
    private UUID brandid;

    private String domain;
    private String sourceDomain;

    private MutationType mutationType;

    private int editDistance;
    private double confidence;

    private CandidateStatus status;

    private Instant firstSeen;
    private Instant lastSeen;

    public String getDomain() {
        return domain;
    }

    public CandidateDomain(UUID id, UUID brandid, String domain) {
        this.id = id;
        this.brandid = brandid;
        this.domain = domain;
    }
}
