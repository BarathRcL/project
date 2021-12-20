package com.pro.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity getByUserKey(String userKey);

	

}
