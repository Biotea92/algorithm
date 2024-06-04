package org.example.flab.pattern.proxy;

public class RequestInfo {
    public RequestInfo(String name, long responseTime, long startTimestamp) {
        System.out.println("name = " + name);
        System.out.println("responseTime = " + responseTime);
        System.out.println("startTimestamp = " + startTimestamp);
    }
}
