package com.practicaZeoTechnology.VictorRubio;

import com.practicaZeoTechnology.VictorRubio.Users.aplication.IUsersService;
import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static com.practicaZeoTechnology.VictorRubio.Dates.USER_1;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@SpringBootTest
public class ServiceTest {
    @Mock
    IUsersService service;


    @BeforeEach
    void beforeEach(){

    }

    @Test
    void testAddUser() throws Exception {

        try {
            when(service.addUser(any(User.class))).thenReturn(USER_1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User actualUser = new User("Pepa",18,"pepa@hotmail.com","123456");
        Assertions.assertEquals(service.addUser(USER_1),actualUser);

    }

    @Test
    void testAddUserException() throws Exception {

        when(service.addUser(any(User.class))).thenThrow(EntityNotFoundException.class);
        Assertions.assertThrows(EntityNotFoundException.class, () ->service.addUser(new User()));
    }

    @Test
    void testFindAllUsers() throws Exception {

        try {
            when(service.addUser(any(User.class))).thenReturn(USER_1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assertions.assertNotNull(service.findAll());
    }
    @Test
    void testFindAllException() throws Exception {

        when(service.findAll()).thenThrow(Exception.class);
        Assertions.assertThrows(Exception.class, () -> service.findAll());
    }
    @Test
    void testFindAllByName() throws Exception {

        try {
            when(service.getUserByName(any(String.class))).thenReturn(Optional.of(USER_1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name ="Pepa";

        Assertions.assertNotNull(service.getUserByName(name));
        Assertions.assertEquals(service.getUserByName(name).get(),USER_1);
    }

    @Test
    void testFindAllByNameException() throws Exception {

        try {
            when(service.getUserByName(any(String.class))).thenThrow(EntityNotFoundException.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String name ="Pepa";
        Assertions.assertThrows(EntityNotFoundException.class, () -> service.getUserByName(name));

    }
}
