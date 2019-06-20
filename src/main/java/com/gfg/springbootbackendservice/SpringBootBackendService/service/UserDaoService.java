package com.gfg.springbootbackendservice.SpringBootBackendService.service;

import com.gfg.springbootbackendservice.SpringBootBackendService.model.User;
import com.gfg.springbootbackendservice.SpringBootBackendService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDaoService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers(){
        List<User> users=userRepository.findAll();
        return users;
    }
    public User findUserById(Long id){
        User user=userRepository.findUserById(id);
        return user;
    }
    public User createUser(User user){
        userRepository.save(user);
        return userRepository.findUserById(user.getId());
    }
    public User updateUser(User user){
        userRepository.save(user);
        return userRepository.findUserById(user.getId());
    }
    public void deleteUser(Long id){
        User user=userRepository.findUserById(id);
        userRepository.delete(user);
    }
}
