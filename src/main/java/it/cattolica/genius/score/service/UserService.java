package it.cattolica.genius.score.service;

import it.cattolica.genius.score.model.User;
import it.cattolica.genius.score.model.UserDTO;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UserService {


    public String saveUser(UserDTO user) {
        return user.getUserId();
    }

    public UserDTO getUser(String userId) {
        return UserDTO.builder().userId(userId).build();
    }



}
