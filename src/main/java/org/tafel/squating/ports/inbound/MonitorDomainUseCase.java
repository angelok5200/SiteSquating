package org.tafel.squating.ports.inbound;

import java.util.UUID;

public interface MonitorDomainUseCase {
    void monitor(UUID candidateId);
}
