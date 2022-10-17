package Hello.core.singleton;

import Hello.core.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class StateFulServiceTest {

    @Test
    void statefulServiceSingleton(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

        StateFulService stateFulService1 = annotationConfigApplicationContext.getBean(StateFulService.class);
        StateFulService stateFulService2 = annotationConfigApplicationContext.getBean(StateFulService.class);

        //ThreadA : A사용자 10000원 주문
        int userAPrice = stateFulService1.order("userA",10000);

        //ThreadB : B사용자 10000원 주문
        int userBPrice = stateFulService1.order("userB",20000);

        //ThreadA : A사용자 주문금액 조회
//        int price = stateFulService1.getPrice();
        log.info("price="+userAPrice);

//        Assertions.assertThat(stateFulService1.getPrice()).isEqualTo(20000);

    }

    static class  TestConfig{
        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }

}