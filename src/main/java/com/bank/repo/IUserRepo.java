package com.bank.repo;

import com.bank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends JpaRepository<User, Long> {

    //select * from user where email = ?
    @Query(value="SELECT * FROM user WHERE email=?1", nativeQuery=true)
    User findOneByEmail(String email);

}
