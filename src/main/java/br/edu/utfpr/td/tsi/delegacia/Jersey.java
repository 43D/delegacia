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
		// this.packages("br.edu.utfpr.td.tsi.delegacia.route");
        this.register(br.edu.utfpr.td.tsi.delegacia.route.BoletimEndpoint.class);
        this.register(br.edu.utfpr.td.tsi.delegacia.route.DelegaciaEndpoint.class);
        this.register(br.edu.utfpr.td.tsi.delegacia.route.VeiculoEndpoint.class);

    }
}
