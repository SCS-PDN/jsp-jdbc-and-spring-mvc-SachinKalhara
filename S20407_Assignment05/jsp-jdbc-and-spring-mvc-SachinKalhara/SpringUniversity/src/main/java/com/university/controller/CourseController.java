public package com.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CourseController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/courses")
    public String listCourses(Model model) {
        List<Map<String, Object>> courses = jdbcTemplate.queryForList("SELECT * FROM courses");
        model.addAttribute("courses", courses);
        return "courses";
    }

    @PostMapping("/register/{courseId}")
    public String registerCourse(@PathVariable int courseId, HttpSession session, Model model) {
        String email = (String) session.getAttribute("userEmail");
        if (email == null) return "redirect:/login";
        Integer studentId = jdbcTemplate.queryForObject("SELECT student_id FROM students WHERE email=?", Integer.class, email);
        jdbcTemplate.update("INSERT INTO registrations (student_id, course_id, date) VALUES (?, ?, NOW())", studentId, courseId);
        return "success";
    }
}
 CourseController {
    
}
