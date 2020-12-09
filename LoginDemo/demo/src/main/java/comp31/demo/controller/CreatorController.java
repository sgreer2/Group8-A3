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
import comp31.demo.repo.ShowRepo;
import comp31.demo.repo.UserRepo;

//Nick Best

@Controller


@SessionAttributes({"currentUser", "creatorShows", "deleteList" })

public class CreatorController {
    @Autowired ShowRepo showRepo;
    @Autowired UserRepo userRepo;

    @GetMapping("/viewCreator")
    public String viewPage(Model model)
    {
        User creator=(User)model.getAttribute("currentUser");
        List <Show> creatorShows = showRepo.findByUserId(creator.getId());
        model.addAttribute("creatorShows",creatorShows);
        return "creatorViewPage";
    }



    @PostMapping("/delete")
    public String delete(@RequestParam(value = "deleteList" , required = false) Long[] deleteList, Model model)
    {
        if (deleteList!=null)
        {
            for (int i=0; i< deleteList.length; i++) 
            {
                showRepo.deleteById(deleteList[i]);
            }
            
        }
        List<Show> shows = (List<Show>) showRepo.findAll();
        model.addAttribute("shows", shows);

        return "creatorPage";
    }

    @GetMapping("/addShow")
    public String addShow(Model model)
    {
        Show newShow= new Show();
        model.addAttribute("newShow", newShow);
        return "addShowForm";
    }

    @PostMapping("/addShow")
    public String addShow(Show show, Model model)
    {
        User user =(User)model.getAttribute("currentUser");
        show.setUserId(user.getId());
        showRepo.save(show);
        List<Show> Shows = (List<Show>) showRepo.findAll();
        model.addAttribute("Shows", Shows);
        return "creatorPage";
    }


    
}
