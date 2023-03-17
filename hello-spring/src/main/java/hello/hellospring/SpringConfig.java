package hello.hellospring;

import hello.hellospring.AOP.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 직접 스프링빈 등록하기
public class SpringConfig {

    /* Jdbc
    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

     */

    /* Jpa
    private final EntityManager em;

    public SpringConfig(EntityManager em) {
        this.em = em;
    }
     */

    //SpringDataJpa
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        //return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }
/*
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

 */
/*
    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
       // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);

    }
 */
}
