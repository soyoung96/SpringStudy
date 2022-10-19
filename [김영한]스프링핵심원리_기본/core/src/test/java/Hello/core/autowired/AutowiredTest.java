package Hello.core.autowired;

import Hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{ //Member는 스프링 빈이 아님

        @Autowired(required = false) //아예 수정자 호출을 안한다!
        public void setNoBean1(Member member1){
            System.out.println("member1"+member1);
        }

        @Autowired//호출은 된다 but 널로 들어옴
        public void setNoBean2(@Nullable Member member2){
            System.out.println("member2"+member2);
        }

        @Autowired //java8 에서 제공 Optional 로 넣어줌
        public void setNoBean3(Optional<Member> member3){
            System.out.println("member3"+member3);
        }

    }
}
