package com.pro.user.service;

import java.util.List;

import com.pro.user.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);

	UserDto getByUserKey(String userKey);

	UserDto updateUser(String userKey, UserDto dto);

	void deleteUser(String userKey);

	List<UserDto> getUsers(int page, int limit);

}
