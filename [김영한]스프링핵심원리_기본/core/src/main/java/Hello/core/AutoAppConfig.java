package Hello.core;

import Hello.core.member.MemberMemoryRepository;
import Hello.core.member.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class)
)
public class AutoAppConfig {

    @Bean("memberMemoryRepository")
    MemberRepository memberRepository(){
        return new MemberMemoryRepository();
    }


}
