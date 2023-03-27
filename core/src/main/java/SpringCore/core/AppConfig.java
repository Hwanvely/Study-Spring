package SpringCore.core;

import SpringCore.core.discount.DiscountPolicy;
import SpringCore.core.discount.FixedDiscountPolicy;
import SpringCore.core.discount.RateDiscountPolicy;
import SpringCore.core.member.MemberRepository;
import SpringCore.core.member.MemberService;
import SpringCore.core.member.MemberServiceImpl;
import SpringCore.core.member.MemoryMemberRepository;
import SpringCore.core.order.OrderService;
import SpringCore.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    /*생성자 주입 방식
    public MemberService memberService(){
        return new MemberServiceImpl( new MemoryMemberRepository());
    }
    이렇게 하면 역할이 정확하게 구분이 안된다.
     */

    // @Bean memberService -->  new MemoryMemberRepository()
    // @Bean OrderService --> new MemoryMemberRepository()
    @Bean
    public MemberService memberService(){
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    /*
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), new FixedDiscountPolicy());
    }
    이것도 역할을 구분해주자
     */
    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixedDiscountPolicy();
        return new RateDiscountPolicy();

    }
}
