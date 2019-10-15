package vn.topica.itlab4.springweb.services;

import vn.topica.itlab4.springweb.model.UserModel;

public interface IUserService {
	
	UserModel findUserByUserName(String userName);
	
	void insertUser(UserModel userModel);
	
}
