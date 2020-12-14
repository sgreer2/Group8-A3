package comp31.demo.controller;

import org.springframework.stereotype.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import comp31.demo.model.User;
import comp31.demo.model.Watching;
import comp31.demo.repo.UserRepo;
import comp31.demo.repo.WatchingRepo;

@Controller
@SessionAttributes("currentUser")
public class UserController {
    @Autowired
    WatchingRepo watchingRepo;
    @Autowired
    UserRepo userRepo;
    
    @GetMapping("/watchList")
    public String watchList(Model model){
        String nextPage = "watchListPage";
        User currentUser;

        // get current user
        currentUser = (User)model.getAttribute("currentUser");

        // user watching list
        Watching watchList = watchingRepo.findByUser(currentUser).get(0);
        model.addAttribute("watchList", watchList);

        return nextPage;
    }
}
