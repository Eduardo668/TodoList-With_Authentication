package br.com.todolist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.todolist.util.AlgorithmUtil;


@Configuration
public class BeansAgrupation {
    
	@Autowired
	private Environment environment;

    @Bean
	public BCryptPasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AlgorithmUtil algorithmUtil(){
		return new AlgorithmUtil(environment);
	}
	


}
