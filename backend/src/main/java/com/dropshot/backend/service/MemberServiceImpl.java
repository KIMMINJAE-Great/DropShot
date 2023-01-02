package com.dropshot.backend.service;

import com.dropshot.backend.dto.MemberDTO;
import com.dropshot.backend.entity.Member;
import com.dropshot.backend.exception.DuplicateEmailException;
import com.dropshot.backend.exception.DuplicateNicknameException;
import com.dropshot.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public String join(MemberDTO dto) {
        log.info("join..................");

//  dto를 받아 entity로 넘길 Member 타입으로 변환
        Member member = (Member) dtoToEntity(dto);
        log.info("After dtoToEntity......." + member);
        member.setRole("USER");
// 가입일 저장
        LocalDateTime today = LocalDateTime.now();
        member.setModDate(today);
        member.setRegDate(today);
        log.info("moddate........."+member.getModDate());
        log.info("regdate........."+member.getRegDate());
//  memberRepository의 JPA기능을 사용하여 member를 저장
        memberRepository.save(member);
        log.info("Done Join...........");
//        회원가입 성공 후 닉네임을 받아 "getNickname"님 회원가입이 완료되었습니다 생성 준비
        return member.getNickname();
    }

//    final MemberRepository memberRepository;
//    final PasswordEncoder passwordEncoder;
//
//    @Transactional
//    public void saveMember(MemberDTO memberDto) throws Exception {
//        validateDuplicateEmail(memberDto.getEmail(),memberDto.getNickname());
//        memberRepository.save(Member.createMember(
//                memberDto.getEmail(),
//                passwordEncoder.encode(memberDto.getPassword()),
//                memberDto.getNickname()));
//    }
//
//    private void validateDuplicateEmail(String email,String nickname) {
//        //log.info("nickname = " + nickname);
//        if(memberRepository.existsByEmail(email)){
//            throw new DuplicateEmailException();
//        }
//        if(memberRepository.existsByNickname(nickname)){
//            throw new DuplicateNicknameException();
//        }
//    }
}
