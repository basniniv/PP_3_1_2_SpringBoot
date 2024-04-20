package com.basnin.Project2Boot.controller;

import com.basnin.Project2Boot.model.User;
import com.basnin.Project2Boot.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getUsers(Model model) {
        List<User> usersList = userService.getUsers();
        model.addAttribute("users", usersList);
        return "pages/index";
    }

    @GetMapping("/add")
    public String addUserForm(@ModelAttribute("user") User user) {
        return "pages/add";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String updateUserForm(Model model,@RequestParam("id") long id) {
        model.addAttribute("user",userService.getUser(id));
        return "pages/update";
    }

    @PostMapping("/updateUser")
    public String upduteUser(@ModelAttribute("user") User user){
        userService.updateUser(user);
        return "redirect:/";
    }

}