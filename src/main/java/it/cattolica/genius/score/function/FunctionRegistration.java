package it.cattolica.genius.score.function;


import it.cattolica.genius.score.model.User;
import it.cattolica.genius.score.model.UserDTO;
import it.cattolica.genius.score.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class FunctionRegistration {

    /*
        il nome del bean deve essere uguale al nome della function a meno di mettere un qualifier al bean,
        ad es:

        @Bean("userscore")
        public Function<String, UserDTO> aaaaaa() {
            return userId -> userService.getUser(userId);
        }

     */
    private UserService userService;

    public FunctionRegistration(UserService userService) {
        this.userService = userService;
    }

    @Bean("getUserFunction")
    public Function<String, UserDTO> getUserFunction() {
        return userId -> userService.getUser(userId);
    }

    @Bean("userscore")
    public Function<String, UserDTO> getUserscore() {
        return userId -> userService.getUser(userId);
    }


}