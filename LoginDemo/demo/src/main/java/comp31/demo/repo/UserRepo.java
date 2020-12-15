package comp31.demo.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import comp31.demo.model.User;

/**
 * UserRepo
 */
@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    List<User> findByUserName(String userName);
    List<User> findByUserRole(String userRole);
    
}