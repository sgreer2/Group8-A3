package comp31.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.demo.model.User;
import comp31.demo.model.Watching;

@Repository
public interface WatchingRepo extends CrudRepository<Watching, Integer> {
    List<Watching> findByUser(User user);
}
