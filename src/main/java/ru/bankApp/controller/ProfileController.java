package ru.bankApp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bankApp.app.bankApp.exeption.ClientAddExeption;
import ru.bankApp.app.entities.Client;
import ru.bankApp.app.entities.Employee;
import ru.bankApp.service.ClientService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/bank_app/client/")
public class ProfileController {
    ClientService clientService;
    @Autowired
    public ProfileController( ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping("/profile/{id}")
    public String exitProfile(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp){
        Cookie[]cookies = req.getCookies();
        for (Cookie c:cookies){
            if (c.getName().equals("client")){
                c.setMaxAge(0);
                resp.addCookie(c);
                req.getSession().removeAttribute("client");
                return "redirect:/bank_app/";
            }
        }
        return "redirect:/bank_app/";
    }

    @GetMapping("/reg")
    public String regView(Model model){
        model.addAttribute("client", new Client());
        return "profileViews/registration";
    }
    @PostMapping("/reg")
    public String addClient(HttpSession session,
                            @RequestParam("password") String p1, @RequestParam("password2")String p2,
                            @ModelAttribute("client") @Valid Client client, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "profileViews/registration";
        }
        if (!p1.equals(p2)){
            return "profileViews/registration";
        }else {
            try {
                clientService.addClient(client);
            } catch (ClientAddExeption e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
                return "profileViews/registration";
            }
            client.setId(clientService.getByPhone(client.getMobilePhone()).getId());
            session.setAttribute("client", client);
            return "redirect:/bank_app/client/profile/"+clientService.getByPhone(client.getMobilePhone()).getId();
        }
    }

    @GetMapping("/profile/{id}")
    public String profileView(HttpServletResponse resp,@PathVariable("id") int id, Model model,
    HttpSession session){
        Client client = clientService.getById(id);
        model.addAttribute("user", client);
        model.addAttribute("client", session.getAttribute("client"));
        model.addAttribute("employee",session.getAttribute("employee"));
        return "profileViews/profile";
    }
    @GetMapping("/profile/{id}/edit")
    public String editProfile(Model model, @PathVariable("id") int id){
        model.addAttribute("client",clientService.getById(id));
        return "profileViews/profileEdit";
    }

    @PatchMapping("/profile/{id}")
    public String upDate(
            @ModelAttribute("client") @Valid Client client,BindingResult bindingResult,
            @PathVariable("id") int id){
            clientService.upDate( client);
            return "redirect:/bank_app/client/profile/"+client.getId();
    }

    @DeleteMapping("/profile/{id}")
    public String deleteProfile(@PathVariable("id") int id){
        clientService.delete(id);
        return "redirect:/bank_app/";
    }
}
