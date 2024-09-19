package com.aunghtookhine.library.service.implementation;

import com.aunghtookhine.library.dto.MemberDto;
import com.aunghtookhine.library.dto.MemberResponseDto;
import com.aunghtookhine.library.exception.BookLeftToReturnException;
import com.aunghtookhine.library.exception.DuplicateEmailException;
import com.aunghtookhine.library.exception.DuplicatePhoneNumberException;
import com.aunghtookhine.library.exception.MemberNotFoundException;
import com.aunghtookhine.library.mapper.MemberMapper;
import com.aunghtookhine.library.entity.Member;
import com.aunghtookhine.library.entity.Record;
import com.aunghtookhine.library.repository.MemberRepository;
import com.aunghtookhine.library.repository.RecordRepository;
import com.aunghtookhine.library.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;
    private final RecordRepository recordRepository;

    @Override
    public MemberResponseDto createMember(MemberDto dto){
        Member checkEmailDuplicate = memberRepository.findByEmail(dto.email());
        if(checkEmailDuplicate != null) throw new DuplicateEmailException("Email cannot be duplicated.");
        Member checkPhoneNumberDuplicate = memberRepository.findByPhone(dto.phone());
        if(checkPhoneNumberDuplicate != null) throw new DuplicatePhoneNumberException("Phone Number cannot be duplicated.");
        Member savedMember = memberRepository.save(memberMapper.toMember(dto));
        return memberMapper.toMemberResponseDto(savedMember);
    }

    @Override
    public List<MemberResponseDto> findMembers() {
        return memberRepository.findAllByIsAvailableTrue().stream().map(memberMapper::toMemberResponseDto).collect(Collectors.toList());
    }

    @Override
    public MemberResponseDto findMember(Integer id){
        Member member = memberRepository.findByIdAndIsAvailableTrue(id).orElseThrow(()->new MemberNotFoundException("Invalid User with Id: " + id));
        return memberMapper.toMemberResponseDto(member);
    }

    @Override
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

    @Override
    public void deleteMember(Integer id){
        Member member = memberRepository.findByIdAndIsAvailableTrue(id).orElseThrow(()-> new MemberNotFoundException("Invalid User with Id: " + id));
        List<Record> records = recordRepository.findAllByMemberIdAndReturnDateNull(id);
        if(!records.isEmpty()){
            throw new BookLeftToReturnException("You haven't returned your books yet.");
        }
        member.setAvailable(false);
        memberRepository.save(member);
    }
}
