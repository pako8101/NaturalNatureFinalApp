package kamenov.naturalnaturefinalapp.configuration;


import kamenov.naturalnaturefinalapp.entity.enums.UserRoleEnum;
import kamenov.naturalnaturefinalapp.repositories.UserRepository;
import kamenov.naturalnaturefinalapp.service.ApplicationUserDetailsService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.context.DelegatingSecurityContextRepository;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

@Configuration
public class SecurityConfig {

//    private final String rememberMeKey;
//
//    public SecurityConfig(@Value(
//            "${remember.me.key}")String rememberMe){
//
//        this.rememberMeKey = rememberMe;
//    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http,
                                           SecurityContextRepository securityContextRepository
            , JwtAuthFilter jwtAuthFilter) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorizeHttpRequests ->
                                authorizeHttpRequests.
                                        requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                                        .permitAll().
                                        requestMatchers("/",
                                                "/about",
                                                "/subscribe",
                                                "/compost",
                                                "/reducing-plastics/**",
                                                "/passive-houses/**",
                                                "/responsible-fashion/**",
                                                "/article-details/**",
                                                "/nutrition/**",
                                                "/wellness/**",
                                                "/animal-tourism/**",
                                                "/animal-tourism-article-details/**",
                                                "/wellness-article-details/**",
                                                "/nutrition-article-details/**",
                                                "/reducing-plastic-waste/**",
                                                "/sustainable-transportation/**",
                                                "/herbal-remedies/**",
                                                "/forum/**",
                                                "/sustainable-transportation/articles/**",
                                                "/forum/add-post/**",
                                                "/video-courses/**",
                                                "/eco-accommodations",
                                                "/national-parks",
                                                "/organic-gardening/**",
                                                "/admin/add-product",
                                                "/journey/**",
                                                "/waste-management/**",
                                                "/green-cooking/**",
                                                "/rec/**",
                                                "/recycling/**",
                                                "/cart/**",
                                                "/blog/**",
                                                "/delete/**",
                                                "/user/login",
                                                "/user/register",
                                                "/edit/**",
                                                "/user/login-error"


                                        )


                                        .permitAll()
//                                        .anyRequest().authenticated().
                                        .requestMatchers("/error").permitAll()
                                        .requestMatchers("/admin/**").hasRole("ADMIN")
                                        .requestMatchers("/green-cooking/edit/**", "/green-cooking/delete/**")
                                      .permitAll().
                                        requestMatchers("/pages/admins").hasRole(UserRoleEnum.ADMIN.name()).
                                        requestMatchers("/pages/all").hasRole(UserRoleEnum.USER.name()).
                                        anyRequest().authenticated()


//                                       requestMatchers("/**").authenticated()
                )
                .formLogin(
                        (formLogin) ->
                                formLogin.
                                        loginPage("/user/login").
                                        usernameParameter(
                                                UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY).
                                        passwordParameter(
                                                UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_PASSWORD_KEY).
                                        defaultSuccessUrl("/", true).
                                        failureForwardUrl("/user/login-error")

                )
                .logout((logout) ->
                        logout.logoutUrl("/user/logout").
                                logoutSuccessUrl("/").//go to homepage after logout
                                invalidateHttpSession(true)
                                .deleteCookies("JSESSIONID")


                )
//                .rememberMe(httpSecurityRememberMeConfigurer -> {
//                            httpSecurityRememberMeConfigurer.key(rememberMeKey)
//                                    .rememberMeParameter("rememberMe")
//                                    .rememberMeCookieName("rememberMe")
//                                    .tokenValiditySeconds(10000);
//                        }
//                )

                .securityContext(
                        securityContext -> securityContext.
                                securityContextRepository(securityContextRepository)

                )
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                )
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new ApplicationUserDetailsService(userRepository);
    }

    @Bean
    public SecurityContextRepository securityContextRepository() {
        return new DelegatingSecurityContextRepository(
                new RequestAttributeSecurityContextRepository(),
                new HttpSessionSecurityContextRepository()
        );
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
