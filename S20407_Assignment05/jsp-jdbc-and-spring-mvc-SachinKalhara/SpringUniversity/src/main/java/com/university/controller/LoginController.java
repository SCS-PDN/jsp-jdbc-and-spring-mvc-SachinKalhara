package com.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String validateLogin(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        String sql = "SELECT COUNT(*) FROM students WHERE email=? AND password=?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, email, password);
        if (count > 0) {
            session.setAttribute("userEmail", email);
            return "redirect:/courses";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login";
        }
    }
}
