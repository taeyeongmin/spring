package com.ty.spring.Member.vo;

import com.ty.spring.Member.Entity.MemberEntity;
import lombok.*;

import javax.persistence.Column;

import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberVO {

    private Long memberNo;
    private String memberNm;
    private String gender;
    private String deptCd;

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .memberNm(memberNm)
                .gender(gender)
                .deptCd(deptCd)
                .build();
    }

}
