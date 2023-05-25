package com.bank.repo;

import com.bank.model.Phone;
import com.bank.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhoneRepo extends JpaRepository<Phone, Long> {

}
