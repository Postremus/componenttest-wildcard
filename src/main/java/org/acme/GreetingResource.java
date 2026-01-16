package org.acme;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import io.quarkus.arc.All;

@Path("/hello")
public class GreetingResource {

    @Inject
    @All
    List<WildcardComponent<?>> components;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return executeComponents("hello world").toString();
    }

    public Object executeComponents(Object input) {
        Object result = input;
        for (WildcardComponent<?> component : components) {
            result = ((WildcardComponent<Object>)component).dosth(result);
        }
        return result;
    }

    @ApplicationScoped
    public static class StringWildcardComponent implements WildcardComponent<String> {

        @Override
        public String dosth(String t) {
            return t.toUpperCase();
        }
    }
}
