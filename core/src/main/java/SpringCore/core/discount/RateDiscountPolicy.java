package SpringCore.core.discount;

import SpringCore.core.member.Grade;
import SpringCore.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy{

    private int discountPercent = 10;
    @Override
    public int Discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price*discountPercent/100;
        }else{
            return 0;
        }
    }
}
