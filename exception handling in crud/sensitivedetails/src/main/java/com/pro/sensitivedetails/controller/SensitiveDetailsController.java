package com.pro.sensitivedetails.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pro.sensitivedetails.exception.ResourceNotFoundException;
import com.pro.sensitivedetails.request.Request;
import com.pro.sensitivedetails.response.OperationStatusModel;
import com.pro.sensitivedetails.response.RequestOparationStatus;
import com.pro.sensitivedetails.response.Response;
import com.pro.sensitivedetails.sensitiveDto.SensitiveDto;
import com.pro.sensitivedetails.service.SensitiveDetailsService;

@RestController
@RequestMapping("/sensitivedetails")
public class SensitiveDetailsController {

	@Autowired
	public SensitiveDetailsService sensitiveDetailsService;

	@PostMapping("/")
	public Response saveEmail(@RequestBody Request request) {
		Response response = new Response();

		SensitiveDto dto = new SensitiveDto();

		BeanUtils.copyProperties(request, dto);
		SensitiveDto saveValue = sensitiveDetailsService.saveValue(dto);
		BeanUtils.copyProperties(saveValue, response);
		return response;
	}
	
	 @GetMapping("/{id}")
	 public Response getValueById(@PathVariable("id") int id)
	 {
		 Response response =new Response();
		
		 SensitiveDto retrive =sensitiveDetailsService.getvalueById(id);
		
		 BeanUtils.copyProperties(retrive, response);
		 return response;
		 
	 }
	 @PutMapping("/{id}")
	 public Response updateEmail(@PathVariable("id") int id,@RequestBody Request request)
	 {
		 Response response =new Response();
		 
		 SensitiveDto dto =new SensitiveDto();
		 
		BeanUtils.copyProperties(request, dto);
		
		SensitiveDto emailDto=sensitiveDetailsService.updateValue(id,dto);
		BeanUtils.copyProperties(emailDto, response);
		return response;
		 
	 }
	 @DeleteMapping("/{id}")
	 public OperationStatusModel deleteUser(@PathVariable("id") int id)
	 {
		OperationStatusModel status=new OperationStatusModel();
		status.setOperationName(RequestOparationStatus.delete.name());
		sensitiveDetailsService.deleteValue(id);
		status.setOperationResult(RequestOparationStatus.success.name());
		return status;
	 } 
	 
	
	 


}
