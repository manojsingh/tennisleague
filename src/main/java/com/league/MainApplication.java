package com.league;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);

        // Map<String, Object> defProperties = new HashMap<String,Object>();
        // defProperties.put("spring.profiles.default", "local");
        // app.setDefaultProperties(defProperties);
//        app.run(args);

    }
}
