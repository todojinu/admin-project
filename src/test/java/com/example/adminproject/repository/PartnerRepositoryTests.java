package com.example.adminproject.repository;

import com.example.adminproject.AdminProjectApplicationTests;
import com.example.adminproject.model.entity.Partner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class PartnerRepositoryTests extends AdminProjectApplicationTests {

    @Autowired
    PartnerRepository partnerRepository;

    @Test
    public void create() {
        String nane = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime unregisteredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        LocalDateTime updatedAt = LocalDateTime.now();
        String updatedBy = "AdminServer";
        Long categoryId = 1L;

        Partner partner = new Partner();
        partner.setName(nane);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setUnregisteredAt(unregisteredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        partner.setUpdatedAt(updatedAt);
        partner.setUpdatedBy(updatedBy);
//        partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);

        assert newPartner != null;

        System.out.println(newPartner);
    }

    @Test
    public void read() {

    }


}
