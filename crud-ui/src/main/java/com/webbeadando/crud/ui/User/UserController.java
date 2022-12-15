package com.webbeadando.crud.ui.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired private UserService service;

    @GetMapping("/users")
    public String showUserList(Model model){
        List<User> listUsers= service.listAll();
        model.addAttribute("listUser",listUsers);
        return "users";
    }

    @GetMapping("/users/new")
    public String showNewForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle", "ÚJ hiba bejelentése");
        return "user_form";
    }

    @PostMapping("/user/save")
    public String saveUser(User user){
        service.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        try {
            User user = service.get(id);
            model.addAttribute("user", user);
            model.addAttribute("pageTitle", "Szerkesztése ");
            return "user_form";
        } catch (UserNotFoundException e) {
            e.printStackTrace();
            return "redirect:/users";
        }

    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/users";
    }
}
