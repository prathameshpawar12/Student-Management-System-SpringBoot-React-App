package com.crudapplication.crudapp.service;

import java.util.List;

import com.crudapplication.crudapp.model.User;

public interface UserService {
	User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    boolean deleteUser(Long id);

    User updateUser(Long id, User user);
}
