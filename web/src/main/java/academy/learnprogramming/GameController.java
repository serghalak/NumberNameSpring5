package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import academy.learnprogramming.service.GameService;

@Slf4j
@Controller
public class GameController {

    private GameService gameService;

}
