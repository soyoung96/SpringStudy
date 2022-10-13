package Hello.core;

import Hello.core.member.Grade;
import Hello.core.member.Member;
import Hello.core.member.MemberService;
import Hello.core.member.MemberServiceImpl;
import Hello.core.order.Order;
import Hello.core.order.OrderService;
import Hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(memberRepository);
//        OrderService orderService = new OrderServiceImpl(discountPolicy, memberRepository);

//        AppConfig appConfig = new AppConfig();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService",OrderService.class);
//
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        Long memeberId = 1L;
        Member member = new Member(memeberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memeberId,"itemA",10000);

        System.out.println("order = "+order);
        System.out.println("order.calculatePrice()="+order.calculatePrice());
    }
}
