package org.tafel.squating.scoring;


import org.tafel.squating.analysis.ContentAnalysis;
import org.tafel.squating.analysis.SimilarityResult;
import org.tafel.squating.domain.value.RegistrationSnapshot;

public interface RiskRule {

    boolean matches (
        String brand,
        String candidateDomain,
        RegistrationSnapshot registration,
        ContentAnalysis contentAnalysis,
        SimilarityResult similarityResult,
        boolean mxConfigured,
        boolean certificateFound
    );

    int score();

    String code();

    String description();
}