package com.example;

import com.example.restlet.HelloRestlet;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class ApplicationExample extends Application {
    

    @Override
    public Restlet createInboundRoot() {
        
        HelloRestlet helloRestlet = new HelloRestlet(getContext());
        
        Router router = new Router(getContext());
        router.attachDefault(helloRestlet);
        
        router.attach("http://127.0.0.1:8080"+"/", helloRestlet);

        return router;
    }
}
