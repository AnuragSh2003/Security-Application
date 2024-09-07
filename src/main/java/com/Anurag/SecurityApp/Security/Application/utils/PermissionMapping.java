package com.Anurag.SecurityApp.Security.Application.utils;

import com.Anurag.SecurityApp.Security.Application.entities.enums.Permission;
import com.Anurag.SecurityApp.Security.Application.entities.enums.Role;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static com.Anurag.SecurityApp.Security.Application.entities.enums.Permission.*;
import static com.Anurag.SecurityApp.Security.Application.entities.enums.Role.*;

public class PermissionMapping {

    private static final Map<Role, Set<Permission>> map = Map.of(
            USER ,Set.of(USER_VIEW,POST_VIEW),
            CREATOR,Set.of(POST_VIEW,USER_UPDATE,POST_DELETE),
            ADMIN,Set.of(POST_VIEW,USER_UPDATE,USER_DELETE,USER_CREATE,POST_DELETE)
    );

    public static Set<SimpleGrantedAuthority> getAuthoritiesForReal(Role role){
        return map.get(role).stream()
                .map(permission -> new SimpleGrantedAuthority(permission.name()))
                .collect(Collectors.toSet());
    }
}
