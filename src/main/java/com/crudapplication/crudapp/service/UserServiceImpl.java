package com.crudapplication.crudapp.service;
//made by prathamesh pawar
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.crudapplication.crudapp.model.User;
import com.crudapplication.crudapp.entity.UserEntity;
import com.crudapplication.crudapp.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity);
        userRepository.save(userEntity);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities
                = userRepository.findAll();

        List<User> users = userEntities
                .stream()
                .map(userEntity -> new User(
                        userEntity.getId(),
                        userEntity.getFirstname(),
                        userEntity.getLastname(),
                        userEntity.getEmail(),
                        userEntity.getDepartment()
                ))
                .collect(Collectors.toList());

        return users;
    }

    @Override
    public User getUserById(Long id) {
        UserEntity userEntity
                = userRepository.findById(id).get();
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }

    @Override
    public boolean deleteUser(Long id) {
        UserEntity user =  userRepository.findById(id).get();
        userRepository.delete(user);
        return true;
    }

    @Override
    public User updateUser(Long id, User user) {
        UserEntity userEntity =
                userRepository.findById(id).get();
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        userEntity.setDepartment(user.getDepartment());
        userRepository.save(userEntity);
        return user;
    }

}


