package com.bank.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import com.bank.model.Phone;
import com.bank.model.User;
import com.bank.request.PhoneRequest;
import com.bank.request.UserRequest;
import com.bank.response.PhoneResponse;
import com.bank.response.UserResponse;
import com.bank.service.IPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.HttpHeaders;

import com.bank.service.IUserService;

import io.swagger.annotations.ApiParam;



@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	@Autowired
	private IUserService userService;

	@Autowired
	private IPhoneService phoneService;

	@Value("${com.bank.controller.regex}")
	public String regex;
	

	@PostMapping
	public ResponseEntity<?> registerUser(
			@ApiParam(value = "Header de autorizacion", required = true) @RequestHeader (value = "authorizationHeader", required = true) String authorizationHeader,  
			@ApiParam(value = "Request Body de Registrar Usuario", required = true) @Valid @RequestBody(required = true) UserRequest userRequest,
			@RequestHeader HttpHeaders headers) {

		//boolean isValid= true;
		//isValid = isValidPassword(userRequest.getPassword(), regex);

		if(!isValidPassword(userRequest.getPassword(), regex)){
			return new ResponseEntity<String>("El password no cumple con la expresion regular definida en el archivo properties", HttpStatus.BAD_REQUEST);
		}
		User user = new User();

		user.setName(userRequest.getName());
		user.setEmail(userRequest.getEmail());
		user.setPassword(userRequest.getPassword());

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date created = new Date();
		String formattedDateCreated = dateFormat.format(created);

		Date lastLogin = new Date();
		String formattedDateLastLogin = dateFormat.format(lastLogin);

		user.setCreated(formattedDateCreated);
		user.setLastLogin(formattedDateLastLogin);
		user.setToken(authorizationHeader);
		user.setActive(Boolean.TRUE);

		User exist =userService.existMail(user);

		if(exist == null){

		User objUser = userService.registerUser(user);

		Phone phone = null;
		Phone objPhone = new Phone();
		List<PhoneRequest> phones;
		List<Phone> listObjPhones  = new ArrayList<Phone>();

		Iterator<PhoneRequest> it = userRequest.getPhones().iterator();
		while(it.hasNext()){
			phone = new Phone();
			PhoneRequest phoneReq = it.next();
			phone.setNumber(phoneReq.getNumber());
			phone.setCityCode(phoneReq.getCityCode());
			phone.setCountryCode(phoneReq.getCountryCode());
			phone.setUserId(objUser.getUserId());
			objPhone = phoneService.registerPhones(phone);
			listObjPhones.add(objPhone);
		}

		List<PhoneResponse> listPhones = new ArrayList<PhoneResponse>();
		Iterator<Phone> iter = listObjPhones.iterator();
		while(iter.hasNext()){
			PhoneResponse phoneResponse = new PhoneResponse();
			Phone iteraPhone = iter.next();
			phoneResponse.setNumber(iteraPhone.getNumber());
			phoneResponse.setCityCode(iteraPhone.getCityCode());
			phoneResponse.setCountryCode(iteraPhone.getCountryCode());
			listPhones.add(phoneResponse);
		}

		UserResponse userResponse = new UserResponse();
		userResponse.setId(objUser.getUserId().toString());
		userResponse.setName(objUser.getName());
		userResponse.setEmail(objUser.getEmail());
		userResponse.setPassword(objUser.getPassword());
		userResponse.setPhones(listPhones);
		userResponse.setCreated(objUser.getCreated());
		userResponse.setLastLogin(objUser.getLastLogin());
		userResponse.setToken(objUser.getToken());
		userResponse.setActive(objUser.getActive());

			return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
		}else{
			return new ResponseEntity<String>("El correo ya Existe", HttpStatus.CONFLICT);
		}

	}
	public static boolean isValidPassword(String password, String regex)
	{

		// Compile the ReGex
		Pattern p = Pattern.compile(regex);

		if (password == null) {
			return false;
		}

		Matcher m = p.matcher(password);
		return m.matches();
	}
	
}
