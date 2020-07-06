package com.real.capstone.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.real.capstone.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
	
	Optional<Users> findByEmail(String email);
}
