package com.example.design_patterns.singleton_pattern;

import org.springframework.stereotype.Service;

/**
 * Spring creates only one instance of a bean by default (@Singleton scope).
 * Spring creates only one instance of EmailService in the entire application.
 * Eg:- @Service, @Repository, @Controller
 *      RestTemplate, ObjectMapper, ModelMapper
 */

@Service
public class EmailService {
    public void sendEmail() {
        System.out.println("Email sent!");
    }
}
