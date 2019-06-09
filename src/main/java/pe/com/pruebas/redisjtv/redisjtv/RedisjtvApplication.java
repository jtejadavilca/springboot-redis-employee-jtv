package pe.com.pruebas.redisjtv.redisjtv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RedisjtvApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisjtvApplication.class, args);
	}

}
