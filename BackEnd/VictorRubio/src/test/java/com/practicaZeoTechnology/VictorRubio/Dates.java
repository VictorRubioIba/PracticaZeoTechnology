package com.practicaZeoTechnology.VictorRubio;

import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.Arrays;
import java.util.List;

public class Dates {

 public final static List<User> USERS = Arrays.asList(new User("Pepa",18,"pepa@hotmail.com", BCrypt.hashpw("12345",BCrypt.gensalt())),
                                     new User("Pepe",19,"pepe@hotmail.com",BCrypt.hashpw("12345",BCrypt.gensalt())),
                                     new User("Pepi",20,"pepi@hotmail.com",BCrypt.hashpw("12345",BCrypt.gensalt())),
                                     new User("Pepo",21,"pepo@hotmail.com",BCrypt.hashpw("12345",BCrypt.gensalt())),
                                     new User("",0,"",""));
}

