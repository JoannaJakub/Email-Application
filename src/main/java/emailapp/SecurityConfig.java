package emailapp;

import emailapp.service.SpringDataUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasAnyAuthority("ADMIN", "USER")
                .and().formLogin()
                .loginPage("/")
                .loginProcessingUrl("/")
                .usernameParameter("username")
                .defaultSuccessUrl("/default")
                .failureUrl("/?error=true")
                .and().logout().logoutSuccessUrl("/")
                .permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .and().exceptionHandling().accessDeniedPage("/accessDenied");
        //
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SpringDataUserDetailsService customUserDetailsService() {
        return new SpringDataUserDetailsService();
    }

}
