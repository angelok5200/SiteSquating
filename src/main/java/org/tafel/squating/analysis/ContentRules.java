package org.tafel.squating.analysis;

import java.util.Set;

public final class ContentRules {
    private ContentRules() {
    }

    public static final Set<String> WALLET_KEYWORDS = Set.of(
            "wallet",
            "connect wallet",
            "metamask",
            "seed phrase",
            "private key"
    );
    public static final Set<String> PAYMENT_KEYWORDS = Set.of(
            "payment",
            "billing",
            "checkout",
            "cvv",
            "credit card",
            "card number"
    );
    public static final Set<String> LOGIN_KEYWORDS = Set.of(
            "login",
            "signin",
            "sign-in",
            "log in"
    );
}
