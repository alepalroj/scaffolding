package com.example.restlet;

import org.restlet.Context;
import org.restlet.Request;
import org.restlet.Response;
import org.restlet.Restlet;
import org.restlet.data.MediaType;

public class DefaultRestlet extends Restlet {

    public DefaultRestlet(Context context) {
        super(context);
    }

    @Override
    public void handle(Request request, Response response) {
        String entity = "Default Restlet!";
        response.setEntity(entity, MediaType.TEXT_PLAIN);
    }

}
