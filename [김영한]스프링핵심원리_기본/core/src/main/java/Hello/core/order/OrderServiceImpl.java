package Hello.core.order;

import Hello.core.annotation.MainDiscountPolicy;
import Hello.core.discount.DiscountPolicy;
import Hello.core.member.Member;
import Hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements  OrderService{

//    @Autowired(required = false) //선택+ 변경 가능 수정자 주입 DI
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        System.out.println("discountPolicy = "+discountPolicy);
//        this.discountPolicy = discountPolicy;
//    }
//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        System.out.println("memberRepository = "+memberRepository);
//        this.memberRepository = memberRepository;
//    }

    //    private final MemberRepository memberRepository = new MemberMemoryRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //할인 정책 바꾸려면 이렇게 OrderService을 바꿔야함
//    //추상에만 의존해야하는게 구체 클래스에도 의존했다...
    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    @Autowired
    public OrderServiceImpl(@MainDiscountPolicy DiscountPolicy discountPolicy, MemberRepository memberRepository) {

        System.out.println("OrderServiceImpl");
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member =memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);

    }

    //테스트 용도
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}
