package org.tafel.squating.domain.model;
import java.time.Instant;
import java.util.UUID;

import org.tafel.squating.domain.value.DnsSnapshot;
import org.tafel.squating.domain.value.HttpSnapshot;
import org.tafel.squating.domain.value.MailSnapshot;
import org.tafel.squating.domain.value.RegistrationSnapshot;
import org.tafel.squating.domain.value.TlsSnapshot;

public class DomainObservation {
    private UUID id;
    private UUID candidateid;

    private Instant observedAt;

    private String contentHash;
    private String screenshotHash;

    private RegistrationSnapshot registration;
    private DnsSnapshot dns;
    private HttpSnapshot http;
    private TlsSnapshot tls;
    private MailSnapshot mail;
}