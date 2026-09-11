package org.tafel.squating.domain.model;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.tafel.squating.domain.enums.RiskLevel;

public class RiskAssessment {
    private final UUID id;
    private final UUID candidateid;
    private final UUID observationid;

    
    private final int score;
    private final RiskLevel level;

    private final  Instant assessedAt;
    private final List<RiskReason> reasons;

    public RiskAssessment(UUID id, UUID candidateid, UUID observationid, int score, RiskLevel level, Instant assessedAt,
            List<RiskReason> reasons) {
        this.id = id;
        this.candidateid = candidateid;
        this.observationid = observationid;
        this.score = score;
        this.level = level;
        this.assessedAt = assessedAt;
        this.reasons = List.copyOf(reasons);
    }

    public int getScore() {
        return score;
    }

    public RiskLevel getLevel() {
        return level;
    }

    public Instant getAssessedAt() {
        return assessedAt;
    }

    public List<RiskReason> getReasons() {
        return reasons;
    }

    public UUID getObservationid() {
        return observationid;
    }
    
    public UUID getCandidateid() {
        return candidateid;
    }

    public UUID getId() {
        return id;
    }
}
