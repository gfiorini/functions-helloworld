package it.cattolica.genius.score.function;


import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import it.cattolica.genius.score.model.Greeting;
import it.cattolica.genius.score.model.User;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

public class HelloFunction extends FunctionInvoker<User, Greeting> {

    @FunctionName("hello")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<User>> request,
            ExecutionContext context) {
        User user = request.getBody()
                .filter((u -> u.getFirstName() != null))
                .orElseGet(User::new);
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(user, context))
                .header("Content-Type", "application/json")
                .build();
    }
}
