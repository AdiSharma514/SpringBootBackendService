package com.gfg.springbootbackendservice.SpringBootBackendService.service;

import com.gfg.springbootbackendservice.SpringBootBackendService.model.User;
import com.gfg.springbootbackendservice.SpringBootBackendService.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserDaoService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAllUsers(){
        List<User> users=userRepository.findAll();
        return users;
    }
    public User findUserById(Long id){
        Optional<User> userOptional =userRepository.findById(id);
        if(userOptional.isPresent()){
            log.debug("User with id:{} is {}",id,userOptional.get());
        }else{
            throw new IllegalIdentifierException("Id is not found");
        }
        return userOptional.get();

    }
    public User createUser(User user){
        userRepository.save(user);
        return user;
    }
    public User updateUser(User user){
        Optional<User> userOptional =userRepository.findById(user.getId());
        if(userOptional.isPresent()){
            userRepository.save(user);
            return userOptional.get();
        }else {
            throw new IllegalIdentifierException("User is not found");
        }
    }
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
