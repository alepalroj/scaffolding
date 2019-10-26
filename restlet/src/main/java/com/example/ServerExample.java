package com.example;

import com.example.restlet.HelloRestlet;
import org.restlet.Server;
import org.restlet.data.Protocol;

public class ServerExample {

    public static void main(String[] args) throws Exception {
        
        Server server = new Server(Protocol.HTTP, 8080 );
        server.setAddress("127.0.0.1");
        ApplicationExample applicationExample = new ApplicationExample();
        server.setNext(applicationExample);
        
        server.start();
        
    }
}
