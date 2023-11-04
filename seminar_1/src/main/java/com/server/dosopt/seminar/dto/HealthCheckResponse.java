package com.server.dosopt.seminar.dto;

public class HealthCheckResponse {
    private String status;
    private static final String STATUS = "OK";

    public HealthCheckResponse() {
        this.status = STATUS;
    }
}
