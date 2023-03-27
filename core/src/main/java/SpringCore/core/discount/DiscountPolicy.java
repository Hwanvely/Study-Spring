package SpringCore.core.discount;

import SpringCore.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int Discount(Member member, int price);
}
