package com.tamu.happyloft.repository;

import com.tamu.happyloft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by arshi on 3/17/2020.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmail(String email);
}