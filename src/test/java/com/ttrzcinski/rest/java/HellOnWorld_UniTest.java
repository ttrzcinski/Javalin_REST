package com.ttrzcinski.rest.java;

import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

public class HellOnWorld_UniTest {

    private Context ctx = mock(Context.class);

    @Disabled
    @Test
    public void GET_a_demon() {
        // TODO FIX HellOnWorld_UniTest.GET_a_demon:21 MissingMethodInvocation
        when(DemonController.demons.get(0)).thenReturn("Propaganda_Brothers");
        DemonController.getAll(ctx); // the handler we're testing
        verify(ctx).status(200);
    }

    @Disabled
    @Test
    public void POST_to_add_new_demon_gives_201_for_valid_demonname() {
        when(ctx.queryParam("demonname")).thenReturn("Propaganda_Brothers");
        DemonController.create(ctx); // the handler we're testing
        verify(ctx).status(201);
    }

    @Disabled
    @Test
    public void POST_to_create_demons_throws_for_invalid_demonname() {
        when(ctx.queryParam("demonname")).thenReturn(null);
        Assertions.assertThrows(
                BadRequestResponse.class,
                () -> {
                    DemonController.create(ctx); // the handler we're testing
                }
        );
    }
}
