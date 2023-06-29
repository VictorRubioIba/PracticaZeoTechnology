package com.practicaZeoTechnology.VictorRubio;


import com.practicaZeoTechnology.VictorRubio.Users.aplication.UsersServiceImplement;
import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import com.practicaZeoTechnology.VictorRubio.Users.infraestructure.repository.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class VictorRubioApplicationTests {

    @Mock
    UsersRepository usersRepository;

    @InjectMocks
    UsersServiceImplement iUsersService;


    Dates dates;
    User newUser;

    @BeforeEach
    void beforeEach(){
       newUser = new User ("Pepo",19,"pepe@hotmail.com",BCrypt.hashpw("12345",BCrypt.gensalt()));
    }

    @Test
    void testFindAllUsers() throws Exception {

        when(usersRepository.findAll()).thenReturn(Dates.USERS);
        List<User> actualListUsers = Dates.USERS;
        Assertions.assertEquals(iUsersService.findAll(),actualListUsers);

    }


    @Test
    void testCheckIfUserExist() throws Exception {

        when(usersRepository.findAll()).thenReturn(Dates.USERS);
        User actualUser = new User("Pepe",19,"pepe@hotmail.com","12345");
        Assertions.assertEquals(iUsersService.checkIfExistUser(actualUser),true);

    }

    @Test
    void testEmptyList() throws Exception {

        when(usersRepository.findAll()).thenReturn(Collections.EMPTY_LIST);
        Assertions.assertTrue(iUsersService.findAll().isEmpty());
    }


}
