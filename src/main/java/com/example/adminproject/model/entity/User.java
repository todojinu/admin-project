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
@ToString(exclude = {"orderGroupList"})  // 상호참조시 연관관계 방지 위해
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)  // chain 패턴
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

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

    // User 1 : N OrderGroup
    @OneToMany(fetch = FetchType.LAZY,  //지연로딩
            mappedBy = "user")  // 어디에 맵핑시킬 것인가 -> OrderGroup의 user와 맵핑
    private List<OrderGroup> orderGroupList;

}
