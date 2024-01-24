package com.ttrzcinski.rest.java;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HellOnWorldFunTest {

    private final HellApp app = new HellApp();

    @Test
    public void GET_hell_on_world_as_200() {
        // Arrange
        int tested_port = HellApp.HELLAPP_DEFAULT_PORT;
        String tested_url = String.format("http://localhost:%d/", tested_port);
        app.start(tested_port);
        // Act
        HttpResponse<String> response = Unirest.get(tested_url).asString();
        // Assert
        assertThat(response != null).isTrue();
        assertThat(response.getStatus()).isEqualTo(200);
	    assertThat(response.getBody()).isEqualTo("Hell-On-World");
        // Clean after
	    app.stop();
    }

}
