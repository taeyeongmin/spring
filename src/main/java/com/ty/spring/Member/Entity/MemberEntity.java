package com.ty.spring.Member.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class MemberEntity {

    @Id
    @Column(name = "member_no")
    private Long memberNo;
    @Column(name = "member_nm")
    private String memberNm;
    private String gender;
    @Column(name = "dept_cd")
    private String deptCd;
}
