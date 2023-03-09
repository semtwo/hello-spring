package com.example.hellospring;

import com.example.hellospring.aop.TimeTraceAop;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 service, repository 어노테이션 사용하는 대신 직접 config 설정해서 spring bean 설정하는 방법
 @Service, @Repository 지우고 써야함
 @Controller 는 직접 등록하지말고 어노테이션 그대로 사용
*/
@Configuration
public class SpringConfig {
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }
    //AOP가 해당 메서드는 예외하도록 Around에 조건을 걸어야함
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }
}
