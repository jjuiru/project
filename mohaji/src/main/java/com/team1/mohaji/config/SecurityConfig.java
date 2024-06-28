package com.team1.mohaji.config;

import com.team1.mohaji.entity.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrfConfig) -> csrfConfig.disable())//CSRF protection: DB변동이 발생하는 request는 무조건 차단시켜버리는 기능. DB작업하려고 해제.
                //혜빈 05.24 22번 라인 코드 수정
                .authorizeHttpRequests((authorize) -> authorize // HTTP 요청을 인증 및 권한 부여합니다.
                        .requestMatchers("/css/**", "/img/**" ,"/js/**").permitAll() // "모든 외부링크 적용 허용"
                        .requestMatchers("/", "/main").permitAll() // "/"와 "/main" 경로에 대한 요청은 모두 허용합니다.
                        .requestMatchers("/postDetail","/boardList","/assignment","/notice","/question","/resource" ).permitAll()
                        //혜빈 05.24 26,27 라인 코드 수정
                        .requestMatchers("/regCourse").hasAuthority("STUDENT") // 수강신청 /regCourse는 학생만 허용
                        .requestMatchers("/register").hasAuthority("ADMIN")// "/register" 경로에 대한 요청은 모두 허용합니다.
                        .anyRequest().authenticated())// 그 외의 모든 요청은 인증이 필요합니다.
//                        .anyRequest().permitAll())// 그 외의 모든 요청은 인증이 필요합니다.
                .formLogin(loginConfigurer -> loginConfigurer // 폼 로그인을 구성합니다.
                        .defaultSuccessUrl("/main",true) // 로그인 성공 시 기본 URL("/main")로 리다이렉트합니다.
                        .failureUrl("/login?error=true") // 로그인 실패 시 "/login?error=true" URL로 리다이렉트합니다.
                        .loginPage("/login/login") // 1번: 커스텀 로그인 페이지 설정
                        .usernameParameter("username") // 2번: 사용자 이름 필드 이름 설정
                        .passwordParameter("password") // 3번: 비밀번호 필드 이름 설정
                        .loginProcessingUrl("/login/login-proc") // 4번: 로그인 처리 URL 설정
                        .permitAll()) // 로그인 페이지에 대한 접근을 모두 허용합니다.

                .logout(logoutConfigurer -> logoutConfigurer  // 로그아웃을 구성합니다.
                        .logoutUrl("/logout") // 로그아웃 URL을 설정합니다.
                        .logoutSuccessHandler((request, response, authentication) -> {
                            System.out.println("User has been logged out");
                            response.sendRedirect("/main");
                        })
                        .invalidateHttpSession(true)// HTTP 세션을 무효화합니다.
                        .deleteCookies("JSESSIONID")
                        .permitAll()) // 로그아웃 페이지에 대한 접근을 모두 허용합니다.
                .httpBasic(Customizer.withDefaults()); // 기본 HTTP 기본 인증을 사용합니다.
        return http.build(); // HttpSecurity 객체를 SecurityFilterChain으로 빌드하여 반환합니다.
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
