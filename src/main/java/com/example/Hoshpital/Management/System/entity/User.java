package com.example.Hoshpital.Management.System.entity;

import com.example.Hoshpital.Management.System.entity.type.RoleType;
import com.example.Hoshpital.Management.System.security.RolePermissionMapping;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authSystem")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String username;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Set<RoleType> roleTypes = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
      Set<SimpleGrantedAuthority> authorities = new HashSet<>();

      for(RoleType role: roleTypes){
          authorities.add(new SimpleGrantedAuthority(role.name()));
          authorities.addAll(RolePermissionMapping.getAuthoritiesForRole(role));
      }

      return authorities;
    }
}
