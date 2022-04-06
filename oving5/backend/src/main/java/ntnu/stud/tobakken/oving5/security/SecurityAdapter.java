package ntnu.stud.tobakken.oving5.security;

import ntnu.stud.tobakken.oving5.service.JwtAuthorizationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityAdapter extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                .csrf().disable()
                .addFilterAfter(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .authorizeHttpRequests()
                .antMatchers("/h2/**").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/**", "/equation/**").permitAll()
                .antMatchers(HttpMethod.GET, "/equation/**").permitAll()
                .anyRequest().authenticated();
    }
}
