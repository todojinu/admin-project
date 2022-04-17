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
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"user", "orderDetailList"})
@EntityListeners(AuditingEntityListener.class)
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String status;

    private String orderType;  // 주문의 형태 - 일괄 / 개별

    private String revAddress;

    private String revName;

    private String paymentType;  // 카드 / 현금

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDate arrivalDate;

    @CreatedDate  // 변경감지에 의해 생성시 자동으로 날짜가 셋팅
    private LocalDateTime createdAt;

    @CreatedBy  // LoginUserAuditorAware 클래스의 getCurrentAuditor 메소드가 리턴하는 "AdminServer" 가 셋팅되게 됨
    private String createdBy;

    @LastModifiedDate  // 변경감지에 의해 변경시 자동으로 날짜가 셋팅
    private LocalDateTime updatedAt;

    @LastModifiedBy  // LoginUserAuditorAware 클래스의 getCurrentAuditor 메소드가 리턴하는 "AdminServer" 가 셋팅되게 됨
    private String updatedBy;

    // OrderGroup N : 1 User
    @ManyToOne
    private User user;

    // OrderGroup 1 : N OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "orderGroup")
    private List<OrderDetail> orderDetailList;

}
