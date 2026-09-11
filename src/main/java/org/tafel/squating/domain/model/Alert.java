package org.tafel.squating.domain.model;

import java.time.Instant;
import java.util.UUID;

import org.tafel.squating.domain.enums.AlertStatus;
import org.tafel.squating.domain.enums.AlertType;

public class Alert {
    private final UUID id;
    private final UUID candidateid;
    private final UUID observationid;
    private final UUID riskAssessmentId;

    
    private final AlertType type;
    private final String title;
    private final String message;

    private final  Instant createdAt;
    private Instant sentAt;

    private AlertStatus status;

    public Alert(UUID id, UUID candidateid, UUID observationid, UUID riskAssessmentId, AlertType type, String title,
            String message, Instant createdAt, Instant sentAt, AlertStatus status) {
        this.id = id;
        this.candidateid = candidateid;
        this.observationid = observationid;
        this.riskAssessmentId = riskAssessmentId;
        this.type = type;
        this.title = title;
        this.message = message;
        this.createdAt = createdAt;
        this.sentAt = sentAt;
        this.status = AlertStatus.PENDING;
    }

    public UUID getId() {
        return id;
    }

    public UUID getCandidateid() {
        return candidateid;
    }

    public UUID getObservationid() {
        return observationid;
    }

    public UUID getRiskAssessmentId() {
        return riskAssessmentId;
    }

    public AlertType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getSentAt() {
        return sentAt;
    }

    public AlertStatus getStatus() {
        return status;
    }

}
