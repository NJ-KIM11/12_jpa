package com.ohgiraffers.chap06securityjwt.user.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PreAuthorize("hasAnyAuthority('ADMIN')")
public class AuthAdminController {

    @GetMapping("/admin")
    public String admin() {
        return "admin hello";
    }
}
