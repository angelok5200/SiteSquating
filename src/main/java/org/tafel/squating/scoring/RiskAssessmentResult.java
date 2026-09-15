package org.tafel.squating.scoring;


import java.util.List;

import org.tafel.squating.domain.enums.RiskLevel;
import org.tafel.squating.domain.model.RiskReason;

public record RiskAssessmentResult(
        
    int score,    
    RiskLevel level,
    List<RiskReason> reasons
    
        
    ) {public RiskAssessmentResult
     {
        if (score < 0) {
            throw new IllegalArgumentException("Score must not be negative");
        }

        reasons = List.copyOf(reasons);
    }
}