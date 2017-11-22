package br.com.caelum.fj91.seguranca.infra.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder passwordEncoder;

	public SpringSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder passwordEncoder) {
		this.userDetailsService = userDetailsService;
		this.passwordEncoder = passwordEncoder;
	}

	public UserDetailsService userDetailsServiceBean() {
		return userDetailsService;
	}

	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] permittedUrls = { "/", "/home", "/login" };
		String[] authenticatedUrls = { "/processos", "/processos/**/*" };
		
		http.csrf().and()
			.authorizeRequests().antMatchers(authenticatedUrls).authenticated()
			.and().authorizeRequests().antMatchers(permittedUrls).permitAll()
			.and().formLogin().loginPage("/login")
			.and().headers().contentSecurityPolicy("default-src 'none'; base-uri 'self'; form-action 'self'; connect-src 'self'; frame-src 'self'; font-src 'self' data: ; img-src 'self'; style-src 'unsafe-inline' 'self'; script-src 'self'");
	}
	
}
