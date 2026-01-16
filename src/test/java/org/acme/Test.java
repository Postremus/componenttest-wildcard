package org.acme;

import jakarta.inject.Inject;

import io.quarkus.test.component.QuarkusComponentTest;

@QuarkusComponentTest
public class Test {
    @Inject
    GreetingResource greetingResource;

    @org.junit.jupiter.api.Test
    public void test() {
        String result = greetingResource.hello();
        org.junit.jupiter.api.Assertions.assertEquals("HELLO WORLD", result);
    }
}
