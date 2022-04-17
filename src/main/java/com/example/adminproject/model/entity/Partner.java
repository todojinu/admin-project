package com.example.adminproject.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = {"itemList", "category"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String status;

    private String address;

    private String callCenter;

    private String partnerNumber;

    private String businessNumber;

    private String ceoName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate  // 변경감지에 의해 생성시 자동으로 날짜가 셋팅
    private LocalDateTime createdAt;

    @CreatedBy  // LoginUserAuditorAware 클래스의 getCurrentAuditor 메소드가 리턴하는 "AdminServer" 가 셋팅되게 됨
    private String createdBy;

    @LastModifiedDate  // 변경감지에 의해 변경시 자동으로 날짜가 셋팅
    private LocalDateTime updatedAt;

    @LastModifiedBy  // LoginUserAuditorAware 클래스의 getCurrentAuditor 메소드가 리턴하는 "AdminServer" 가 셋팅되게 됨
    private String updatedBy;

    // Partner N : 1 Category
    @ManyToOne
    private Category category;

    // Partner 1 : N Item
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<Item> itemList;

}
