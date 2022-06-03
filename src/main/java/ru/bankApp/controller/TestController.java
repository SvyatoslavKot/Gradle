package ru.bankApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.bankApp.app.entities.User;
import ru.bankApp.app.entities.Role;

import java.util.Collections;
import java.util.Map;

@Controller
public class TestController {


    @GetMapping("bank_app/login/admin")
    public String loginView(){
        return "login";
    }



    @GetMapping("/registration")
    public String regView (){
    return "registration";
}
    @PostMapping("/registration")
    public String reg (User user, Map<String,Object> model){

        return "redirect:/bank_app/";
    }

}