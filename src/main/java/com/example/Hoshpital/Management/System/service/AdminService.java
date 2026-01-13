package com.example.Hoshpital.Management.System.service;

import com.example.Hoshpital.Management.System.entity.type.RoleType;

public interface AdminService {

    String createRole(Long userId, RoleType role);
}
