package org.tafel.squating.scoring;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.tafel.squating.analysis.ContentAnalysis;
import org.tafel.squating.analysis.SimilarityResult;
import org.tafel.squating.domain.enums.RiskLevel;
import org.tafel.squating.domain.model.RiskReason;
import org.tafel.squating.domain.value.RegistrationSnapshot;

@Component
public class RiskScorerImpl implements RiskScorer {

    private final List<RiskRule> rules;

    public RiskScorerImpl(List<RiskRule> rules) {
        this.rules = RiskRules.defaults();
    }

    @Override
    public RiskAssessmentResult score(
        String brand,
        String candidateDomain,
        RegistrationSnapshot registration,
        ContentAnalysis contentAnalysis,
        SimilarityResult similarityResult,
        boolean mxConfigured,
        boolean certificateFound
    ) {
        List<RiskReason> reasons = new ArrayList<>();

        int totalScore = 0;

        for (RiskRule rule : rules) {
            if (!rule.matches(brand, candidateDomain, registration, contentAnalysis, similarityResult, mxConfigured, certificateFound)) {
                continue;
            }
        

        totalScore += rule.score();

        reasons.add(new RiskReason(rule.code(), rule.score(), rule.description()));
        }
        RiskLevel level = determineLevel(totalScore);

        return new RiskAssessmentResult(totalScore, level, reasons);
    }

    private RiskLevel determineLevel(int totalScore) {
        if (totalScore >= 80) {
            return RiskLevel.CRITICAL;
        } else if (totalScore >= 60) {
            return RiskLevel.HIGH;
        } else if (totalScore >= 30) {
            return RiskLevel.MEDIUM;
        } else if (totalScore > 0){
            return RiskLevel.LOW;
        }
            return RiskLevel.INFO;
    }
}