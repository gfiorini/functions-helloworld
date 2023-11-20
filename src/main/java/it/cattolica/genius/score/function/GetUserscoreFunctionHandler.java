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
        if (userId == null){
            userId = "";
        }

        context.getLogger().info(userId);
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(userId, context))
                .header("Content-Type", "application/json")
                .build();
    }
}
