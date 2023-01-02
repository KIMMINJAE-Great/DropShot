package com.dropshot.backend.service;

import com.dropshot.backend.dto.MemberDTO;
import com.dropshot.backend.entity.Member;
import com.dropshot.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface MemberService {
    String join(MemberDTO dto);

    default Member dtoToEntity(MemberDTO dto) {
        Member member = Member.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .nickname(dto.getNickname())
                .birthday(dto.getBirthday())
                .build();
        return member;
    }
    default MemberDTO entityToDTO(Member member) {
        MemberDTO dto = MemberDTO.builder()
                .id(member.getId())
                .email(member.getEmail())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .birthday(member.getBirthday())
                .build();
        return dto;
    }



}
