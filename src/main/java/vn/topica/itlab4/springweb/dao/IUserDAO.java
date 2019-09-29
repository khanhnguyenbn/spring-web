package vn.topica.itlab4.springweb.dao;

import java.util.List;

import vn.topica.itlab4.springweb.model.UserModel;

public interface IUserDAO {

	void insertUser(UserModel userModel);
	
	void updateUser(UserModel userModel);
	
	void deleteUserById(int id);
	
	UserModel findUserByUserName(String userName);
	
	List<UserModel> findAllUser();
	
}
