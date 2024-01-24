package com.ttrzcinski.rest.java;

import io.javalin.Javalin;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.post;

public class HellApp {

    public static final int HELLAPP_DEFAULT_PORT = 7000;

    private final Javalin app = Javalin.create().routes(() -> {
        get("/demons", DemonController::getAll);
        post("/demons", DemonController::create);
        get("/", ctx -> ctx.result("Hell-On-World"));
    });

    public void start(int port) {
        this.app.start(port);
    }

    public void stop() {
        this.app.stop();
    }
}
