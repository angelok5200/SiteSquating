package org.tafel.squating.domain.model;

public class RiskReason {
    private final String code;
    private final int score;
    private final String description;
    public RiskReason(String code, int score, String description) {
        this.code = code;
        this.score = score;
        this.description = description;
    }
    public String getCode() {
        return code;
    }
    public int getScore() {
        return score;
    }
    public String getDescription() {
        return description;
    }
}
