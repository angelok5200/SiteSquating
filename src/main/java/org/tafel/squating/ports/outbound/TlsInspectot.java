package org.tafel.squating.ports.outbound;

import org.tafel.squating.domain.value.TlsSnapshot;

public interface TlsInspectot {
    TlsSnapshot inspect(String domain);
}
