package comp31.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import comp31.demo.model.Show;
import comp31.demo.model.User;
import comp31.demo.model.Watching;
import comp31.demo.repo.ShowRepo;
import comp31.demo.repo.UserRepo;
import comp31.demo.repo.WatchingRepo;
import comp31.demo.service.LoginService;

// Stephen Greer

@Controller
@SessionAttributes("currentUser")
public class AdminController {

    @Autowired LoginService loginService;
    @Autowired ShowRepo showRepo;
    @Autowired UserRepo userRepo;
    @Autowired WatchingRepo watchingRepo;

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
            model.addAttribute("showList", showRepo.findAll());
        } else{
            User user = new User();
            model.addAttribute("currentUser", null);
            model.addAttribute("newUser", user);
        }
        return nextPage;
    }

    @PostMapping("/adminDeleteShows")
    public String adminDeleteShows(@RequestParam(required = false, value="deleteList") Long[] deleteList, Model model){
        String nextPage = "adminShowList";

        if (deleteList != null && deleteList.length > 0){
            for (Long showId : deleteList) {
                Show show = showRepo.findById(showId).get();
                if (show != null){
                    List<Watching> watchings = watchingRepo.findByShow(show);
                    if (watchings != null){
                        for (Watching watch : watchings) {
                            watchingRepo.delete(watch);
                        }
                    }
                    showRepo.delete(show);
                }
            }
        }
        
        model.addAttribute("showList", showRepo.findAll());
        return nextPage;
    }
}
