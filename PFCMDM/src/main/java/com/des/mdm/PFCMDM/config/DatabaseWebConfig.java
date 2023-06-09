package com.des.mdm.PFCMDM.config;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class DatabaseWebConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private javax.sql.DataSource dataSource;

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication()                
	    .dataSource(dataSource).usersByUsernameQuery("select nombre, contrasena, estatus from usuarios where nombre=?")
	    .authoritiesByUsernameQuery("select u.nombre, p.permiso from usuarios_permiso up "
	    		+ "inner join usuarios u on u.id = up.idUsuario "
	    		+ "inner join permisos p on p.id = up.idPermiso where u.nombre = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/img/**",
				 "/css/**",
				 "/js/**").permitAll().antMatchers("/",
													"/products",
													"/man",
													"/woman",
													"/login",
													"/register",
													"/detail/**",
													"/about",
													"/buy").permitAll()
		.antMatchers("/admin/**").hasAnyAuthority("ADMIN")
		.antMatchers("/logout", "/saveComent" ).hasAnyAuthority("USER", "ADMIN")
		.antMatchers("/register","/saveUser").permitAll().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
	
	http.csrf().ignoringAntMatchers("/buy");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
