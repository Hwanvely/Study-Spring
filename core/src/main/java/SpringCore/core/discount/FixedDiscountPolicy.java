package SpringCore.core.discount;

import SpringCore.core.member.Grade;
import SpringCore.core.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount =1000;

    @Override
    public int Discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }else {
            return 0;
        }
    }
}
