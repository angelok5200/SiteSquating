package org.tafel.squating.ports.outbound;

public interface ScreenshotService {
    String capture(String domain, String outputDirectory);
}
