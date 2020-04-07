package academy.learnprogramming;

import academy.learnprogramming.config.GameConfig;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component("numberGenerator")
@Component
@Slf4j

public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random=new Random();

//    @Autowired
//    @MaxNumber
    @Getter
    private int maxNumber;

//    @Autowired
//    @MinNumber
    @Getter
    private int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber,@MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        return random.nextInt(maxNumber-minNumber)+minNumber;
    }

//    @Override
//    public int getMaxNumber() {
//        return maxNumber;
//    }
//
//    @Override
//    public int getMinNumber() {
//        return minNumber;
//    }
}
