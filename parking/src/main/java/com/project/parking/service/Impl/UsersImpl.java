package com.project.parking.service.Impl;

import com.project.parking.model.User;
import com.project.parking.repository.ParkingRepository;
import com.project.parking.repository.UserRepository;
import com.project.parking.service.UsersService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UsersImpl implements UsersService {

    private final UserRepository userRepository;

    private final ParkingRepository parkingRepository;

    @Autowired
    UsersImpl(UserRepository userRepository, ParkingRepository parkingRepository){
        this.userRepository = userRepository;
        this.parkingRepository = parkingRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(long id) {
        return userRepository.findById(id).orElseThrow(() -> new IllegalStateException(STR."User with id: \{id} does not exist"));
    }

    @Override
    @Transactional
    public void updateUser(Long id, String name, String vehicleNumber) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalStateException(STR."User with id: \{id} does not exists"));
        if(name != null && !Objects.equals(user.getName(), name)){
            user.setName(name);
        }
        if(vehicleNumber != null && !Objects.equals(user.getVehicleNumber(), vehicleNumber)){
            user.setVehicleNumber(vehicleNumber);
        }
    }

    @Override
    public void deleteUser(long id) {
        userRepository.findById(id).orElseThrow(() -> new IllegalStateException(STR."User with id: \{id} does not exists"));
        userRepository.deleteById(id);
    }
}
