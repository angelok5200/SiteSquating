package org.tafel.squating.domain.value;

import java.util.List;

public record  DnsSnapshot(
    List<String> a,
    List<String> aaa,
    List<String> txt,
    List<String> mx,
    List<String> ns,
    List<String> cname
) {

    public DnsSnapshot {
        a = List.copyOf(a);
        aaa = List.copyOf(aaa);
        cname = List.copyOf(cname);
        mx = List.copyOf(mx);
        ns = List.copyOf(ns);
        txt = List.copyOf(txt);
    }
    
}

