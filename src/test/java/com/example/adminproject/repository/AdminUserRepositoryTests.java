package com.example.adminproject.repository;

import com.example.adminproject.AdminProjectApplicationTests;
import com.example.adminproject.model.entity.AdminUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class AdminUserRepositoryTests extends AdminProjectApplicationTests {

    @Autowired
    AdminUserRepository adminUserRepository;

    @Test
    public void create() {
        AdminUser adminUser = new AdminUser();

        adminUser.setAccount("AdminUser01");
        adminUser.setPassword("AdminUser01");
        adminUser.setPassword("REGISTERED");
        adminUser.setStatus("REGISTERED");
        adminUser.setRole("PARTNER");
        adminUser.setLastLoginAt(LocalDateTime.now());
        adminUser.setPasswordUpdatedAt(LocalDateTime.now());
        adminUser.setLoginFailCount(0);
        adminUser.setRegisteredAt(LocalDateTime.now());
        adminUser.setUnregisteredAt(LocalDateTime.now());
        adminUser.setCreatedAt(LocalDateTime.now());
        adminUser.setCreatedBy("AdminServer");
        adminUser.setUpdatedAt(LocalDateTime.now());
        adminUser.setUpdatedBy("AdminServer");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        assert newAdminUser != null;
    }
}
