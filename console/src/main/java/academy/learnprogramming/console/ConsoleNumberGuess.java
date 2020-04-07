package academy.learnprogramming.console;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Slf4j
public class ConsoleNumberGuess /*implements ApplicationListener<ContextRefreshedEvent>*/{
    //private static final Logger log= LoggerFactory.getLogger(ConsoleNumberGuess.class);

    //@Autowired
    private Game game;

    //@Autowired
    private MessageGenerator messageGenerator;

    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    //@Override
    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationEvent(/*ContextRefreshedEvent contextRefreshedEvent*/) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>Container is ready for use");
        log.info(">>>>>>>>>>>>>>>>>>>>>>>Container is ready for use");
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int guess=scanner.nextInt();
            scanner.nextLine();
            game.setGuess(guess);
            game.check();
            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("play again y/n?");
                String playAgainString=scanner.nextLine().trim();
                if(!playAgainString.equalsIgnoreCase("y")){
                    break;
                }
                game.reset();
            }
        }

    }
}
