package com.ty.spring.Member;

import com.ty.spring.Member.service.MemberService;
import com.ty.spring.Member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.List;

@RestController
public class MemberController {

    @Autowired
    private MemberService memberService;
    @ResponseBody
    @GetMapping("/memberList")
    public List<MemberVO> selectMemberList(){

        List<MemberVO> memberEntities = memberService.selectMemberList();

        System.err.println("memberEntities : "+memberEntities);

        return memberEntities;
    };

    @GetMapping("/member/{memberNo}")
    public MemberVO selectMember(@PathVariable Long memberNo){

        MemberVO memberVO = memberService.selectMember(memberNo);

        return memberVO;
    }

    @PostMapping("/member")
    public void createMember(@RequestBody MemberVO memberVO){

//        Long result = memberService.insertMember(memberVO);
        System.err.println("memberVO : "+ memberVO);

    }

}
