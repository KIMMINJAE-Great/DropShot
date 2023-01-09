package com.dropshot.backend;

import com.dropshot.backend.entity.Member;
import com.dropshot.backend.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    MemberRepository memberRepository;
//
    @Test
    public void test(){
        String name = "aas";
        Member member = memberRepository.findByUsername(name);
        if(member != null){
        System.out.println(member);

        } else{
            System.out.println("none");
        }

    }
//    @Test
//    public void joinTest() {
//        IntStream.rangeClosed(1, 1).forEach(new IntConsumer() {
//            @Override
//            public void accept(int value) {
//                Member member = Member.builder()
//                        .id("idminjae")
//                        .password(1234)
//                        .email("minjae2717@gmail.com")
//                        .nickname("고고")
//                        .birthday("19940301")
//                        .build();
//                System.out.println(memberRepository.save(member));
//            }
//        });
//    }
//    @Test
//    public void joinMember() {
//        IntStream.rangeClosed(1,1).forEach(new IntConsumer(){
//            LocalDate birthday = LocalDate.of(1994, 3, 1);
//            @Override
//            public void accept(int i) {
//                Member member = Member.builder()
//                        .id("minjae2717" + i)
//                        .password(1234)
//                        .email("minjae2717@gmail.com")
//                        .nickname("과자팔던개발자")
//                        .birthday(birthday)
//                        .build();
//                System.out.println(memberRepository.save(member));
//
//            }
//        });
//    }

}
