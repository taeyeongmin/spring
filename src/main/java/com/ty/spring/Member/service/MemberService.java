package com.ty.spring.Member.service;

import com.ty.spring.Member.Entity.MemberEntity;
import com.ty.spring.Member.repository.MemberRepo;
import com.ty.spring.Member.vo.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

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

    /**
     * DTO -> Entity의 변환을 담당
     *      VO에서 toEntity라는 함수를 통해 builder패턴으로 Entity를 생성하여 리턴한다.
     *
     * @param memberVO
     */
    public void insertMember(MemberVO memberVO) {
        MemberEntity entity = memberVO.toEntity();
        memberRepo.save(entity);
    }

    /**
     * save를 사용하여 업데이트 -> setter사용
     *
     * @param memberVO
     * @param id
     * @throws Exception
     */
    public void updateMember(MemberVO memberVO, Long id) throws Exception {


        Optional<MemberEntity> optional = memberRepo.findById(id);
        /** 위에서 찾은 엔티티가 존재 할 경우 */
        if(optional.isPresent()){
            MemberEntity findEntity = optional.get();
            System.err.println("findEntity : "+findEntity);

            //좋은 방법은 아니지만 일단 setter사용
            findEntity.setDeptCd(memberVO.getDeptCd());
            memberRepo.save(findEntity);
        }else{
            throw new Exception();
        }

//        MemberEntity entity = memberVO.toEntity();
//        memberRepo.save(entity);
    }
}
