package vn.topica.itlab4.springweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.topica.itlab4.springweb.dao.UserDAO;
import vn.topica.itlab4.springweb.model.UserModel;

@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	
	
	public UserModel findUserByUserName(String userName) {
		return userDAO.findUserByUserName(userName);
	}
	
	public void insert(UserModel userModel) {
		userDAO.insert(userModel);
	}
	
	

}
