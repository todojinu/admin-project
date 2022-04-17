package com.example.adminproject.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"orderGroup", "item"})
@EntityListeners(AuditingEntityListener.class)
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String status;

    private LocalDate arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    @CreatedDate  // 변경감지에 의해 생성시 자동으로 날짜가 셋팅
    private LocalDateTime createdAt;

    @CreatedBy  // LoginUserAuditorAware 클래스의 getCurrentAuditor 메소드가 리턴하는 "AdminServer" 가 셋팅되게 됨
    private String createdBy;

    @LastModifiedDate  // 변경감지에 의해 변경시 자동으로 날짜가 셋팅
    private LocalDateTime updatedAt;

    @LastModifiedBy  // LoginUserAuditorAware 클래스의 getCurrentAuditor 메소드가 리턴하는 "AdminServer" 가 셋팅되게 됨
    private String updatedBy;

    // OrderDetail N : 1 OrderGroup
    @ManyToOne
    private OrderGroup orderGroup;  // 어떠한 장바구니에

    // OrderDetail N : 1 Item
    @ManyToOne
    private Item item;  // 어떠한 상품

}
