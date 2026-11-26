package com.petnet.petnet.security;

import com.petnet.petnet.Exception.ForbiddenException;
import com.petnet.petnet.User.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
    private SecurityUtils() {}

    public static User getAuthenticatedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || !(authentication.getPrincipal() instanceof User)) {
            throw new ForbiddenException("Usuário não autenticado.");
        }
        return (User) authentication.getPrincipal();
    }
}
