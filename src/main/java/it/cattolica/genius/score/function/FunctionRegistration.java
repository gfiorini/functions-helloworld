package it.cattolica.genius.score.function;


import it.cattolica.genius.score.dto.UserScoreResponse;
import it.cattolica.genius.score.model.User;
import it.cattolica.genius.score.model.UserDTO;
import it.cattolica.genius.score.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class FunctionRegistration {

    private UserService userService;

    public FunctionRegistration(UserService userService) {
        this.userService = userService;
    }

    @Bean("getUserFunction")
    public Function<String, UserDTO> getUserFunction() {
        return userId -> userService.getUser(userId);
    }

    @Bean("userscore")
    public Function<String, ResponseEntity<UserScoreResponse>> getUserscore() {
        return userId -> userService.getUserscore(userId);
    }



}