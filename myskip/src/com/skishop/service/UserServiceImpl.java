package com.skishop.service;
import java.util.List;

import com.skishop.entity.User;
import com.skishop.dao.user.UserDaoImpl;

public class UserServiceImpl {
	public int regist(User u){
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		return userDaoImpl.saveUser(u);
	}
	
	
	
	public List<User> listFriends(int qqNum){
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		return userDaoImpl.findFriendByQqNum(qqNum);
	}
	
	public User listByQqNum(int qqNum){
		UserDaoImpl userDaoImpl=new UserDaoImpl();
		return userDaoImpl.getUser(qqNum);
	}
	
}

