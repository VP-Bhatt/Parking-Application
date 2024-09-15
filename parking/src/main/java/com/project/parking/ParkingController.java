package com.project.parking;

import com.project.parking.model.User;
import com.project.parking.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class ParkingController {

    private final UsersService usersService;

    @Autowired
    ParkingController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return usersService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(value = "id") Long id){
        return usersService.getUser(id);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable(value = "id")Long id, @RequestParam(name = "name") String name, @RequestParam(name = "vehicleNumber")String vehicleNumber){
        usersService.updateUser(id, name, vehicleNumber);
    }

    @PostMapping("/users/{id}")
    public void deleteUser(@PathVariable(value = "id")Long id){
        usersService.deleteUser(id);
    }
}
