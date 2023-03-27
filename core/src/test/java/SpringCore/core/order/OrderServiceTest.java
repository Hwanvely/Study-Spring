package SpringCore.core.order;

import SpringCore.core.AppConfig;
import SpringCore.core.member.Grade;
import SpringCore.core.member.Member;
import SpringCore.core.member.MemberService;
import SpringCore.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class OrderServiceTest {
//    MemberService memberService = new MemberServiceImpl(memberRepository);
//    OrderService orderService = new OrderServiceImpl();

    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){

        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        //then
        Assertions.assertThat(itemA.getDiscountPrice()).isEqualTo(1000);

    }
}
