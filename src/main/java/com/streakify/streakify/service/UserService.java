package com.streakify.streakify.service;

import com.streakify.streakify.entity.User;

public interface UserService {
    User createUser(User user);
    User getUserById(Long id);
    void deleteUser(Long id);
}