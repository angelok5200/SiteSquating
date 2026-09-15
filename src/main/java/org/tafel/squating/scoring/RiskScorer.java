package org.tafel.squating.scoring;


import org.tafel.squating.analysis.ContentAnalysis;
import org.tafel.squating.analysis.SimilarityResult;
import org.tafel.squating.domain.value.RegistrationSnapshot;

public interface RiskScorer {

    RiskAssessmentResult score (
        String brand,
        String candidateDomain,
        RegistrationSnapshot registration,
        ContentAnalysis cantontentAnalysis,
        SimilarityResult similarityResult,
        boolean mxConfigured,
        boolean certificateFound
    );
}