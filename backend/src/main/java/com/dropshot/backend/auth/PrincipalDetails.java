package com.dropshot.backend.auth;
//시큐리티가 /login 줏소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인을 진행이 완료되면 시큐리티 session을 만들어준다.(Security ContextHolder)
// Holder에 들어가는 객체가 정해져 있는데 이것이 Authentication 타입 객체
// Authentication안에 User(Member) 정보가 있어야한다.
// User오브젝트타입 => UserDetails 타입 객체

// Session 안에=> Authentication 있어야하고 그 안에는 => UserDetails(PrincipalDetails) 타입 이어야한다.

import com.dropshot.backend.entity.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

    private Member member; //컴포지션

    public PrincipalDetails(Member member){
        this.member = member;
    }
    // 해당 유저의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return member.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return member.getPassword();
    }

    @Override
    public String getUsername() {
        return member.getUsername();
    }
// 계정이 만료됐는지
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
//계정이 잠겼니
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
//계정의 비밀번호가 기간이 지났는지
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
// 계정이 활성화 되어있는지
    @Override
    public boolean isEnabled() {

        // ex)  사이트에서 1년 동안 로그인을 안하면 휴면 계정이 되는데 그러려면 Member에 loginDate를 추가시켜주어 계산해야한다.
        return true;
    }
}
