package com.practicaZeoTechnology.VictorRubio.Users.infraestructure.controller;

import com.practicaZeoTechnology.VictorRubio.Users.aplication.IUsersService;
import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping ("/front")
@AllArgsConstructor
public class UsersController {

    @Autowired
    private IUsersService iUsersService;

    @GetMapping("/users")
    public ResponseEntity findAllUsers() throws Exception {
        return new ResponseEntity(iUsersService.findAll(),HttpStatus.OK) ;
    }

    @PostMapping("/users")
    public ResponseEntity addUsers(@RequestBody User user) throws Exception{

        User userCreated;
        userCreated = iUsersService.addUser(user);
        if(userCreated.equals(user)){
            return new ResponseEntity<User>(userCreated, HttpStatus.CREATED);
        }else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("The user is not created with exit");
        }
    }
    @PostMapping("/login")
    public Boolean findUserByName(@RequestBody User user) throws Exception{

        return iUsersService.checkIfExistUser(user);

    }



}
