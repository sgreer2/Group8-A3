package comp31.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import comp31.demo.model.User;
import comp31.demo.repo.ShowRepo;
import comp31.demo.repo.UserRepo;
import comp31.demo.service.LoginService;

@Controller
@SessionAttributes("currentUser")
public class AdminController {

    @Autowired LoginService loginService;
    @Autowired ShowRepo showRepo;
    @Autowired UserRepo userRepo;

    private Boolean isValid(User user){
        Boolean result = false;
        if (user != null && loginService.validate(user.getUserName()) != null && user.getUserRole().equals("admin"))
            result = true;
        return result;
    }

    @GetMapping("/admin")
    public String admin(Model model){
        String nextPage = "login";
        User currentUser = (User) model.getAttribute("currentUser");
        if (isValid(currentUser))
            nextPage = "adminpage";
        else{
            User user = new User();
            model.addAttribute("currentUser", null);
            model.addAttribute("newUser", user);
        }
        return nextPage;
    }

    @GetMapping("/adminUserList")
    public String adminUList(Model model){
        String nextPage = "login";
        User currentUser = (User) model.getAttribute("currentUser");
        if (isValid(currentUser)){
            nextPage = "adminUserList";
            // model.addAttribute("userList", userRepo.findAll());
        } else{
            User user = new User();
            model.addAttribute("currentUser", null);
            model.addAttribute("newUser", user);
        }
        return nextPage;
    }

    @GetMapping("/adminShowList")
    public String adminSList(Model model){
        String nextPage = "login";
        User currentUser = (User) model.getAttribute("currentUser");
        if (isValid(currentUser)){
            nextPage = "adminShowList";
            // model.addAttribute("showList", showRepo.findAll());
        } else{
            User user = new User();
            model.addAttribute("currentUser", null);
            model.addAttribute("newUser", user);
        }
        return nextPage;
    }
}
