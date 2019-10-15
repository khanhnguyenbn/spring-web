package vn.topica.itlab4.springweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.topica.itlab4.springweb.dao.IUserDAO;
import vn.topica.itlab4.springweb.dao.UserDAOImpl;
import vn.topica.itlab4.springweb.model.UserModel;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private IUserDAO userDAO;
	
	
	public UserModel findUserByUserName(String userName) {
		return userDAO.findUserByUserName(userName);
	}
	
	public void insertUser(UserModel userModel) {
		userDAO.insertUser(userModel);
	}
	
	

}
