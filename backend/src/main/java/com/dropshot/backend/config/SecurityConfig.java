package com.dropshot.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity // 스프링 시큐리티 필터가 스프링 필터체인에 등록이 된다.
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true) // securedEnabled = true secured 어노테이션 활성화 /info참고 ,, prePostEnabled = preAuthorize 어노테이션 활성화
public class SecurityConfig {
//빈어노테이션을 적으면  해당 메서드의 리턴되는 오브젝트를 IOC로 등록해줌
    @Bean
    public BCryptPasswordEncoder encodePwd() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated()
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login") // /login이라는 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행해준다. so 컨트롤로에서 따로 만들필요가 없어진다.
//                .defaultSuccessUrl("/") // 로그인이 완료되면 메인페이지로 가게 만든다.  //23.01.09 작동안함 그래서 Vue의 router.push사용


                ;




        return http.build();
    }
}
