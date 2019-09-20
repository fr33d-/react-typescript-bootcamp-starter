package com.reply.comsysto.rustylobster.backend.security;

import com.reply.comsysto.rustylobster.backend.config.MethodSecurityConfig;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.security.access.annotation.Secured;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Secured(MethodSecurityConfig.ROLE_USER)
public @interface MustBeAuthenticated {}
