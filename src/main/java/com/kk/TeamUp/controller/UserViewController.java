package com.kk.TeamUp.controller;


import com.kk.TeamUp.domain.User;
import com.kk.TeamUp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserViewController {
    private final UserService userService;

    @GetMapping("/login")
    public String Login() {
        return "/login";
    }

    @GetMapping("/users")
    public String findAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users",users);
        return "/users";
    }

    @GetMapping("/users/{id}")
    public String findUser(@PathVariable long id,  Model model) {
        User user = userService.findUser(id);
        model.addAttribute("user",user);
        return "/oneUser";
    }

    @GetMapping("/users/update/{id}")
    public String updateUser(@PathVariable long id, Model model) {
        model.addAttribute("id",id);
        return "/update";
    }
}
