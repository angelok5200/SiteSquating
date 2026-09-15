package org.tafel.squating.scoring;

import java.time.Instant;
import java.util.List;

import org.tafel.squating.analysis.ContentAnalysis;
import org.tafel.squating.analysis.SimilarityResult;
import org.tafel.squating.domain.value.RegistrationSnapshot;

public final class RiskRules {

    private RiskRules() {
        // Prevent instantiation
    }

    public static List<RiskRule> defaults() {
        return List.of(
            new RiskRule(){
                @Override
                public boolean matches(String brand, String candidateDomain, RegistrationSnapshot registration, ContentAnalysis contentAnalysis, SimilarityResult similarityResult, boolean mxConfigured, boolean certificateFound) {
                    return similarityResult != null && similarityResult.textSimilarity() > 0.9;
                }

                @Override
                public int score() {
                    return 20;
                }

                @Override
                public String code() {
                    return "HIGH_TEXT_SIMILARITY";
                }

                @Override
                public String description() {
                    return "High text similarity is high risk for squatting";
                }
            },
            new RiskRule(){
                @Override 
                public boolean matches(String brand, String candidateDomain, RegistrationSnapshot registration, ContentAnalysis contentAnalysis, SimilarityResult similarityResult, boolean mxConfigured, boolean certificateFound) {
                    return similarityResult != null && similarityResult.htmlSimilarity() >= 0.9;
                }

                @Override
                public int score() {
                    return 20;
                }

                @Override
                public String code() {
                    return "HIGH_HTML_SIMILARITY";
                }

                @Override
                public String description() {
                    return "High HTML similarity is high risk for squatting";
                }
            },
            new RiskRule(){
                @Override 
                public boolean matches(String brand, String candidateDomain, RegistrationSnapshot registration, ContentAnalysis contentAnalysis, SimilarityResult similarityResult, boolean mxConfigured, boolean certificateFound) {
                    return contentAnalysis != null && contentAnalysis.brandMentioned();
                }

                @Override
                public int score() {
                    return 15;
                }

                @Override
                public String code() {
                    return "BRAND_MENTIONED";
                }

                @Override
                public String description() {
                    return "Brand name is present";
                }
            },
            new RiskRule(){
                @Override
                public boolean matches(String brand, String candidateDomain, RegistrationSnapshot registration, ContentAnalysis contentAnalysis, SimilarityResult similarityResult, boolean mxConfigured, boolean certificateFound) {
                    return contentAnalysis != null && contentAnalysis.loginFormDetected();
                }

                @Override
                public int score() {
                    return 25;
                }

                @Override
                public String code() {
                    return "LOGIN_FORM";
                }

                @Override
                public String description() {
                    return "contains login form.";
                }
            },
            new RiskRule(){
                @Override
                public boolean matches(String brand, String candidateDomain, RegistrationSnapshot registration, ContentAnalysis contentAnalysis, SimilarityResult similarityResult, boolean mxConfigured, boolean certificateFound) {
                    return contentAnalysis != null && contentAnalysis.passwordFieldDetected();
                }

                @Override
                public int score() {
                    return 25;
                }

                @Override
                public String code() {
                    return "PASSWORD_FIELD";
                }

                @Override
                public String description() {
                    return "contains password field.";
                }
            },
            new RiskRule(){
                @Override
                public boolean matches(String brand, String candidateDomain, RegistrationSnapshot registration, ContentAnalysis contentAnalysis, SimilarityResult similarityResult, boolean mxConfigured, boolean certificateFound) {
                    return contentAnalysis != null && contentAnalysis.walletKeywordsDetected();
                }

                @Override
                public int score() {
                    return 25;
                }

                @Override
                public String code() {
                    return "WALLET_KEYWORDS";
                }

                @Override
                public String description() {
                    return "Wallet keywords detected";
                }
            },
            new RiskRule(){
                @Override
                public boolean matches(String brand, String candidateDomain, RegistrationSnapshot registration, ContentAnalysis contentAnalysis, SimilarityResult similarityResult, boolean mxConfigured, boolean certificateFound) {
                    return contentAnalysis != null && contentAnalysis.paymentKeywordsDetected();
                }

                @Override
                public int score() {
                    return 20;
                }

                @Override
                public String code() {
                    return "PAYMENT_KEYWORDS";
                }

                @Override
                public String description() {
                    return "Payment related keywords detected";
                }
            },
            new RiskRule(){
                @Override
                public boolean matches(String brand, String candidateDomain, RegistrationSnapshot registration, ContentAnalysis contentAnalysis, SimilarityResult similarityResult, boolean mxConfigured, boolean certificateFound) {
                    return mxConfigured;
                                }

                @Override
                public int score() {
                    return 10;
                }

                @Override
                public String code() {
                    return "MX_CONFIGURED";
                }

                @Override
                public String description() {
                    return "Mail exchange records configured";
                }
            },
            new RiskRule(){
                @Override
                public boolean matches(String brand, String candidateDomain, RegistrationSnapshot registration, ContentAnalysis contentAnalysis, SimilarityResult similarityResult, boolean mxConfigured, boolean certificateFound) {
                    return certificateFound;
                }

                @Override
                public int score() {
                    return 10;
                }

                @Override
                public String code() {
                    return "CERTIFICATE_FOUND";
                }

                @Override
                public String description() {
                    return "SSL/TLS certificate found";
                }
            },
            new RiskRule(){
                @Override
                public boolean matches(String brand, String candidateDomain, RegistrationSnapshot registration, ContentAnalysis contentAnalysis, SimilarityResult similarityResult, boolean mxConfigured, boolean certificateFound) {
                    if (registration == null || registration.registered() || registration.registrationDate() == null ) {
                        return false;
                    }
                    Instant threshold = Instant.now().minusSeconds(30L * 24 * 60 * 60); // 30 days
                    return registration.registrationDate().isAfter(threshold);
                }

                @Override
                public int score() {
                    return 15;
                }

                @Override
                public String code() {
                    return "RECENT_REGISTRATION";
                }

                @Override
                public String description() {
                    return "Candidate domain was recently registered";
                }
            }
        );
    }

}