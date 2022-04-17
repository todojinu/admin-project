package com.example.adminproject.repository;

import com.example.adminproject.AdminProjectApplicationTests;
import com.example.adminproject.model.entity.OrderDetail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OrderDetailRepositoryTests extends AdminProjectApplicationTests {

    @Autowired
    OrderDetailRepository orderDetailRepository;

    @Test
    public void create() {
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setStatus("WAITING");
        orderDetail.setArrivalDate(LocalDate.now().plusDays(2));
        orderDetail.setQuantity(1);
        orderDetail.setTotalPrice(BigDecimal.valueOf(900000));
        orderDetail.setCreatedAt(LocalDateTime.now());
        orderDetail.setCreatedBy("AdminServer");
        orderDetail.setUpdatedAt(LocalDateTime.now());
        orderDetail.setUpdatedBy("AdminServer");
//        orderDetail.setOrderGroupId(1L);
//        orderDetail.setItemId(1L);

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        assert newOrderDetail != null;

    }

}
