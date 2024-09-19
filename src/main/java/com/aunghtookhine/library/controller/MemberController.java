package com.aunghtookhine.library.controller;

import com.aunghtookhine.library.dto.MemberDto;
import com.aunghtookhine.library.dto.MemberResponseDto;
import com.aunghtookhine.library.service.MemberService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/members")
@AllArgsConstructor
public class MemberController {
    private final MemberService memberServiceImpl;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MemberResponseDto createMember(@Valid @RequestBody MemberDto dto){
        return memberServiceImpl.createMember(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<MemberResponseDto> findMembers(){
        return memberServiceImpl.findMembers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MemberResponseDto findMember(@PathVariable("id") Integer id){
        return memberServiceImpl.findMember(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public MemberResponseDto updateMember(@PathVariable("id") Integer id, @Valid @RequestBody MemberDto dto){
        return memberServiceImpl.updateMember(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") Integer id){
        memberServiceImpl.deleteMember(id);
    }
}
