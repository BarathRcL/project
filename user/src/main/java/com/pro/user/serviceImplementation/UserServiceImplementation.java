package com.pro.user.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pro.user.dto.UserDto;
import com.pro.user.entity.UserEntity;
import com.pro.user.repository.UserRepository;
import com.pro.user.service.UserService;

@Service
public class UserServiceImplementation implements UserService {
	@Autowired
	 public UserRepository userRepository;
	

	@Override
	public UserDto createUser(UserDto userDto) {
		UserEntity userEntity =new UserEntity();
		BeanUtils.copyProperties(userDto,userEntity);
		String setUser="abc"+userEntity.getFirstName();
		userEntity.setUserKey(setUser);
		UserEntity saveUser=userRepository.save(userEntity);
		UserDto retrive =new UserDto();
		BeanUtils.copyProperties(saveUser, retrive);
		return retrive;
	}

	@Override
	public UserDto getByUserKey(String userKey) {
		UserDto dto =new UserDto();
		UserEntity retrive=userRepository.getByUserKey(userKey);
		BeanUtils.copyProperties(retrive, dto);
		
		return dto;
	}

	@Override
	public UserDto updateUser(String userKey, UserDto userDetails) {
		UserDto dto =new UserDto();
	
		UserEntity userEntity =userRepository.getByUserKey(userKey);
		userEntity.setFirstName(userDetails.getFirstName());
		userEntity.setLastName(userDetails.getLastName());
		userEntity.setOrganization(userDetails.getOrganization());
		userEntity.setDesignation(userDetails.getDesignation());
	    userEntity.setDomain(userDetails.getDomain());
		UserEntity updatedUser=userRepository.save(userEntity);
		BeanUtils.copyProperties(updatedUser, dto);
		
		return dto;
	}

	@Override
	public void deleteUser(String userKey) {
		UserEntity user=userRepository.getByUserKey(userKey);
		userRepository.delete(user);
		
	}

	@Override
	public List<UserDto> getUsers(int page, int limit) {
List<UserDto> retVal = new ArrayList<>();
		
		if(page>0) {
			page = page-1;
		}
	
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<UserEntity> usersPage = userRepository.findAll(pageableRequest);
		
		List<UserEntity> users = usersPage.getContent();
		
		for(UserEntity userEntity : users) {
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(userEntity, userDto);
			retVal.add(userDto);
		}
		return retVal;
	}
	

}
