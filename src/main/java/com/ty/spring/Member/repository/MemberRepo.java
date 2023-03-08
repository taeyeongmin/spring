package com.ty.spring.Member.repository;

import com.ty.spring.Member.Entity.MemberEntity;
import com.ty.spring.Member.vo.MemberVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MemberRepo extends JpaRepository<MemberEntity, Long> {

    /** 해당 방식은 MemberVO의 All생성자를 사용하여 받아온 데이터를 통해 MemberVO객체를 생성한다. */
    @Query("SELECT new com.ty.spring.Member.vo.MemberVO(me.memberNo, me.memberNm, me.gender, me.deptCd) FROM MemberEntity me")
    List<MemberVO> findAllMemberVO();

    @Query("SELECT new com.ty.spring.Member.vo.MemberVO(me.memberNo, me.memberNm, me.gender, me.deptCd) FROM MemberEntity me where me.memberNo = :memberNo")
    MemberVO findMember(Long memberNo);
}
