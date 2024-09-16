package com.aunghtookhine.library.Controller;

import com.aunghtookhine.library.Dto.MemberDto;
import com.aunghtookhine.library.Dto.MemberResponseDto;
import com.aunghtookhine.library.Model.Member;
import com.aunghtookhine.library.Service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {
    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public MemberResponseDto createMember(@Valid @RequestBody MemberDto dto){
        return memberService.createMember(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<MemberResponseDto> findMembers(){
        return memberService.findMembers();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public MemberResponseDto findMember(@PathVariable("id") Integer id){
        return memberService.findMember(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    public MemberResponseDto updateMember(@PathVariable("id") Integer id, @Valid @RequestBody MemberDto dto){
        return memberService.updateMember(id, dto);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable("id") Integer id){
        memberService.deleteMember(id);
    }
}
