package com.practicaZeoTechnology.VictorRubio.Users.aplication;

import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import com.practicaZeoTechnology.VictorRubio.Users.infraestructure.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImplement implements IUsersService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> findAll() throws Exception {
        try {
            return usersRepository.findAll();
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public User addUser(User user) throws Exception {
        try {
            return usersRepository.save(user);
        }catch ( Exception e){
           throw  new Exception((e.getMessage()));
        }

    }

    @Override
    public Optional<User> getUserByName(String name) throws Exception {

        try {
            return usersRepository.findAll()
                    .stream()
                    .filter(elem -> elem.getName().equals(name))
                    .findFirst();
        }catch (EntityNotFoundException e){

            throw new EntityNotFoundException(e.getMessage());
        }
    }

}
