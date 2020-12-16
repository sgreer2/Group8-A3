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


@SessionAttributes({"currentUser", "creatorShows", "deleteList", "newShow" })

public class CreatorController {
    @Autowired ShowRepo showRepo;
    @Autowired UserRepo userRepo;
    @Autowired WatchingRepo watchingRepo;

    // sets up list of shows and forwards to creatorviewpage
    @GetMapping("/viewCreator")
    public String viewPage(Model model)
    {
        User creator=(User)model.getAttribute("currentUser");
        List <Show> creatorShows = showRepo.findByUser(creator);
        model.addAttribute("creatorShows",creatorShows);
        return "creatorViewPage";
    }


    // deletes selected shows and associated watching records
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

    // creates new show object to add a show
    @GetMapping("/creatorAddShow")
    public String addShow(Model model)
    {
        Show newShow= new Show();
        model.addAttribute("newShow", newShow);
        return "creatorAddPage";
    }

    // recieves show object to send to add show
    @PostMapping("/creatorUpdateShow")
    public String updateShow(Long showUpdate, Model model)
    {
        Show currentShow=showRepo.findByShowId(showUpdate).get(0);
        model.addAttribute("newShow", currentShow );
        return "creatorAddPage";
    }

    // post mapping for adding/updating a show
    @PostMapping("/creatorAddShow")
    public String addShow(Show newShow, Model model)
    {
        User creator =(User)model.getAttribute("currentUser");
        newShow.setUser(creator);
        newShow.setShowId(((Show)model.getAttribute("newShow")).getShowId());
        showRepo.save(newShow);
        List<Show> Shows = (List<Show>) showRepo.findByUser(creator);
        model.addAttribute("creatorShows", Shows);
        return "creatorViewPage";
    }


    
}
