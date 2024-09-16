package com.aunghtookhine.library.Service;

import com.aunghtookhine.library.Dto.MemberDto;
import com.aunghtookhine.library.Dto.MemberResponseDto;
import com.aunghtookhine.library.Exception.DuplicateEmailException;
import com.aunghtookhine.library.Exception.DuplicatePhoneNumberException;
import com.aunghtookhine.library.Exception.MemberNotFoundException;
import com.aunghtookhine.library.Mapper.MemberMapper;
import com.aunghtookhine.library.Model.Member;
import com.aunghtookhine.library.Repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    public MemberService(MemberMapper memberMapper, MemberRepository memberRepository) {
        this.memberMapper = memberMapper;
        this.memberRepository = memberRepository;
    }

    public MemberResponseDto createMember(MemberDto dto){
        Member checkEmailDuplicate = memberRepository.findByEmail(dto.email());
        if(checkEmailDuplicate != null) throw new DuplicateEmailException("Email cannot be duplicated.");
        Member checkPhoneNumberDuplicate = memberRepository.findByPhone(dto.phone());
        if(checkPhoneNumberDuplicate != null) throw new DuplicatePhoneNumberException("Phone Number cannot be duplicated.");
        Member savedMember = memberRepository.save(memberMapper.toMember(dto));
        return memberMapper.toMemberResponseDto(savedMember);
    }

    public List<MemberResponseDto> findMembers() {
        return memberRepository.findAllByIsAvailableTrue().stream().map(memberMapper::toMemberResponseDto).collect(Collectors.toList());
    }

    public MemberResponseDto findMember(Integer id){
        Member member = memberRepository.findByIdAndIsAvailableTrue(id).orElseThrow(()->new MemberNotFoundException("Invalid User with Id: " + id));
        return memberMapper.toMemberResponseDto(member);
    }

    public MemberResponseDto updateMember(Integer id, MemberDto dto) {
        Member member = memberRepository.findByIdAndIsAvailableTrue(id).orElseThrow(()-> new MemberNotFoundException("Invalid User with Id: " + id));
        Member checkEmailDuplicate = memberRepository.findByEmail(dto.email());
        if(checkEmailDuplicate != null && !Objects.equals(checkEmailDuplicate.getId(), id)) {
            throw new DuplicateEmailException("Email cannot be duplicated.");
        }
        Member checkPhoneNumberDuplicate = memberRepository.findByPhone(dto.phone());
        if(checkPhoneNumberDuplicate != null && !Objects.equals(checkPhoneNumberDuplicate.getId(), id)){
            throw new DuplicateEmailException("Phone Number cannot be duplicated.");
        }
        member.setName(dto.name());
        member.setEmail(dto.email());
        member.setPhone(dto.phone());
        Member savedMember = memberRepository.save(member);
        return memberMapper.toMemberResponseDto(savedMember);
    }

    public void deleteMember(Integer id){
        Member member = memberRepository.findByIdAndIsAvailableTrue(id).orElseThrow(()-> new MemberNotFoundException("Invalid User with Id: " + id));
        member.setAvailable(false);
        memberRepository.save(member);
    }
}
