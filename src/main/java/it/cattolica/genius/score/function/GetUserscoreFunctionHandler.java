package it.cattolica.genius.score.function;

import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import it.cattolica.genius.score.model.UserDTO;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

public class GetUserscoreFunctionHandler extends FunctionInvoker<String, UserDTO> {
    @FunctionName("userscore")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            ExecutionContext context) {
        String userId = request.getQueryParameters().get("userId");
        // TODO: gestire il caso in cui userId is null
        context.getLogger().info(userId);

        // handleRequest cerca tra i component un bean che si chiama "userscore"
        // e usa quello per applicare la logica di business

        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(userId, context))
                .header("Content-Type", "application/json")
                .build();
    }

/*
    @FunctionName("createUserFunction")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "request", methods = {HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<UserDTO>> request,
            ExecutionContext context) {
        Optional<UserDTO> user = request.getBody();

        user.ifPresent(u -> context.getLogger().info(u.toString()));
        context.getLogger().info(context.getFunctionName());

        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(user.get(), context))
                .header("Content-Type", "application/json")
                .build();
    }
 */
}
