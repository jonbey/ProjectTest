package com.project.technicalTest.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.technicalTest.repositories.UserRepository;

import com.project.technicalTest.exceptions.NotEligibleException;
import com.project.technicalTest.exceptions.RequiredFieldsException;
import com.project.technicalTest.exceptions.ResourceNotFoundException;
import com.project.technicalTest.models.User;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	/*@author Johnny El Beyrouthy
	 *@see get a user from DB by his name, a return type optional is used in this function 
	 *		which allows to throw an exception if user name entered is not registered in DB 
	 * */
	public User findByName(String userName) {		
		return userRepository.findByName(userName)
				.orElseThrow(() -> new ResourceNotFoundException("Selected user with name " +userName+ " is not found"));
	}
	
	/*@author Johnny El Beyrouthy
	 *@see save a user into the data base while respecting certains conditions, user must be from france and above 18years old
	 * 		if the requested conditions are not respected, two exceptions can be activated depending on each case.
	 * 		These exceptions are described in the following cases : 
	 * 			RequiredFieldsException : if one of the required fields,name, country, birthdate, is empty
	 * 			NotEligibleException : if the country of residence of the user is not France and his age is not greater then 18years old 
	 * */
	public User saveUser(User user){
		
		ArrayList<String> allowedCountry = new ArrayList<>();
		allowedCountry.add("france");
		
		// Check if mandatory fields are provided
		if(user != null && user.getName()!=null && !user.getName().trim().isEmpty() 
				&& Objects.nonNull(user.getBirthdate())
				&& user.getCountry()!=null && !user.getCountry().trim().isEmpty()) {
			
			// Check if the user meets the needed requirements, resident of France and age greater then 18
			if(allowedCountry.contains(user.getCountry().trim().toLowerCase())
					&& LocalDate.from(user.getBirthdate()).until(LocalDate.now(), ChronoUnit.YEARS) >= 18) {
				return userRepository.save(user);
			} 
			else {
				throw new NotEligibleException("User " + user.getName() + " is not elligible for registeration");	
			}
		} 
		else {
			
			throw new RequiredFieldsException("Missing one of the mandatory fileds Username, birthdate or country");
		}
		
	}
	
	
}
