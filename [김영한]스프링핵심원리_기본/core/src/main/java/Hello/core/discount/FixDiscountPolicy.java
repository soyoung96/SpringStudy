package Hello.core.discount;

import Hello.core.member.Grade;
import Hello.core.member.Member;

public class FixDiscountPolicy implements  DiscountPolicy{
    private int discountAmount = 1000;//1000원 할인

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountAmount;
        }else{
            return 0;
        }
    }
}
