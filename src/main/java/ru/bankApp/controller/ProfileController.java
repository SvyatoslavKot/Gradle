package ru.bankApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.bankApp.app.bankApp.exeption.ClientAddExeption;
import ru.bankApp.app.entities.Client;
import ru.bankApp.service.ClientService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/bank_app/profile/")
public class ProfileController {
    ClientService clientService;
    @Autowired
    public ProfileController( ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping("/{id}")
    public String exitProfile(@PathVariable("id") int id, HttpServletRequest req, HttpServletResponse resp){
        Cookie[]cookies = req.getCookies();
        for (Cookie c:cookies){
            if (c.getName().equals("client")){
                c.setMaxAge(0);
                resp.addCookie(c);
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
            return "redirect:/bank_app/profile/"+clientService.getByPhone(client.getMobilePhone()).getId();
        }
    }

    @GetMapping("/{id}")
    public String profileView(HttpServletResponse resp,@PathVariable("id") int id, Model model){
        Cookie clientCook = new Cookie("client", String.valueOf(id));
        clientCook.setMaxAge(24*60*30);
        resp.addCookie(clientCook);
        model.addAttribute("client", clientService.getById(id));
        return "profileViews/profile";
    }
    @GetMapping("/{id}/edit")
    public String editProfile(Model model, @PathVariable("id") int id){
        model.addAttribute("client",clientService.getById(id));
        return "profileViews/profileEdit";
    }

    @PatchMapping("/{id}")
    public String upDate(
            @ModelAttribute("client") @Valid Client client,BindingResult bindingResult,
            @PathVariable("id") int id){
            clientService.upDate( client);
            return "redirect:/bank_app/profile/"+client.getId();
    }

    @DeleteMapping("/{id}")
    public String deleteProfile(@PathVariable("id") int id){
        clientService.delete(id);
        return "redirect:/bank_app/";
    }
}
