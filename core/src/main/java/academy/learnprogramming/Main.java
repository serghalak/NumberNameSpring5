package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);
    private static final String CONFIG_LOCATION="bean.xml";

    public static void main(String[] args) {
        log.info("Guess the number Game");
        System.out.println("Main ...........");

        ConfigurableApplicationContext context=new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        NumberGenerator numberGenerator = context.getBean("numberGenerator", NumberGenerator.class);

        int number=numberGenerator.next();
        log.info("number = {}",number);
        System.out.println("Max Number is: " + numberGenerator.getMaxNumber() + " random number is: " + numberGenerator.next());

        Game game = context.getBean("game", Game.class);
        //game.reset();move to init method
        context.close();

    }

}
