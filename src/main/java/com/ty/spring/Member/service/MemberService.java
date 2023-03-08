package com.ty.spring.Member.service;

import com.ty.spring.Member.Entity.MemberEntity;
import com.ty.spring.Member.repository.MemberRepo;
import com.ty.spring.Member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private MemberRepo memberRepo;

    @Autowired
    public MemberService(MemberRepo memberRepo){
        this.memberRepo = memberRepo;
    }

    public List<MemberVO> selectMemberList(){
      return memberRepo.findAllMemberVO();
    }

    public MemberVO selectMember(Long memberNo) {
        return memberRepo.findMember(memberNo);
    }

    public void insertMember(MemberVO memberVO) {
//        return memberRepo.insertMember(memberVO);

    }
}
