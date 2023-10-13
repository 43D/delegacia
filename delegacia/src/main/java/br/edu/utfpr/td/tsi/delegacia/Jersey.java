package br.edu.utfpr.td.tsi.delegacia;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.springframework.stereotype.Component;

import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/delegacia")
public class Jersey extends ResourceConfig{
    public Jersey(){
        this.register(RequestContextFilter.class);
		this.packages("br.edu.utfpr.td.tsi.delegacia.boletim.route");
    }
}
