package com.seeth.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seeth.models.User;

public interface UserRespository extends JpaRepository<User, Integer> {

	Optional<User> findByName(String username);

}
