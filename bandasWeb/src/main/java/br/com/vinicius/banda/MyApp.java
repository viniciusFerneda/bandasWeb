package br.com.vinicius.banda;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class MyApp extends ResourceConfig{

	public MyApp() {
		packages("br.com.vinicius.banda.controllers");
	}
	
}
