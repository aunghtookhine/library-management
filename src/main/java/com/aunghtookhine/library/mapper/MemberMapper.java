package com.aunghtookhine.library.mapper;

import com.aunghtookhine.library.dto.MemberDto;
import com.aunghtookhine.library.dto.MemberResponseDto;
import com.aunghtookhine.library.model.Member;
import org.springframework.stereotype.Service;

@Service
public class MemberMapper {
    public Member toMember(MemberDto dto){
        Member member = new Member();
        member.setName(dto.name());
        member.setEmail(dto.email());
        member.setPhone(dto.phone());
        return member;
    }
    public MemberResponseDto toMemberResponseDto(Member member){
        return new MemberResponseDto(member.getName(), member.getEmail(), member.getPhone(), member.getMemberSince());
    }
}
