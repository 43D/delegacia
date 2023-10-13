package br.edu.utfpr.td.tsi.delegacia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.delegacia")
public class DelegaciaApplication {
    public static void main(String[] args) {
		SpringApplication.run(DelegaciaApplication.class, args);
	}

	@PostConstruct 
	public void init(){
		System.out.println("teste ---------------------------");
	}
}
