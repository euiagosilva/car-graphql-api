package com.iagosilva.api.web.graphql;

import com.iagosilva.api.factory.GraphQLSchemaFactory;
import com.iagosilva.api.service.impl.CarServiceImpl;
import graphql.ExecutionInput;
import graphql.ExecutionResult;
import graphql.GraphQL;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarResource {

    private final GraphQL graphQL;

    private final GraphQLSchemaFactory factory;

    @Autowired
    public CarResource(CarServiceImpl service, GraphQLSchemaFactory factory) {
        this.factory = factory;
        graphQL = this.factory.createSchema(service);
    }

    @PostMapping(value = "/graphql", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Map<String, Object> graphql(@RequestBody Map<String, String> request, HttpServletRequest raw) {
        ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
                .query(request.get("query"))
                .operationName(request.get("operationName"))
                .context(raw)
                .build());
        return executionResult.toSpecification();
    }
}