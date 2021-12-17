package com.pro.user.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.pro.user.dto.UserDto;
import com.pro.user.request.UserRequest;
import com.pro.user.response.OperationStatusModel;
import com.pro.user.response.RequestOparationStatus;
import com.pro.user.response.UserResponse;
import com.pro.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@PostMapping("/")
	public UserResponse createUser(@RequestBody UserRequest userdetails)
	{
		UserResponse response = new UserResponse();
		UserDto userDto=new UserDto();
		BeanUtils.copyProperties(userdetails,userDto);
		
		UserDto saveUserDto= userService.createUser(userDto);
		 
		BeanUtils.copyProperties(saveUserDto, response);
		return response;
	}
	
	@GetMapping("/{id}")
	public UserResponse getUser(@PathVariable("id") String userKey)
	{
		UserResponse response =new UserResponse();
		UserDto retrive =userService.getByUserKey(userKey);
		BeanUtils.copyProperties(retrive, response);
		return response;
	}
	
	@PutMapping("/{id}")
   public UserResponse updateUser(@PathVariable("id") String userKey,@RequestBody UserRequest userDetails)
   {
	   UserResponse response =new UserResponse();
	   UserDto dto =new UserDto();
	   BeanUtils.copyProperties(userDetails, dto);
	   UserDto userDto=userService.updateUser(userKey,dto);
	   BeanUtils.copyProperties(userDto, response);
	   return response;
   }
	
	@DeleteMapping("/{id}")
	 public OperationStatusModel deleteUser(@PathVariable("id") String userKey)
	 {
		OperationStatusModel status=new OperationStatusModel();
		status.setOperationName(RequestOparationStatus.delete.name());
		userService.deleteUser(userKey);
		status.setOperationResult(RequestOparationStatus.success.name());
		return status;
		
	 }
	
	@GetMapping()
	public List<UserResponse> getUsers(@RequestParam(value="page", defaultValue="1") int page, @RequestParam(value="limit", defaultValue="25") int limit) {
		List<UserResponse> retVal = new ArrayList<>();
		List<UserDto> users = userService.getUsers(page,limit);
		
		for(UserDto userDto : users ) {
			UserResponse userModel = new UserResponse();
			BeanUtils.copyProperties(userDto, userModel);
			retVal.add(userModel);
		}
		return retVal;
		

}
}
