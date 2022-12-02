package br.com.todolist.util;

import org.springframework.core.env.Environment;

import com.auth0.jwt.algorithms.Algorithm;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class AlgorithmUtil {
    
    private final Environment env;

    public Algorithm defineAlgorithm(){
        String secret = env.getProperty("secret.key");

        Algorithm algorithm = Algorithm.HMAC256(secret.getBytes());
        return algorithm;
    }

}
