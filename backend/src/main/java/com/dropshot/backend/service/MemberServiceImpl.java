package com.dropshot.backend.service;

import com.dropshot.backend.dto.MemberDTO;
import com.dropshot.backend.entity.Member;
import com.dropshot.backend.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Log4j2
public class MemberServiceImpl implements MemberService {

    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MemberRepository memberRepository;


//회원 가입 Service
    @Transactional
    @Override
    public String join(MemberDTO dto) {


        log.info("join..................");

//  dto를 받아 entity로 넘길 Member 타입으로 변환
        Member member = (Member) dtoToEntity(dto);
        log.info("After dtoToEntity......." + member);
        member.setRole("ROLE_USER");
// 가입일 저장
        LocalDateTime today = LocalDateTime.now();
        member.setModDate(today);
        member.setRegDate(today);
        log.info("moddate........." + member.getModDate());
        log.info("regdate........." + member.getRegDate());
//비밀번호 암호화
        String encodePassword = bCryptPasswordEncoder.encode(member.getPassword());
        member.setPassword(encodePassword);
//  memberRepository의 JPA기능을 사용하여 member를 저장
        memberRepository.save(member);
        log.info("Done Join...........");
//        회원가입 성공 후 닉네임을 받아 "getNickname"님 회원가입이 완료되었습니다 생성 준비
        return member.getNickname();
    }

//    Login, 로그인 Service


//
//    @Override
//    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
//        Member member = memberRepository.findById(id)
//                .orElseThrow(()-> new UsernameNotFoundException("등록되지 않은 사용자 입니다"));
//
//        return new UserDetailsImpl(member);
//    }
}
