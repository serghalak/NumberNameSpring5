package academy.learnprogramming;

import academy.learnprogramming.config.GameConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

//@Component("numberGenerator")
public class NumberGeneratorImpl implements NumberGenerator {

    private final Random random=new Random();

    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;

    @Override
    public int next() {
        return random.nextInt(maxNumber-minNumber)+minNumber;
    }

    @Override
    public int getMaxNumber() {
        return maxNumber;
    }

    @Override
    public int getMinNumber() {
        return minNumber;
    }
}
