package com.example.vertx;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.StaticHandler;

public class AppVerticle extends AbstractVerticle {

	public static void main(String[] args) {

		//Vertx vertx = Vertx.vertx(new VertxOptions().setWorkerPoolSize(4));
		Vertx vertx = Vertx.vertx(new VertxOptions());
		DeploymentOptions options = new DeploymentOptions().setWorker(true);
		vertx.deployVerticle("com.example.vertx.AppVerticle", options);

	}

	@Override
	public void start() {

		Router router = Router.router(vertx);
		router.get("/").handler(this::index);
		router.route().handler(StaticHandler.create().setCachingEnabled(false));
		HttpServer server = vertx.createHttpServer();
		server.requestHandler(router);
		server.listen(8080);

	}

	private void index(RoutingContext routingContext) {

		HttpServerResponse response = routingContext.response();
		response.putHeader("content-type", "text/plain").end("Hello World!");

	}

	@Override
	public void stop() {

	}

}
