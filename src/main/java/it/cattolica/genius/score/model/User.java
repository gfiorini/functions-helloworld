package it.cattolica.genius.score.model;

import lombok.*;

import java.time.ZonedDateTime;



@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class User {


    private String userId;
    private String lastName;
    private String firstName;
    private String email;
    private ZonedDateTime createdOn;
}
