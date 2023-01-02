package com.dropshot.backend.controller;

import com.dropshot.backend.dto.MemberDTO;
import com.dropshot.backend.entity.Member;
import com.dropshot.backend.repository.MemberRepository;
import com.dropshot.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MemberController {

    @Autowired
    private final MemberService memberService;
//    final PasswordEncoder passwordEncoder;

//    @PostMapping("/api/member")
//    public String saveMember(@RequestBody @Valid MemberDto memberDto) throws Exception{
//        memberService.saveMember(memberDto);
//        return "success";
//    }

    @Autowired
    MemberRepository memberRepository;


    @PostMapping("/api/account/signup")
    public ResponseEntity signup(@RequestBody MemberDTO params,
                                 HttpServletResponse res){

        String nickName = memberService.join(params);

        return new ResponseEntity(nickName, HttpStatus.OK);
    }

}
