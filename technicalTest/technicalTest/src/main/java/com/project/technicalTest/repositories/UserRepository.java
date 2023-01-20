package com.project.technicalTest.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.technicalTest.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

	public Optional<User> findByName(String userName);

}
