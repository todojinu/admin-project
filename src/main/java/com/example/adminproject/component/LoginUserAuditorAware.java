package com.example.adminproject.component;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

// AuditorAware 인터페이스를 구현하여 @CreateBy, @LastModifiedBy 컬럼에 넣어줄 값을 적용

@Component
public class LoginUserAuditorAware implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("AdminServer");
    }
}
