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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    //Dependency Injection
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepo, PasswordEncoder passwordEncoder){
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "user/register";
    }

    @PostMapping("/register")
    public String saveUser(Model model, @ModelAttribute User user, HttpServletRequest req, BindingResult bindingResult) {
        String pass = user.getPassword();
        String confirmPass = user.getConfirmPass();
        if (!pass.equals(confirmPass)) {
            model.addAttribute("passConfirm", "passwords do not match");
        } else {
            String hash = passwordEncoder.encode(pass);
            user.setPassword(hash);
            userRepo.save(user);
            authenticate(user);
        }
        return "redirect:/profile";
    }
    private void authenticate(User user) {
        // Notice how we're using an empty list for the roles
        UserDetails userDetails = new UserWithRoles(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(
                userDetails,
                userDetails.getPassword(),
                userDetails.getAuthorities()
        );
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(auth);
    }
}
