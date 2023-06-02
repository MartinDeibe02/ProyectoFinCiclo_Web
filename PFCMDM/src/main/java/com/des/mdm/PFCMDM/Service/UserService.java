package com.des.mdm.PFCMDM.Service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.des.mdm.PFCMDM.model.User;

public interface UserService {
	void saveUser(User user);
	List<User> findUsers();
	User findUser(String name);
	User findById(int id);
	long countUsers();
	List<User> findUserContaining(String example);

}
