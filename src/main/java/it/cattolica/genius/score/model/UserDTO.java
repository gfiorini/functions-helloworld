package it.cattolica.genius.score.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class UserDTO {

    String userId;
    String lastName;
    String firstName;
    String email;
}


