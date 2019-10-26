package com.example.jooby;

import io.jooby.Jooby;

public class App extends Jooby {

	{
		get("/", ctx -> "Hello World!");
	}

	public static void main(final String[] args) {
		runApp(args, App::new);
	}

}
