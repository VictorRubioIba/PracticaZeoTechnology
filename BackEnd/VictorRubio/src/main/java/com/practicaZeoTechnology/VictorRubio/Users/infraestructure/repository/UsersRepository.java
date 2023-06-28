package com.practicaZeoTechnology.VictorRubio.Users.infraestructure.repository;

import com.practicaZeoTechnology.VictorRubio.Users.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<User,Long> {
}
