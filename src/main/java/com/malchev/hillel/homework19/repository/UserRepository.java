package com.malchev.hillel.homework19.repository;

import org.springframework.data.repository.CrudRepository;
import com.malchev.hillel.homework19.domain.User;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,String> {
    Optional<User> findByUserName(String username);
}
