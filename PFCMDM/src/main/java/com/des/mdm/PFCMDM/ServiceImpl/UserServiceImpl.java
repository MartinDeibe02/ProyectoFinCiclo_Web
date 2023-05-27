package com.des.mdm.PFCMDM.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.des.mdm.PFCMDM.Service.UserService;
import com.des.mdm.PFCMDM.model.User;
import com.des.mdm.PFCMDM.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	UserRepository userRepository;

	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUser(String name) {
		Optional<User> opUser = Optional.ofNullable(userRepository.findByNombre(name));
		
		if(opUser.isPresent()) {
			return opUser.get();
		}
		return null;
	}
	
	
}
