package com.josmejia2401.nuevospa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class NuevoSpaApplication {
    public static void main(String[] args) {
        SpringApplication.run(NuevoSpaApplication.class, args);
    }
}
