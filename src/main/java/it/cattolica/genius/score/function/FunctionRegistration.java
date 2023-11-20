package it.cattolica.genius.score.function;


import it.cattolica.genius.score.model.UserDTO;
import it.cattolica.genius.score.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class FunctionRegistration {

    private UserService userService;

    public FunctionRegistration(UserService userService) {
        this.userService = userService;
    }

    @Bean
    public Function<UserDTO, String> createUserFunction() {
        return user -> userService.saveUser(user);
    }

    @Bean
    public Function<String, UserDTO> getUserFunction() {
        return userId -> userService.getUser(userId);
    }


//    @Component
//    public class Hello implements Function<Mono<User>, Mono<Greeting>> {
//
//        public Mono<Greeting> apply(Mono<User> mono) {
//            return mono.map(user -> new Greeting("Hello, " + user.getFirstName() + "!\n"));
//        }
//    }

}