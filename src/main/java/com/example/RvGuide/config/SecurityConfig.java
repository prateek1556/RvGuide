package com.example.RvGuide.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	//@Autowired
	//private CustomLoginSuccessHandler sucessHandler;

	@Autowired
	private DataSource dataSource;

	@Value("${spring.queries.users-query}")
	private String usersQuery;

	@Value("${spring.queries.roles-query}")
	private String rolesQuery;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
				// URLs matching for access rights
				.antMatchers("/").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers("/loadregistration").permitAll()
				.antMatchers("/registration").permitAll()//registration
				.antMatchers("/coronaapi/**").permitAll()
				.antMatchers("/countryapi/**").permitAll()
				.antMatchers("/textprocessingapi/**").permitAll()
				.antMatchers("/algorithm/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "SITE_USER")
				.antMatchers("/home/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "SITE_USER")
				.antMatchers("/coronavirus/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "SITE_USER")
				.antMatchers("/textprocessing/**").hasAnyAuthority("SUPER_USER", "ADMIN_USER", "SITE_USER")
				.antMatchers("/admin/**").hasAnyAuthority("SUPER_USER","ADMIN_USER")
				.anyRequest().authenticated()
				.and()
				// form login
				.formLogin()
				.loginPage("/login")
				.loginProcessingUrl("/authenticateTheUser")
				.failureUrl("/login?error=true")
				.defaultSuccessUrl("/home")
				.usernameParameter("email")
				.passwordParameter("password")
				.permitAll()
				.and()
				// logout
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout=true").and()
				.exceptionHandling()
				.accessDeniedPage("/access-denied");
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

}
