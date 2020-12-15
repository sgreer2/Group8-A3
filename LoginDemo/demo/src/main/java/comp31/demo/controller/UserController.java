package comp31.demo.controller;

import org.springframework.stereotype.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import comp31.demo.model.User;
import comp31.demo.model.Watching;
import comp31.demo.repo.ShowRepo;
import comp31.demo.repo.UserRepo;
import comp31.demo.repo.WatchingRepo;

@Controller
@SessionAttributes("currentUser")
public class UserController {
    @Autowired
    WatchingRepo watchingRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ShowRepo showRepo;
    
    @GetMapping("/watchList")
    public String watchList(Model model){
        String nextPage = "watchListPage";
        User currentUser;

        // get current user
        currentUser = (User)model.getAttribute("currentUser");

        // user watching list
        model.addAttribute("watchList", watchingRepo.findByUser(currentUser).get(0));

        // initialize adding to watch list
        Watching newWatch= new Watching();
        model.addAttribute("newWatch", newWatch);

        return nextPage;
    }

    @GetMapping("/showList")
    public String showList(Model model){
        String nextPage = "userShowPage";

        // get list of shows
        model.addAttribute("showList", showRepo.findAll());

        return nextPage;

    }
}
