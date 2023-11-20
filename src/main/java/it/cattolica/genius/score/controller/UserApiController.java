package it.cattolica.genius.score.controller;

import it.cattolica.genius.score.dto.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.request.NativeWebRequest;

import static it.cattolica.genius.score.dto.Response.CodeEnum.OK;

//@Controller

public class UserApiController implements UserApi {

    private final NativeWebRequest request;

    //@Autowired
    public UserApiController(NativeWebRequest request) {
        this.request = request;
    }


    @Override
    public ResponseEntity<UserScoreResponse> userScore(String userId) throws Exception {
        UserScoreResponse r = new UserScoreResponse();
        UserScore us = new UserScore();
        us.setScore(1d);
        us.setUserId(userId);
        r.setUserScore(us);
        Response resp = new Response();
        resp.setCode(OK);
        resp.setDescription("Success!");
        r.setResponse(resp);
        return ResponseEntity.ok(r);

    }

    @Override
    public ResponseEntity<UserScoreQueryResponse> userScoreQuery(UserScoreQueryRequest userScoreQueryRequest) throws Exception {
        return null;
    }
}
