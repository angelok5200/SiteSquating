package org.tafel.squating.ports.inbound;

import java.util.UUID;

public interface GenerateCandidatesUseCase {
    void generateforBrand(UUID brandId);
}
