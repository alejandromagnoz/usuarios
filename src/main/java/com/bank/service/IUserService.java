package com.bank.service;

import com.bank.model.User;

public interface IUserService {

	User registerUser(User user);

	User existMail(User user);

}
