package com.dropshot.backend.controllers;

import com.dropshot.backend.models.ERole;
import com.dropshot.backend.models.Role;
import com.dropshot.backend.models.User;
import com.dropshot.backend.payload.request.LoginRequest;
import com.dropshot.backend.payload.request.SignupRequest;
import com.dropshot.backend.payload.response.JwtResponse;
import com.dropshot.backend.payload.response.MessageResponse;
import com.dropshot.backend.repository.RoleRepository;
import com.dropshot.backend.repository.UserRepository;
import com.dropshot.backend.security.jwt.JwtUtils;
import com.dropshot.backend.security.services.UserDetailsImpl;
import com.dropshot.backend.security.services.UserService;
import com.dropshot.backend.security.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder encoder;

  @Autowired
  JwtUtils jwtUtils;


  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
    System.out.println("LoginRequest................."+loginRequest);
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);
    
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();    
    List<String> roles = userDetails.getAuthorities().stream()
        .map(item -> item.getAuthority())
        .collect(Collectors.toList());

    return ResponseEntity.ok(new JwtResponse(jwt, 
                         userDetails.getId(), 
                         userDetails.getUsername(), 
                         userDetails.getEmail(),
                         roles));
  }

  @PostMapping("/signup")
  public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
    System.out.println("signuprequset Nickname........."+ signUpRequest.getNickname() + "\n signuprequset birthday........."+signUpRequest.getBirthday());
    if (userRepository.existsByUsername(signUpRequest.getUsername())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Username is already taken!"));
    }

    if (userRepository.existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity
          .badRequest()
          .body(new MessageResponse("Error: Email is already in use!"));
    }
  UserServiceImpl userService = new UserServiceImpl();
    User user = userService.join(signUpRequest);
    user.setPassword(encoder.encode(user.getPassword()));

    // Create new user's account
//    User user = new User(signUpRequest.getUsername(),
//               signUpRequest.getEmail(),
//            signUpRequest.getNickname(),
//            signUpRequest.getBirthday(),
//               encoder.encode(signUpRequest.getPassword()));


    System.out.println("Role입력 전 \n"+"user.getbirthday>>>>>"+user.getBirthday()+"user.getNickname"+user.getNickname());
    Set<String> strRoles = signUpRequest.getRole();
    Set<Role> roles = new HashSet<>();

    if (strRoles == null) {
      Role userRole = roleRepository.findByName(ERole.ROLE_USER)
          .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
      roles.add(userRole);
    } else {
      strRoles.forEach(role -> {
        switch (role) {
        case "admin":
          Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(adminRole);

          break;
        case "mod":
          Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(modRole);

          break;
        default:
          Role userRole = roleRepository.findByName(ERole.ROLE_USER)
              .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
          roles.add(userRole);
        }
      });
    }
    user.setRoles(roles);
System.out.println("Role입력 후 \nuser.getbirthday>>>>>"+user.getBirthday()+"user.getNickname"+user.getNickname());
    userRepository.save(user);

    return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
  }


}
