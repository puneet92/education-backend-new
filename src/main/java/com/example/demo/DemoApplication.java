package com.example.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;

@SpringBootApplication

public class DemoApplication {
	 private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		//SpringApplication.run(DemoApplication.class, args);
		 SpringApplication app = new SpringApplication(DemoApplication.class);
		//app.setBanner(false);
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
    //    addDefaultProfile(app, source);
       // addLiquibaseScanPackages();
        Environment env = app.run(args).getEnvironment();
        log.info("Access URLs:\n----------------------------------------------------------\n\t" +
            "Local: \t\thttp://127.0.0.1:{}\n\t" +
            "External: \thttp://{}:{}\n----------------------------------------------------------",
            env.getProperty("server.port"),
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"));
	}
	
	  
}
