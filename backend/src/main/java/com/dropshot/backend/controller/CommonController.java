package com.dropshot.backend.controller;

import com.dropshot.backend.entity.Member;
import com.dropshot.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CommonController {

    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/api/members")
    public List<Member> getMembers(){
        List<Member> member = memberRepository.findAll();
        System.out.println(member);
        return member;
    }

    @GetMapping("/api/signup")
    public void main(){

    }
}
