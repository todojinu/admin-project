package com.example.adminproject.repository;

import com.example.adminproject.AdminProjectApplicationTests;
import com.example.adminproject.model.entity.User;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

public class UserRepositoryTests extends AdminProjectApplicationTests {

    @Autowired
    UserRepository userRepository;

    @Test
    public void create() {
        String account = "Test03";
        String password = "Test03";
        String status = "REGISTERED";
        String email = "Test03@gmail.com";
        String phoneNumber = "010-1111-3333";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime unregisteredAt = LocalDateTime.now();

//        User user = new User();

//        user.setAccount(account);
//        user.setPassword(password);
//        user.setStatus(status);
//        user.setEmail(email);
//        user.setPhoneNumber(phoneNumber);
//        user.setRegisteredAt(registeredAt);
//        user.setUnregisteredAt(unregisteredAt);

        User user = User.builder()
                .account(account)
                .password(password)
                .status(status)
                .email(email)
                .build();

        User newUser = userRepository.save(user);

        assert newUser != null;

        System.out.println(newUser);
    }

    @Test
    @Transactional
    public void read() {
        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");

        user.getOrderGroupList().stream().forEach(orderGroup -> {
            System.out.println("---------------- 주문묶음 ------------------");
            System.out.println("수령인: " + orderGroup.getRevName());
            System.out.println("수령지: " + orderGroup.getRevAddress());
            System.out.println("총금액: " + orderGroup.getTotalPrice());
            System.out.println("총수량: " + orderGroup.getTotalQuantity());

            System.out.println("---------------- 주문상세 ------------------");
            orderGroup.getOrderDetailList().forEach(orderDetail -> {
                System.out.println("파트너사 이름: " + orderDetail.getItem().getPartner().getName());
                System.out.println("파트너사 카테고리: " + orderDetail.getItem().getPartner().getCategory().getTitle());
                System.out.println("주문 상품: " + orderDetail.getItem().getName());
                System.out.println("고객센터 번호: " + orderDetail.getItem().getPartner().getCallCenter());
                System.out.println("주문의 상태: " + orderDetail.getStatus());
                System.out.println("도착예정일자: " + orderDetail.getArrivalDate());
            });
        });

        assert user != null;

//        System.out.println(user);
    }

}
