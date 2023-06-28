package com.practicaZeoTechnology.VictorRubio.Users.aplication;

import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import com.practicaZeoTechnology.VictorRubio.Users.infraestructure.repository.UsersRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

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
            return usersRepository.save(checkValuesUser(user));
        }catch ( Exception e){
           throw  new Exception((e.getMessage()));
        }

    }

    @Override
    public Boolean checkIfExistUser(User user) throws Exception {

        try {
            if(checkUserInDataBase(user)) {
                return true;
            }else{
                return false;
            }
        }catch (EntityNotFoundException e){

            throw new EntityNotFoundException(e.getMessage());
        }
    }

    private boolean checkUserInDataBase(User user){

        List<User> listUser = usersRepository.findAll();

        return  listUser
                .stream()
                .filter(elem -> elem.getName().equals(user.getName()))
                .anyMatch(elem -> BCrypt.checkpw(user.getPassword(),elem.getPassword()))
                //.filter(elem -> BCrypt.checkpw(elem.getPassword(),user.getPassword()))
                //.findFirst()
                ;

    }

    private User checkValuesUser(User user){

        User userChecked = new User();
        if(user.getName().length()>0){
            userChecked.setName(user.getName());
        }else{
            throw new RuntimeException("The value of name is not correct");
        }
        if(user.getAge()==0){
            throw new RuntimeException("The value of age is not correct");
        }else{
            userChecked.setAge(user.getAge());
        }
        if(user.getEmail().length()>0){
            userChecked.setEmail(user.getEmail());
        }else{
            throw new RuntimeException("The value of name is not correct");
        }
        if(user.getPassword().length()>0){
            userChecked.setPassword(cryptPassword(user.getPassword()));
        }else{
            throw new RuntimeException("The value of name is not correct");
        }

        return userChecked;
    }

    private String cryptPassword(String password){

       String passwordEncrypted = BCrypt.hashpw(password,BCrypt.gensalt());
        return passwordEncrypted;

    }

}
