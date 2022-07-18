package projectFinal.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import projectFinal.models.form.LoginForm;

import java.time.Instant;

@Controller
public class SessionController {

    private final UserDetailsService userDetailsService;
    private final PasswordEncoder encoder;

    public SessionController(UserDetailsService userDetailsService, PasswordEncoder encoder) {
        this.userDetailsService = userDetailsService;
        this.encoder = encoder;
    }

    @GetMapping("/login")
    public String login(){
        return "session/login";
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginForm form){
        UserDetails details = userDetailsService.loadUserByUsername(form.getUsername());
        if(encoder.matches(form.getPassword(), details.getPassword())
                && details.isAccountNonExpired()
                && details.isAccountNonLocked()
                && details.isEnabled()
                && details.isCredentialsNonExpired()
        ){
            return JWT.create()
                    .withExpiresAt(Instant.ofEpochMilli(System.currentTimeMillis() + 86400000))
                    .withSubject( details.getUsername() )
                    .withClaim("roles", details.getAuthorities().stream().toList() )
                    .sign( Algorithm.HMAC512( "d7pV6Y6JTpsKZVnFr3pkBjvf" ) );
        }
        else{
            throw new RuntimeException("Connection failed");
        }
    }

}
