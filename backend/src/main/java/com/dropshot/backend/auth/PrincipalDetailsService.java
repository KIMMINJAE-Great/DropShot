package com.dropshot.backend.auth;

import com.dropshot.backend.entity.Member;
import com.dropshot.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//시큐리티 설정에서 loginprocessingUrl("/login)
// /login 요청이 오면 자동으로 UserDetailsService타입으로 Ioc 되어 있는 loadByUsername 함수가 실행

@Service
public class PrincipalDetailsService implements UserDetailsService {
    @Autowired
    private MemberRepository memberRepository;

// 시큐리티 세션 내부의 authentication내부에 UserDetails 들어간다
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member memberEntity = memberRepository.findByUsername(username);
         System.out.println("username from PrincipalDetailsService>>>>>>>>>>>>>>>>>>>>"+ memberEntity);
        if (memberEntity != null) {
            return new PrincipalDetails(memberEntity);
        }
        return null;
    }

    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//    Member memberEntity = memberRepository.findByUsername(username);
//
//    PrincipalDetails userDetail = null;
//    if(memberEntity != null){
//        PrincipalDetails userDetails= new PrincipalDetails();
//            userDetails.setMember(memberEntity);
//            return userDetails;
//        }
//        throw new
//                UsernameNotFoundException("User not exist with name :" +username);
//
//    }
