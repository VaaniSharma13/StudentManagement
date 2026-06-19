package com.proj.StudentManagement.service;
import com.proj.StudentManagement.entity.User;
import com.proj.StudentManagement.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    public String register(User user) {
        User existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser != null) {
            return "email prev registered";
        }
        user.setPswd(
                passwordEncoder.encode(user.getPswd())
        );
        userRepo.save(user);
        return "registration successful";
    }
    public String login(User user){
        User existingUser = userRepo.findByEmail(user.getEmail());
        if (existingUser == null){
            return "email not found";
        }
        if (passwordEncoder.matches(user.getPswd(), existingUser.getPswd())){
            return "login successful";
        }
        return "Incorrect Password";
    }
}