package com.ttrzcinski.rest.java;

import io.javalin.http.BadRequestResponse;
import io.javalin.http.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemonController {

    static List<String> demons = new ArrayList<>(Arrays.asList("Minister_Pinoccio", "Angry_Duck", "Hungry_Kristy"));

    public static void create(Context ctx) {
        String demonName = ctx.queryParam("demonname");
        if (demonName == null || demonName.length() < 5) {
            throw new BadRequestResponse();
        } else {
            demons.add(demonName);
            ctx.status(201);
        }
    }

    public static void getAll(Context ctx) {
        ctx.json(demons);
    }
}
