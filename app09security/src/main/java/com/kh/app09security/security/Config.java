package com.kh.app09security.security;

import com.kh.app09security.filter.MyLoginFilter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class Config {
    private final AuthenticationConfiguration authenticationConfiguration; //스프링이 제공
    private final MyJwtUtil myJwtUtil;

    @Bean //스프링이 제공한 AuthenticationConfiguration 통해서 인증매니저 반환
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity hs) throws Exception {
        //토큰 사용
        //미사용으로 설정
        hs.formLogin(AbstractHttpConfigurer::disable);
        hs.csrf(AbstractHttpConfigurer::disable);
        hs.httpBasic(AbstractHttpConfigurer::disable);
        hs.sessionManagement((x)->x.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // url에 대한 검증 => 순차적으로 검사
        hs.authorizeHttpRequests(x-> x
//                .requestMatchers("api/test/user").permitAll() 모든 요청에 대해서 인증검사
//                .requestMatchers("api/test/user").hasRole("ADMIN") 유저객체에서 필드로 권한 설정해줄 수 있어서 문자열 비교가능
                //인증된 사람인지 아닌지
//                .requestMatchers("api/test/user").authenticated()
                //해당 url 요청 모두 허가
                .requestMatchers("/login", "/join", "/home", "/", "/admin/login").permitAll()
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated() //모든 요청/인증
        );
        
        //필터 갈아끼우기 [   대체 필터 , 기존필터  ] - 스프링이 만들면 순환참조 무한굴레라 우리가 직접만듬
        AuthenticationManager authManager = authenticationManager(); //함수 호출해서 authManager 얻기
        MyLoginFilter myLoginFilter = new MyLoginFilter(authManager, myJwtUtil);
        myLoginFilter.setFilterProcessesUrl("/login"); //로그인경로에 대해 동작하게 설정 - 상대경로가 있을수없으므로 슬래시 필요
        hs.addFilterAt(myLoginFilter, UsernamePasswordAuthenticationFilter.class);

        //CORS
        hs.cors(
                corsConfigurer -> corsConfigurer.configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration conf = new CorsConfiguration();

                        conf.addAllowedOrigin("*");
                        conf.addAllowedMethod("*");
                        conf.addAllowedHeader("*");
                        conf.addExposedHeader("*");

                        return conf;
                    }
                })
        );

        return hs.build();
    }
}
