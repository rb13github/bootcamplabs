package com.ibm.bootcamp.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.ibm.bootcamp.repository.UserRepo;
import com.ibm.bootcamp.service.MyUserDetailsService;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static java.lang.String.format;
import org.slf4j.Logger;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserRepo userRepo;
    
    @Autowired
    private MyUserDetailsService myUserDetailsService;
    
    public SecurityConfig(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {  
    	
    	// Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
//        http = http
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and();
        
    http.authorizeRequests()
 // Our public endpoints
    .antMatchers("/hello/**").permitAll()
    .antMatchers("/h2-console/**").permitAll()
    .antMatchers("/web/**").permitAll()
    .antMatchers("/error").permitAll()
 // Our private endpoints
    .anyRequest().authenticated()
    .and()
	.formLogin()
		//.loginPage("/login")
		.permitAll()
		.and()
	.logout()
		.permitAll()
		
	;
    
}
    
//    @Override
//    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {
//        configurer
//                .inMemory()
//                .withClient(clientId)
//                .secret(passwordEncoder.encode(clientSecret))
//                .authorizedGrantTypes(grantType)
//                .scopes(scopeRead, scopeWrite)
//                .resourceIds(resourceIds);
//    }

    //-------------------https://spring.io/guides/gs/securing-web/
//    @Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers("/", "/hello").permitAll() //allow access without authentication
//				.anyRequest().authenticated()
//				.and()
//			.formLogin()
//				.loginPage("/login")
//				.permitAll()
//				.and()
//			.logout()
//				.permitAll();
//	}

//	@Bean
//	@Override
//	public UserDetailsService userDetailsService() {
//		UserDetails user =
//			 User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("password")
//				.roles("USER")
//				.build();
//
//		return new InMemoryUserDetailsManager(user);
//	}
	
	//-------------------------https://www.toptal.com/spring/spring-security-tutorial

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("in the SecurityConfig.configure:"+auth);
    	
//    	auth.userDetailsService(username -> userRepo
//            .findByName(username)
//            .orElseThrow(
//                () -> new UsernameNotFoundException(
//                    format("User: %s, not found", username)
//                )
//            ))
//    	.passwordEncoder(passwordEncoder())
//    	;
    	
    	auth.userDetailsService(myUserDetailsService);
    	
    }

    // Details omitted for brevity
	
//    @Bean
//  //  @Autowired
//    public PasswordEncoder  passwordEncoder() {
//        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
//    }

  //  SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
    return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
//  @Bean
// 	public PasswordEncoder passwordEncoder(){
//  	System.out.println("in the SecurityConfig.passwordEncoder");
// 		PasswordEncoder encoder = new BCryptPasswordEncoder();
// 		return encoder;
// 	}
    
//    @Bean
//   	public PasswordEncoder passwordEncoder(){
//    	System.out.println("in the SecurityConfig.passwordEncoder");
//   		PasswordEncoder encoder = new BCryptPasswordEncoder();
//   		return encoder;
//   	}
}




//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//	
//	 @Override
//	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	        // TODO configure authentication manager
//	    }
//
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	        // TODO configure web security
//	    }
//}
