package com.bank.service.impl;

import com.bank.model.User;
import com.bank.repo.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserRepo repo;

	@Override
	public User registerUser(User user)  {

		User userModel = repo.save(user);
		
		return userModel;

	}

	@Override
	public User existMail(User user)  {

		User exist = repo.findOneByEmail(user.getEmail());

		return exist;

	}

}
