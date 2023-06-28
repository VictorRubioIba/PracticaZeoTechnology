package com.practicaZeoTechnology.VictorRubio;

import com.practicaZeoTechnology.VictorRubio.Users.aplication.UsersServiceImplement;
import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import static com.practicaZeoTechnology.VictorRubio.Dates.USER_1;
import static com.practicaZeoTechnology.VictorRubio.Dates.USER_5;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class testCheckValuesUser {

    @Mock
    UsersServiceImplement usersService;
    @BeforeEach
    void beforeEach(){

    }

    @Test
    void testCheckNameOfUser() throws Exception {
        try {
            when(usersService.addUser(any(User.class))).thenReturn(USER_1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String actualName ="Pepa";
        Assertions.assertEquals(usersService.addUser(USER_1).getName(),actualName);

    }
    @Test
    void testCheckNameOfUserException() throws Exception {

        when(usersService.addUser(USER_5)).thenThrow(RuntimeException.class);
        Assertions.assertThrows(Exception.class, () -> usersService.addUser(USER_5));
    }
    @Test
    void testCheckAgeOfUser() throws Exception {
        try {
            when(usersService.addUser(any(User.class))).thenReturn(USER_1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int actualAge = 18;
        Assertions.assertEquals(usersService.addUser(USER_1).getAge(),actualAge);

    }
    @Test
    void testCheckEmailOfUser() throws Exception {
        try {
            when(usersService.addUser(any(User.class))).thenReturn(USER_1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String actualEmail = "pepa@hotmail.com";
        Assertions.assertEquals(usersService.addUser(USER_1).getEmail(),actualEmail);

    }
    @Test
    void testCheckPasswordOfUser() throws Exception {
        try {
            when(usersService.addUser(any(User.class))).thenReturn(USER_1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String actualPassword = "123456";
        Assertions.assertEquals(usersService.addUser(USER_1).getPassword(),actualPassword);

    }


}
