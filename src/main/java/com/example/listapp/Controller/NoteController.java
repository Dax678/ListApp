package com.example.listapp.Controller;

import com.example.listapp.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web-list")
public class NoteController {
    private final UserService userService;

    public NoteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getIndexView(Model model) {
        return "index";
    }

    @GetMapping("/newNote")
    public String getNewNoteView(Model model) {

        return "createNote";
    }
}
