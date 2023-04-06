package com.Project.RIKT.repository;

import com.Project.RIKT.entity.USER;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<USER,Integer> {

    @Query(value="Select * from USER where user_name=:username",nativeQuery = true)
    Optional<USER> findByUserName(@Param("username") String userName);
}
