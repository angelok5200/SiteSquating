package org.tafel.squating.ports.outbound;

import org.tafel.squating.domain.value.MailSnapshot;

public interface MailInspector {
    MailSnapshot inspect(String domain);
}
