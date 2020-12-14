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

//Nick Best

@Controller


@SessionAttributes({"currentUser", "creatorShows", "deleteList" })

public class CreatorController {
    @Autowired ShowRepo showRepo;
    @Autowired UserRepo userRepo;
    @Autowired WatchingRepo watchingRepo;

    @GetMapping("/viewCreator")
    public String viewPage(Model model)
    {
        User creator=(User)model.getAttribute("currentUser");
        List <Show> creatorShows = showRepo.findByUser(creator);
        model.addAttribute("creatorShows",creatorShows);
        return "creatorViewPage";
    }



    @PostMapping("/creatorDelete")
    public String delete(@RequestParam(value = "deleteList" , required = false) Long[] deleteList, Model model)
    {
        if (deleteList!=null)
        {
            for (int i=0; i< deleteList.length; i++) 
            {
                Show deleteShow = showRepo.findById(deleteList[i]).get();
                List <Watching> watchDelete=(List<Watching>) watchingRepo.findByShow(deleteShow);
                for (int j=0; j < watchDelete.size() ; j++)
                {
                    watchingRepo.delete(watchDelete.get(j));
                }
                showRepo.deleteById(deleteShow.getShowId());
            }
            
        }
        User creator =(User)model.getAttribute("currentUser");
        List<Show> shows = (List<Show>) showRepo.findByUser(creator);
        model.addAttribute("creatorShows", shows);
        return "creatorViewPage";
    }

    @GetMapping("/creatorAddShow")
    public String addShow(Model model)
    {
        Show newShow= new Show();
        model.addAttribute("newShow", newShow);
        return "creatorAddShow";
    }

    @PostMapping("/creatorAddShow")
    public String addShow(Show show, Model model)
    {
        User creator =(User)model.getAttribute("currentUser");
        show.setUser(creator);
        showRepo.save(show);
        List<Show> Shows = (List<Show>) showRepo.findByUser(creator);
        model.addAttribute("creatorShows", Shows);
        return "creatorViewPage";
    }


    
}
