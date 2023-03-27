package SpringCore.core.order;

import SpringCore.core.discount.DiscountPolicy;
import SpringCore.core.discount.FixedDiscountPolicy;
import SpringCore.core.discount.RateDiscountPolicy;
import SpringCore.core.member.Member;
import SpringCore.core.member.MemberRepository;
import SpringCore.core.member.MemberService;
import SpringCore.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    /*
     DIP와 OCP를 위반하는 코드
     */
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixedDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    /* 생성자 주입 (lombok requiredargsConstructor를 쓰면 생성자를 알아서 만들어준다)
    //@Autowired 생성자가 하나만 있을 때는 스프링 빈일 시 Autowired 생략 가능!!
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
     */

    /**
     *  생성자 주입은 객체를 생성할 때 무조건 생성자를 호출하기 때문에 거의 동시에 일어난다고 볼 수 있다.
     *  만약 setter로 주입하는 코드를 만들면 첫번째는 생성자 주입 두번째는 setter주입이 된다.
     */

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.Discount(member,itemPrice);

        return new Order(memberId, itemName,itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
