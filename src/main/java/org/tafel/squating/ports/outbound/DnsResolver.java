package org.tafel.squating.ports.outbound;

import org.tafel.squating.domain.value.DnsSnapshot;

public interface DnsResolver {
    DnsSnapshot resolve(String domain);
}
