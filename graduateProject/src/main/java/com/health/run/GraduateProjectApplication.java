package com.health.run;

import org.apache.catalina.connector.Connector;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@ComponentScan({"com.health"})
@EntityScan({"com.health.entity"})
@EnableJpaRepositories(basePackages="com.health")
@PropertySource("classpath:application.properties")
@ImportResource({"classpath*:applicationContext.xml"})
public class GraduateProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraduateProjectApplication.class, args);
		
	}
	
	@Bean
    public ServletWebServerFactory serveltContainer(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector(){
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8070);
        return connector;
    }



}