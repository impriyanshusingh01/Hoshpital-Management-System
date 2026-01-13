package com.example.Hoshpital.Management.System.entity.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RolePermissionType {
    PATIENT_READ("patient:read"),
    PATIENT_WRITE("patient:write"),
    PATIENT_UPDATE("patient:update"),
    APPOINTMENT_READ("appointment:read"),
    APPOINTMENT_WRITE("appointment:write"),
    APPOINTMENT_DELETE("appointment:delete"),
    USER_MANAGE("user:manage"), // For admin tasks
    REPORT_VIEW("report:view");

    private final String permission;
}
