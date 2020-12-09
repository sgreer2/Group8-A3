package comp31.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import comp31.demo.model.User;
import comp31.demo.repo.ShowRepo;
import comp31.demo.repo.UserRepo;

@Controller
public class AdminController {
    @Autowired ShowRepo showRepo;
    @Autowired UserRepo userRepo;

    private Boolean validUser(User user){
        Boolean result = false;
        

        return result;
    }

    @GetMapping("/admin")
    public String admin(Model model){
        String nextPage = "adminpage";


        return nextPage;
    }

    @GetMapping("/adminUserList")
    public String adminUList(Model model){
        String nextPage = "adminUserList";

        
        return nextPage;
    }

    @GetMapping("/adminShowList")
    public String adminSList(Model model){
        String nextPage = "adminShowList";
        
        return nextPage;
    }
}
