package online.lahiru.sprinngbotrestapi.controller;

import online.lahiru.sprinngbotrestapi.entity.Role;
import online.lahiru.sprinngbotrestapi.entity.User;
import online.lahiru.sprinngbotrestapi.payload.LoginDTO;
import online.lahiru.sprinngbotrestapi.payload.SignUpDTO;
import online.lahiru.sprinngbotrestapi.repository.RoleRepository;
import online.lahiru.sprinngbotrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsernameOrEmail(),
                loginDTO.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return  new ResponseEntity<>("User sign in successfully ", HttpStatus.OK);
    }

    @PostMapping("/signup")
public ResponseEntity<?> registerUser(SignUpDTO signUpDTO){

        if(userRepository.existsByUsername(signUpDTO.getUsername())){
            return  new ResponseEntity<>("username is already taken",HttpStatus.BAD_REQUEST);

        }

        if(userRepository.existsByEmail(signUpDTO.getEmail())){
            return  new ResponseEntity<>("email is already taken",HttpStatus.BAD_REQUEST);

        }

        User user = new User();
        user.setName(signUpDTO.getName());
        user.setUsername(signUpDTO.getUsername());
        user.setEmail(signUpDTO.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return  new ResponseEntity<>("user saved successfully !", HttpStatus.OK);
        

    }
}
