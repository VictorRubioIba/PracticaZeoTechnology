package com.practicaZeoTechnology.VictorRubio.Users.aplication;

import com.practicaZeoTechnology.VictorRubio.Users.domain.User;

import java.util.List;
import java.util.Optional;

public interface IUsersService {
    List<User> findAll() throws Exception;
    User addUser (User user) throws Exception;
    Boolean checkIfExistUser(User user) throws Exception;
}
