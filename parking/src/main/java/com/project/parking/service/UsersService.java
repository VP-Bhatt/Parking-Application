package com.project.parking.service;

import com.project.parking.model.User;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

public interface UsersService {

    List<User> getAllUsers();

    User getUser(long id);

    void updateUser(Long id, String name, String vehicleNumber);

    void deleteUser(long id);





}
