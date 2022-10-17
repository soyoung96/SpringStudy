package Hello.core;

import Hello.core.discount.DiscountPolicy;
import Hello.core.discount.FixDiscountPolicy;
import Hello.core.discount.RateDiscountPolicy;
import Hello.core.member.MemberMemoryRepository;
import Hello.core.member.MemberRepository;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import Hello.core.order.OrderService;
import Hello.core.order.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration // 애플리케이션의 설정정보를 담아두는 클래스
public class AppConfig {

    @Bean // 스프링 컨테이너에 등록이 된다.
    public MemberService memberService(){

        log.info("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());//생성자 주입을 통한 DI(의존성 주입)
    }

    @Bean
    public MemberRepository memberRepository() {
        log.info("call AppConfig.memberRepository");
        return new MemberMemoryRepository();
    }

    @Bean
    public OrderService orderService(){
        log.info("call AppConfig.orderService");
        return new OrderServiceImpl(discountPolicy(), memberRepository());//생성자 주입을 통한 DI(의존성 주입)
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
