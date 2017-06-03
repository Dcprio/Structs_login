package com.binbin.structs;

public class UserManager {
	public void login(String username, String password) {
		if (!"123".equals(username)) {
			throw new UserNotFoundException();
		}

		if (!"123".equals(password)) {
			throw new PasswordErrorException();
		}
	}
}
