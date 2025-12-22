package com.boudaa.user_service.services;

import com.boudaa.user_service.bo.User;

import java.util.List;

public interface UserService {

    public User findUserByUsername(String username);

    public User findUserById(Long id);

    public User createUser(User user);

    public List<User> findAllUsers();
}
