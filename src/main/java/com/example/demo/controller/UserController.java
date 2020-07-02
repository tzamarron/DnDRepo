package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.UserWithRoles;
import com.example.demo.repositories.UserRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    //Dependency Injection
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    // Register Get Mapping
    @GetMapping("/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    // Register Post Mapping
    @PostMapping("/register")
    public String saveUser(Model model, @ModelAttribute User user) {
        // Get password and confirm password from Model passed from HTML
        String pass = user.getPassword();
        String confirmPass = user.getConfirmPass();
        // Check to make sure password and confirm password match
        if (!pass.equals(confirmPass)) {
            // If they don't match send attribute to trigger alert
            model.addAttribute("passConfirm", "passwords do not match");
        } else {
            // If they do match then hash password
            String hash = passwordEncoder.encode(pass);
            // Set hashed password to user Model
            user.setPassword(hash);
            // Save user Model to database
            userRepo.save(user);
            // Authenticate user so they don't have to login in
            authenticate(user);
        }
        // Redirect to url
        return "redirect:/profile";
    }

    // Method to authenticate user so they don't have to log in
    private void authenticate(User user) {
        UserDetails userDetails = new UserWithRoles(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(auth);
    }

    // Profile Get Mapping
    @GetMapping("/profile")
    public String loadProfile() {
        // Send to HTML
        return "user/profile";
    }
}
