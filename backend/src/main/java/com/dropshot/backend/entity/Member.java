package com.dropshot.backend.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="member")
public class Member extends BaseEntity {

    @Id
    private String id;

    @Column(length = 100, nullable = false)
    private int password;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String nickname;

    @Column(length = 30, nullable = false)
    private String birthday;

    @Column
    private String role;
//    @ElementCollection(fetch =  FetchType.LAZY)
//    @Builder.Default
//    private Set<MemberRole> roleSet = new HashSet<>();
//
//    public void addMemberRole(MemberRole role){
//        roleSet.add(role);
//    }


}
