package com.example.hellospring;

import com.example.hellospring.repository.JpaMemberRepository;
import com.example.hellospring.repository.MemberRepository;
import com.example.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/*
 service, repository 어노테이션 사용하는 대신 직접 config 설정해서 spring bean 설정하는 방법
 @Service, @Repository 지우고 써야함
 @Controller 는 직접 등록하지말고 어노테이션 그대로 사용
*/
@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    private final EntityManager em;
    public SpringConfig(DataSource dataSource, EntityManager em){
        this.dataSource = dataSource;
        this.em = em;
    }
    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean // 얘는 주석 처리해도 돌아감 왜지?
    public MemberRepository memberRepository(){
        //return new JdbcMemberRepository(dataSource);
        //return new MemoryMemberRepository();
//        return new JdbcTemplateMemberRepository(dataSource);
    return new JpaMemberRepository(em);
    }
}
