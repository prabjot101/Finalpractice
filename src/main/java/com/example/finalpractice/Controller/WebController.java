package com.example.finalpractice.Controller;

import com.example.finalpractice.Entities.Users;
import com.example.finalpractice.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class WebController {


    @Autowired
    UserRepository userRepository;

    @GetMapping("/index")
    public String index(Model model)
    {
        List<Users> userlist = userRepository.findAll();
        model.addAttribute("listUsers", userlist);

        return "home";
    }

    @GetMapping("/delete")
    public String del(Long id)
    {
        userRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/edit")
    public String Edit(Long id, Model model)
    {
        Users user = userRepository.findById(id).orElse(null);
        if(user == null) throw new RuntimeException("not");
        model.addAttribute("user", user);
        return "editing";

    }

    @PostMapping("/reg")
    public String reg(@ModelAttribute Users u)
    {
        userRepository.save(u);
        userRepository.findAll();
        return "home";
    }
}
