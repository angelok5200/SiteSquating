package org.tafel.squating.domain.value;

import java.util.Set;

public record  MonitoringPolicy (
    boolean checkRdap,
    boolean checkDns,
    boolean checkHttp,
    boolean checkTls,
    boolean checkMx,
    boolean checkCertificateTransparency,
    boolean takeScreenshots,

    boolean analyzeContent,
    boolean calculateSimilarity,


    int scanIntervalMinutes,
    Set<String> monitoredIds
){
    public   MonitoringPolicy {
        monitoredIds = Set.copyOf(monitoredIds);
            if(scanIntervalMinutes <= 0){
                throw new IllegalArgumentException("scanIntervalMinutes must be greater than 0");
        }
    }
}
