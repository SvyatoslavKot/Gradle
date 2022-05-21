package ru.bankApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ru.bankApp.app.entities.Client;
import ru.bankApp.dao.ClientDao;

import static ru.bankApp.app.entities.Client.*;

@Controller
public class StartControler {
    @GetMapping(value ="/bank_app/")
        public String start() {
            return "main";
        }
}
