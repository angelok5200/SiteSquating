package org.tafel.squating.ports.outbound;

import org.tafel.squating.analysis.ContentAnalysis;

public interface ContentAnalyser {
    ContentAnalysis analyse(String html, String brand);
}
