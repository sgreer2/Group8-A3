package comp31.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.demo.model.Show;
import comp31.demo.model.User;

//Nick Best

@Repository
public interface ShowRepo extends CrudRepository <Show, Long> {
    public List<Show> findAll();
    public List<Show> findByShowId(Long showId);
    //Show Repo goes here
    public List<Show> findByUser(User creator);
    public List<Show> findByShowTitle(String showTitle);
    
}
