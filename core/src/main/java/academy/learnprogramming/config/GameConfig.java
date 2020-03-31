package academy.learnprogramming.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    private int maxNumber=89;
    private int guessCount=8;
    @Bean
    public int maxNumber(){
        return maxNumber;
    }
    @Bean
    public int getGuessCount(){
        return guessCount;
    }
}
