package it.cattolica.genius.score.service;

import it.cattolica.genius.score.dto.Response;
import it.cattolica.genius.score.dto.UserScore;
import it.cattolica.genius.score.dto.UserScoreResponse;
import it.cattolica.genius.score.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import static it.cattolica.genius.score.dto.Response.CodeEnum.OK;

@Component
public class UserService {

    public ResponseEntity<UserScoreResponse> getUserscore(String userId) {
        UserScoreResponse r = new UserScoreResponse();
        UserScore us = new UserScore();
        us.setScore(999d);
        us.setUserId(userId);
        r.setUserScore(us);
        Response resp = new Response();
        resp.setCode(OK);
        resp.setDescription("Success!");
        r.setResponse(resp);
        return ResponseEntity.ok(r);
    }
}
