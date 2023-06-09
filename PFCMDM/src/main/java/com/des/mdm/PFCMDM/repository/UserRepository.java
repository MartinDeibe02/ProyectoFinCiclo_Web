package com.des.mdm.PFCMDM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.des.mdm.PFCMDM.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByNombre(String nombre);
	List<User> findByNombreContaining(String user);
}
