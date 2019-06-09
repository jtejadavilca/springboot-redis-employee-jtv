package pe.com.pruebas.redisjtv.redisjtv.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // For example: Use only Http Basic and not form login.
    	http.csrf().disable();
//        http
//            .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//            .httpBasic();
    }
}
