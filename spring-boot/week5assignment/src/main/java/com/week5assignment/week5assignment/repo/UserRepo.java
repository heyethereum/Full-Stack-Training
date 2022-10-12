package com.week5assignment.week5assignment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.week5assignment.week5assignment.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
