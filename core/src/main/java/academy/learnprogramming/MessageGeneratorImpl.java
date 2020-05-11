package academy.learnprogramming;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator {

    //private static final Logger log= LoggerFactory.getLogger(MessageGeneratorImpl.class);

    private static final String MAIN_MESSAGE="game.main.message";

    //@Autowired
    private Game game;
   //private int guessCount=10;
    private MessageSource messageSource;

    @Autowired
    public MessageGeneratorImpl(Game game,MessageSource messageSource) {
        this.game = game;
        this.messageSource=messageSource;
    }

    @PostConstruct
    public void init(){
        log.info("game = {}",game);
    }

    @Override
    public String getMainMessage() {
        //return "getMainMessage() called";
        return getMessage(MAIN_MESSAGE
                ,game.getSmallest(),game.getBiggest());
//        return "number is between " +
//                game.getSmallest() + " and "+
////                game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){
            return "You guessed it! The number was " + game.getNumber();
        }else if(game.isGameLost()){
            return "You lost The number was " + game.getNumber();
        }else if (!game.isValidNumberRange()){
            return "Invalid number range!";
        }else if(game.getRemainingGuesses() == game.getGuessCount()){
            return "What is your first guess?";
        }else{
            String direction="Lower";
            if(game.getGuess() < game.getNumber()){
                direction="Higher";
            }
            return direction + "! You have " + game.getRemainingGuesses()
                    + " guess left";
        }
        //return "getResultMessage() called";
    }

    private String getMessage(String code,Object ... args){
        return messageSource.getMessage(code,args, LocaleContextHolder.getLocale());
    }
}
