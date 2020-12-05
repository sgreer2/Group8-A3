package comp31.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import comp31.demo.model.User;
import comp31.demo.repo.UserRepo;

@Service
public class LoginService {

    @Autowired UserRepo userRepo;

	public User validate(String userName) {

        User validUser = null;
        List<User> users = userRepo.findByUserName(userName);
        if (users.size() == 1) {
            validUser =  users.get(0);
        }
        return validUser;
	}
    
}
