package academy.learnprogramming;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan(basePackages = "academy.learnprogramming")
@Configuration
public class AppConfig {

    @Bean
    public Game game(){
        return new GameImpl();
    }

    @Bean
    public NumberGenerator numberGenerator(){
        return new NumberGeneratorImpl();
    }

    @Bean
    public MessageGenerator messageGenerator(){
        return new MessageGeneratorImpl() ;
    }
}
