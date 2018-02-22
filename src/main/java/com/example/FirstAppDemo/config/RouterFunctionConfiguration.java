package com.example.FirstAppDemo.config;

import com.example.FirstAppDemo.domain.User;
import com.example.FirstAppDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

import java.util.Collection;

@Configuration
public class RouterFunctionConfiguration {
    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository){
        Collection<User> users = userRepository.findAll();
        //RouterFunctions.route(RequestPredicates.GET("/person/find/all"));
        return null;
    }

}
