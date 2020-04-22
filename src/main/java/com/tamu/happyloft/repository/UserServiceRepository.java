package com.tamu.happyloft.repository;

import com.tamu.happyloft.model.UserServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by arshi on 4/22/2020.
 */
@Repository
public interface UserServiceRepository extends JpaRepository<UserServices, Integer> {
}
