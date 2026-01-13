package com.example.Hoshpital.Management.System.service.Impl;

import com.example.Hoshpital.Management.System.entity.User;
import com.example.Hoshpital.Management.System.entity.type.RoleType;
import com.example.Hoshpital.Management.System.repository.AuthRepository;
import com.example.Hoshpital.Management.System.service.AdminService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AuthRepository authRepository;

    @Override
    public String createRole(Long userId, RoleType role) {
        User user = authRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("id not found " + userId));

        Set<RoleType> roles = user.getRoleTypes(); // existing roles
        roles.add(role); // naya role add kar do
        user.setRoleTypes(roles);
       authRepository.save(user);
            return "Role updated successfully";
    }
}
