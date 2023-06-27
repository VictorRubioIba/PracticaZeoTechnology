package com.practicaZeoTechnology.VictorRubio;

import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import com.practicaZeoTechnology.VictorRubio.Users.infraestructure.controller.UsersController;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static com.practicaZeoTechnology.VictorRubio.Dates.USER_1;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ControllerTest {

    @Mock
    UsersController usersController;

    @BeforeEach
    void beforeEach(){

    }

    @Test
    void testAddUsers() throws Exception {

        try {
            when(usersController.addUsers(any(User.class))).thenReturn(ResponseEntity.ok(USER_1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        ResponseEntity actualUser = new ResponseEntity( new User("Pepa",18,"pepa@hotmail.com","123456"),HttpStatus.OK);
        Assertions.assertEquals(usersController.addUsers(USER_1),actualUser);

    }

    @Test
    void testAddUserException() throws Exception {

        when(usersController.addUsers(any(User.class))).thenThrow(EntityNotFoundException.class);
        Assertions.assertThrows(EntityNotFoundException.class, () ->usersController.addUsers(new User()));
    }

    @Test
    void testFindAllUsers() throws Exception {

        try {
            when(usersController.findAllUsers()).thenReturn(ResponseEntity.ok(USER_1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertNotNull(usersController.findAllUsers());
    }


    @Test
    void testFindAllException() throws Exception {

        when(usersController.findAllUsers()).thenThrow(Exception.class);
        Assertions.assertThrows(Exception.class, () -> usersController.findAllUsers());
    }


    @Test
    void testFindAllByName() throws Exception {

        try {
            when(usersController.findUserByName(any(String.class))).thenReturn(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name ="Pepa";
        ResponseEntity actualUser = new ResponseEntity( new User("Pepa",18,"pepa@hotmail.com","123456"),HttpStatus.OK);

        Assertions.assertNotNull(usersController.findUserByName(name));
        Assertions.assertEquals(usersController.findUserByName(name),actualUser);
    }

    @Test
    void testFindAllByNameException() throws Exception {

        try {
            when(usersController.findUserByName(any(String.class))).thenThrow(EntityNotFoundException.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name ="Pepa";
        Assertions.assertThrows(EntityNotFoundException.class, () -> usersController.findUserByName(name));

    }


}
