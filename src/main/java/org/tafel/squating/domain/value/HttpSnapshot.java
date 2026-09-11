package org.tafel.squating.domain.value;

import java.util.List;

public record  HttpSnapshot(
    int StatusCode,
    String finalURL,
    List<String> redirectChain,
    String title,
    String contentType,
    long ContentLenght
) {
    public   HttpSnapshot{
        redirectChain = List.copyOf(redirectChain);
    }
}
