package com.example.listapp.Auth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.thymeleaf.expression.Sets;

import java.util.Set;
import java.util.stream.Collectors;

public enum ApplicationUserRole {
    USER(Set.of(
            ApplicationUserPermissions.USER_READ,
            ApplicationUserPermissions.USER_WRITE
    )),
    ADMIN(Set.of(
            ApplicationUserPermissions.USER_READ,
            ApplicationUserPermissions.USER_WRITE
    ));

    private final Set<ApplicationUserPermissions> applicationUserPermissionsSet;

    ApplicationUserRole(Set<ApplicationUserPermissions> applicationUserPermissionsSet) {
        this.applicationUserPermissionsSet = applicationUserPermissionsSet;
    }

    public Set<ApplicationUserPermissions> getApplicationUserPermissionsSet() {
        return applicationUserPermissionsSet;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getApplicationUserPermissionsSet().stream()
                .map(applicationUserPermissions -> new SimpleGrantedAuthority(applicationUserPermissions.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));

        return permissions;
    }
}
