package com.bank.service.impl;

import com.bank.model.Phone;
import com.bank.repo.IPhoneRepo;
import com.bank.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements IPhoneService {

	@Autowired
	private IPhoneRepo repo;

	@Override
	public Phone registerPhones(Phone phone)  {

		Phone phoneModel = repo.save(phone);

		return phoneModel;

	}

}
