package com.gfg.springbootbackendservice.SpringBootBackendService.repository;

import com.gfg.springbootbackendservice.SpringBootBackendService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
  User findUserById(Long id);
}
