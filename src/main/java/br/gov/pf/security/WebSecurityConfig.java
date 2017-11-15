package br.gov.pf.security;

/**
 * Created by sartori on 01/11/2017
 */
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf().disable().authorizeRequests()
//                .antMatchers("/home").permitAll()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .anyRequest().authenticated();
//        //.and();
//
////                // filtra requisições de login
////                .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
////                        UsernamePasswordAuthenticationFilter.class)
////
////                // filtra outras requisições para verificar a presença do JWT no header
////                .addFilterBefore(new JWTAuthenticationFilter(),
////                        UsernamePasswordAuthenticationFilter.class);
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        // cria uma conta default
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("password")
//                .roles("ADMIN");
//    }
//}
