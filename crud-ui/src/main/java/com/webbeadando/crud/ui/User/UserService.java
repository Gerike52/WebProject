package com.webbeadando.crud.ui.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired private UserRepository repo;

    public List<User> listAll(){
        return (List<User>) repo.findAll();
    }

    public void save(User user){
        repo.save(user);
    }

    public User get(Integer id) throws UserNotFoundException {
        Optional<User> resalt=repo.findById(id);
        if (resalt.isPresent()){
            return resalt.get();
        }

        throw new UserNotFoundException("Nem található ilyen ID");
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if(count == null || count == 0){
            throw new UserNotFoundException("Nem található ilyen ID");
        }
        repo.deleteById(id);
    }

}
