package com.jspiders.bankingapp_project.data;

import com.jspiders.bankingapp_project.entity.User;

public interface UserData {
	
	void addUser(User user);
	
	void deleteUser(long mobileNumber, int securityPin);
	
//	void deleteUser(String email, int securityPin);
	
	void updateUser(int securityPin);
	
	void findUser(int securityPin);
}
