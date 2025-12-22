package com.boudaa.user_service.repositories;


import com.boudaa.user_service.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Long> {

    public User findUserByUsername(String username);

}
