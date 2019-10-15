package vn.topica.itlab4.springweb.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import vn.topica.itlab4.springweb.model.UserModel;

@Repository
public class UserDAO {

	
	private static List<UserModel> userList = initUserList();

	public void insert(UserModel userModel) {
		userList.add(userModel);
	}
	
	public UserModel findUserByUserName(String userName) {
		
		for (UserModel userModel : userList) {
			if(userModel.getUserName().equals(userName)) {
				return userModel;
			}
		}
		
		return null;
	}
	
	public UserModel findUserById(int id) {
		for (UserModel userModel : userList) {
			if(userModel.getId() == id) {
				return userModel;
			}
		}
		
		return null;
		
	}
	
	public static List<UserModel> initUserList(){
		List<UserModel> userList = new ArrayList<UserModel>();
		
		UserModel userModel1 = new UserModel(0, "user1", "123456", "Nguyen Ba Khanh", "khanhnguyen@gmail.com");
		userList.add(userModel1);
		
		return userList;
	}
}
