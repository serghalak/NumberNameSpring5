package academy.learnprogramming.console;

import academy.learnprogramming.AppConfig;
import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import academy.learnprogramming.NumberGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(Main.class);
    //private static final String CONFIG_LOCATION="bean.xml";

    public static void main(String[] args) {
        log.info("Guess the number Game");
        System.out.println("Main ...........");

        //ConfigurableApplicationContext context=new ClassPathXmlApplicationContext(CONFIG_LOCATION);
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println("Context ...........");
        Game game = context.getBean("game", Game.class);
        System.out.println("game: " + game);
        NumberGenerator numberGenerator = context.getBean( NumberGenerator.class);

        int number=numberGenerator.next();
        log.info("number = {}",number);
        System.out.println("Max Number is: " + numberGenerator.getMaxNumber() + " random number is: " + numberGenerator.next());

        //Game game = context.getBean("game", Game.class);
        MessageGenerator messageGenerator=context.getBean("messageGenerator",MessageGenerator.class);
        log.info("getMainMessage = {}",messageGenerator.getMainMessage());
        log.info("getResultMessage = {}",messageGenerator.getResultMessage());
        //game.reset();move to init method
        context.close();



    }

}
