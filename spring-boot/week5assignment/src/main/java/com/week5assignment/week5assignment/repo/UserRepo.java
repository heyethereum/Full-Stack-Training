package com.week5assignment.week5assignment.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.week5assignment.week5assignment.model.UserModel;

@Repository
public interface UserRepo extends JpaRepository<UserModel, Long> {
  /*
   * @Query("select user from UserModel user ")
   * List<User> getAllUser();
   */
  @Query("SELECT user from UserModel user where email=?1 and password=?2")
  Optional<UserModel> getUserByEmailAndPassword(String email, String password);

  @Query("SELECT user from UserModel user where email = ?1")
  Optional<UserModel> getUserByEmail(String email);

  @Modifying
  @Transactional
  @Query("UPDATE UserModel set token=?1 WHERE id=?2")
  Integer updateTokenForUserId(String token, Long userId);
}
