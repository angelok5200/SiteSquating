package org.tafel.squating.analysis;

public record SimilarityResult(
    double textSimilarity,
    double htmlSimilarity,
    boolean logoSimilarity,
    boolean faviconMatch
) {
    public SimilarityResult {
        if (textSimilarity < 0 || textSimilarity > 1) {
            throw new IllegalArgumentException("Text similarity must be between 0 and 1");
        }
        if (htmlSimilarity < 0 || htmlSimilarity > 1) {
            throw new IllegalArgumentException("HTML similarity must be between 0 and 1");
        }
    }
}
