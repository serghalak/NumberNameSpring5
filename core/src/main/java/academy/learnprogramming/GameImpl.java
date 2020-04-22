package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component("game")
@Component
@Slf4j
@Getter
public class GameImpl implements Game {

    //private static final Logger log= LoggerFactory.getLogger(GameImpl.class);

    //@Autowired
    @Getter(AccessLevel.NONE)
    private NumberGenerator numberGenerator;
    //@Autowired
    //@GuessCount
    private int guessCount;
    //@Autowired
    //@MaxNumber
    private int number;
    @Setter
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;

    }


    //@Autowired
//    public GameImpl(NumberGenerator numberGenerator) {
//        System.out.println(">>>>>>>>>>>GameImpl constructor(NumberGenerator)");
//        this.numberGenerator = numberGenerator;
//    }

//    @Override
//    public int getNumber() {
//        return number;
//    }
//
//    @Override
//    public int getGuess() {
//        return guess;
//    }

//    @Override
//    public void setGuess(int guess) {
//        this.guess=guess;
//    }

//    @Override
//    public int getSmallest() {
//        return smallest;
//    }
//
//    @Override
//    public int getBiggest() {
//        return biggest;
//    }
//
//    @Override
//    public int getRemainingGuesses() {
//        return remainingGuesses;
//    }
//
//    @Override
//    public int getGuessCount() {
//        return guessCount;
//    }

    @Override
    @PostConstruct
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug(">>>>>>>>>>>the number is {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("<<<<<<<<<<<<<<<In game preDestroy()");
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if(validNumberRange){
            if(guess>number){
                biggest=guess-1;
            }
            if(guess<number){
                smallest=guess+1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess==number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses<=0 ;
    }

    private void checkValidNumberRange(){
        validNumberRange=(guess>=smallest) && (guess<=biggest);
    }
}
