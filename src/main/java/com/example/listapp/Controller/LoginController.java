package com.example.listapp.Controller;

import com.example.listapp.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginController {
    @GetMapping("/web-list/login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping
    public String getIndexView() {
        return "redirect:/web-list";
    }
}
