package org.tafel.squating.domain.model;

import java.time.Instant;
import java.util.Set;
import java.util.UUID;

import org.tafel.squating.domain.value.MonitoringPolicy;

public class Brand {
    private UUID id;
    private String Name;
    private String primaryDomain;

    private Set<String> monitoredIds;
    private MonitoringPolicy monitoringPolicy;

    private Instant createdAt;
    
}
