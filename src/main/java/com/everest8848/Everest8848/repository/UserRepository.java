package com.everest8848.Everest8848.repository;

import com.everest8848.Everest8848.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select e from User e where e.firstName=?1")
    public User getUserByUserName(String firstName);

    @Query("select j from User j where  j.email =?1")
    public User getUserByEmail(String email);



}
