package br.edu.utfpr.td.tsi.delegacia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import br.edu.utfpr.td.tsi.delegacia.repository.BoletimRepository;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
@ComponentScan("br.edu.utfpr.td.tsi.delegacia")
public class DelegaciaApplication {
	public static void main(String[] args) {
		SpringApplication.run(DelegaciaApplication.class, args);
	}

	@Autowired
	BoletimRepository rep;
	@PostConstruct
	public void init() {
		System.out.println("teste ---------------------------");
		long c = rep.count();
		System.out.println(c + " <-----");
		System.out.println("teste ---------------------------");
	}
}
