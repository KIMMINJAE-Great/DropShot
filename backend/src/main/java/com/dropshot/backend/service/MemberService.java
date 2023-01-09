package com.dropshot.backend.service;

import com.dropshot.backend.dto.MemberDTO;
import com.dropshot.backend.entity.Member;

public interface MemberService {
    String join(MemberDTO dto);
//    String login(Member member);

    default Member dtoToEntity(MemberDTO dto) {
        Member member = Member.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .birthday(dto.getBirthday())
                .build();
        return member;
    }
    default MemberDTO entityToDTO(Member member) {
        MemberDTO dto = MemberDTO.builder()
                .username(member.getUsername())
                .email(member.getEmail())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .birthday(member.getBirthday())
                .build();
        return dto;
    }



}
