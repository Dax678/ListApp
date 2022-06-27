package com.example.listapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web-list/settings")
public class SettingsController {

    @GetMapping
    public String getSettingsView() {
        return "settings";
    }
}
