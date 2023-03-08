package com.ty.spring.Member.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MemberEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 데이터베이스에 위임 -> authincrement가 켜있어야 함
    @Column(name = "member_no")
    private Long memberNo;
    @Column(name = "member_nm")
    private String memberNm;
    private String gender;
    @Column(name = "dept_cd")
    private String deptCd;
}
