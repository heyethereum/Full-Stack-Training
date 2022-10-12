package com.week5assignment.week5assignment.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.week5assignment.week5assignment.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Long> {
  /*
   * @Query("select user from UserModel user ")
   * List<User> getAllUser();
   */
  @Query("SELECT user from UserModel user where email=?1 and password=?2")
  Optional<UserModel> getUserByEmailAndPassword(String email, String password);

  @Query("SELECT user from UserModel user where email = ?1")
  Optional<UserModel> getUserByEmail(String email);
}
