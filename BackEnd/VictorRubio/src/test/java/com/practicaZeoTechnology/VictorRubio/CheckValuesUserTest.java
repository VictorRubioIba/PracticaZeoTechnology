package com.practicaZeoTechnology.VictorRubio;

import com.practicaZeoTechnology.VictorRubio.Users.aplication.UsersServiceImplement;
import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
public class CheckValuesUserTest {


    @Autowired
    UsersServiceImplement usersService;

    User actualUser;
    User emptyUser;
    @BeforeEach
    void beforeEach(){
    actualUser = new User ("Pepo",19,"pepe@hotmail.com","12345");
    emptyUser = new User ("",0,"","");
    }

    @Test
    void testCheckNameOfUser() throws Exception {

        String actualName ="Pepo";
        Assertions.assertEquals(usersService.addUser(actualUser).getName(),actualName);

    }
    @Test
    void testCheckNameOfUserException() throws Exception {


        Assertions.assertThrows(Exception.class, () -> usersService.addUser(emptyUser));
    }
    @Test
    void testCheckAgeOfUser() throws Exception {

        int actualAge = 19;
        Assertions.assertEquals(usersService.addUser(actualUser).getAge(),actualAge);

    }
    @Test
    void testCheckEmailOfUser() throws Exception {

        String actualEmail = "pepe@hotmail.com";
        Assertions.assertEquals(usersService.addUser(actualUser).getEmail(),actualEmail);

    }
    @Test
    void testCheckPasswordOfUser() throws Exception {

        String actualPassword ="12345";
        Assertions.assertTrue(BCrypt.checkpw(actualPassword,usersService.addUser(actualUser).getPassword()));


    }


}
