package com.aunghtookhine.library.service;

import com.aunghtookhine.library.dto.MemberDto;
import com.aunghtookhine.library.dto.MemberResponseDto;
import java.util.List;

public interface MemberService {
    MemberResponseDto createMember(MemberDto dto);
    List<MemberResponseDto> findMembers();
    MemberResponseDto findMember(Integer id);
    MemberResponseDto updateMember(Integer id, MemberDto dto);
    void deleteMember(Integer id);
}
