package SpringCore.core;

import SpringCore.core.member.Grade;
import SpringCore.core.member.Member;
import SpringCore.core.member.MemberService;
import SpringCore.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
        /* 스프링으로 전환
          AppConfig appConfig = new AppConfig();
          MemberService memberService = appConfig.memberService();
         */
        //  MemberService memberService = new MemberServiceImp(); DIP 위반
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA" , Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
