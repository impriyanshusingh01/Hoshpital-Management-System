package com.example.Hoshpital.Management.System.security;

import com.example.Hoshpital.Management.System.entity.type.RolePermissionType;
import com.example.Hoshpital.Management.System.entity.type.RoleType;
import lombok.experimental.UtilityClass;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.example.Hoshpital.Management.System.entity.type.RolePermissionType.*;

@UtilityClass
public class RolePermissionMapping {

    private static final Map<RoleType, Set<RolePermissionType>> map = Map.of(
          RoleType.ROLE_PATIENT, Set.of(PATIENT_READ, APPOINTMENT_READ, APPOINTMENT_WRITE),
            RoleType.ROLE_DOCTOR, Set.of(APPOINTMENT_DELETE, APPOINTMENT_WRITE, APPOINTMENT_READ, PATIENT_READ),
            RoleType.ROLE_ADMIN, Set.of(PATIENT_READ, PATIENT_WRITE, APPOINTMENT_READ, APPOINTMENT_WRITE, APPOINTMENT_DELETE, USER_MANAGE, REPORT_VIEW)
    );
    public Set<SimpleGrantedAuthority> getAuthoritiesForRole(RoleType roleType){
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        Set<RolePermissionType> permissions = map.get(roleType);
        if (permissions != null) {
            for (RolePermissionType permission : permissions) {
                authorities.add(new SimpleGrantedAuthority(permission.name()));
            }
        }
        return authorities;
    }
}
