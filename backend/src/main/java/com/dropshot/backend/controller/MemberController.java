package com.dropshot.backend.controller;

import com.dropshot.backend.dto.MemberDTO;
import com.dropshot.backend.entity.Member;
import com.dropshot.backend.repository.MemberRepository;
import com.dropshot.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;

//@RestController
//@RequiredArgsConstructor
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;
    @Autowired
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    MemberRepository memberRepository;


    @GetMapping("/user")
    public @ResponseBody String user() {
        return "user";
    }

    @GetMapping("/admin")
    public @ResponseBody String admin() {
        return "admin";
    }

    @GetMapping("/manager")
    public @ResponseBody String manager() {
        return "manager";
    }

    //    스프링 시큐리티에서 /login을 낚아챔 but SecurityConfig파일 생성후 못 낚아챔
    @GetMapping("/login")
    public String login() {
        System.out.println("Spring GetMapping.....login.........");
        return "index";
    }
    @Secured("ROLE_ADMIN") //특정메서드에 간단하게 권한인증을 사용하기 위한방법
    @GetMapping("/info")
    public @ResponseBody String info(){
        return "개인정보";
    }
//    @PostAuthorize( ) data()가 종료되고 난 뒤 걸림 securityConfig에서 postAuthorize 필요
    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')") // data()가 실행되기 직전에 실행이 된다. @Secured는 하나 @PreAuthorize두개 이상 할때 사용
    @GetMapping("/data")
    public @ResponseBody String data(){
        return "데이터정보";
    }


//    @PostMapping("/login")
//    public String loginPost() {
//        System.out.println("Spring GetMapping.....Post login.........");
//        return "index";
//    }


    @GetMapping("/join")
    public String join() {
        System.out.println("Spring GetMapping.....join.........");
        return "index";
    }

//    @PostMapping("/joinproc")
//    public String joinProc(Member member) {
//        System.out.println("member..........."+member);
//        member.setRole("ROLE_USER");
//        String password = member.getPassword();
//        String ecnPassword = bCryptPasswordEncoder.encode(password);
//        member.setPassword(ecnPassword);
//
//        memberRepository.save(member);
//        return "index";
//    }
//    @PostMapping("/joinrroc")
//    public ResponseEntity joinProc(@ResponseBody Member member,
//                                   HttpServletResponse res ) {
//        member.setRole("ROLE_USER");
//        String rawPassword = member.getPassword();
//        String ecnPassword = bCryptPasswordEncoder.encode(rawPassword);
//        member.setPassword(ecnPassword);
//
//        memberRepository.save(member);
//        return "index";
//    }

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    //회원가입 요철
    @PostMapping("/joinproc")
    public ResponseEntity signup(@RequestBody MemberDTO params,
                                 HttpServletResponse res) {

        String nickName = memberService.join(params);

        return new ResponseEntity(nickName, HttpStatus.OK);


    }
    @GetMapping({"/", ""})
    public String index() {
        return "index";
    }



//    @PostMapping("/joinproc")
//    public ResponseEntity signup(@RequestBody MemberDTO params,
//                                 HttpServletResponse res) {
//
//        boolean existMember = memberRepository.existsById(params.getId());
//        System.out.println("existMember.........."+existMember);
//        if (existMember == true){
//            return new ResponseEntity(params.getId(), HttpStatus.BAD_REQUEST);
//
//        } if (existMember != true){
//
//        String nickName = memberService.join(params);
//
//        return new ResponseEntity(nickName, HttpStatus.OK);
//        }
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//    }


    //    @PostMapping("/api/account/login")
//    public ResponseEntity login(@RequestBody Map<String, String> params,
//                                HttpServletResponse res) {
//        Member member = memberRepository.findByIdAndPassword(params.get("id"), params.get("password"));
//
//
//        if (member != null) {
//            int forSessionId = 1;
//
//            String token = jwtService.getToken("forSessionId", forSessionId);
//
//            Cookie cookie = new Cookie("token", token);
//            // 자바스크립트로 접근을 불허 옵션
//            cookie.setHttpOnly(true);
//            cookie.setPath("/");
//
//            res.addCookie(cookie);
//            return new ResponseEntity<>(forSessionId, HttpStatus.OK);
//        }
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
//
//
//    }
//    @GetMapping("/api/account/check")
//    public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {
//        Claims claims = jwtService.getClaims(token);
//
//        if (claims != null) {
//            int id = Integer.parseInt(claims.get("id").toString());
//            return new ResponseEntity<>(id, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(null, HttpStatus.OK);
//
//    }



}