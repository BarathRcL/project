package com.pro.sensitivedetails.serviceimplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pro.sensitivedetails.entity.SensitiveEntity;
import com.pro.sensitivedetails.exception.ResourceNotFoundException;
import com.pro.sensitivedetails.repository.SensitiveDetailsRepository;
import com.pro.sensitivedetails.sensitiveDto.SensitiveDto;
import com.pro.sensitivedetails.service.SensitiveDetailsService;

@Service
public class SensitiveDetailsServiceImplementation implements SensitiveDetailsService {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	public SensitiveDetailsRepository sensitiveDetailsRepository;

	@Override
	public SensitiveDto saveValue(SensitiveDto dto) {

		try {
			if (dto.getUserId() == 0 || dto.getValue().isEmpty() || dto.getName().isEmpty())
				throw new ResourceNotFoundException("please give proper input");
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("please give proper input");
		} catch (Exception e) {
			throw new ResourceNotFoundException("something wrong ");
		}
		SensitiveEntity entity = new SensitiveEntity();
		SensitiveDto sensitiveDto = new SensitiveDto();
		BeanUtils.copyProperties(dto, entity);
		String encodedValue = passwordEncoder.encode(dto.getValue());
		entity.setValue(encodedValue);

		SensitiveEntity saveEntity = sensitiveDetailsRepository.save(entity);
		BeanUtils.copyProperties(saveEntity, sensitiveDto);
	
		return sensitiveDto;

	}

	@Override
	public SensitiveDto getvalueById(int id) {
		SensitiveDto dto = new SensitiveDto();
		try {
			SensitiveEntity entity = sensitiveDetailsRepository.getById(id);
			BeanUtils.copyProperties(entity, dto);
			return dto;
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(
					"given  userKey is not exist, please send some id to be searched" + e.getMessage());
		} catch (Exception e) {
			throw new ResourceNotFoundException(
					"Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}

	}

	@Override
	public SensitiveDto updateValue(int id, SensitiveDto dto) {
		SensitiveEntity entity = sensitiveDetailsRepository.getById(id);
		try {
			if (entity == null)
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException("given userKey doesnot exist in DB");
		} catch (Exception e) {
			throw new ResourceNotFoundException("Something went wrong in Service layer while fetching all employees");
		}
		entity.setValue(dto.getValue());
		SensitiveEntity sensitiveEntity = sensitiveDetailsRepository.save(entity);
		SensitiveDto esensitiveDto = new SensitiveDto();
		BeanUtils.copyProperties(sensitiveEntity, esensitiveDto);
		return esensitiveDto;
	}

	@Override
	public void deleteValue(int id) {

		SensitiveEntity entity = sensitiveDetailsRepository.getById(id);
		try {
			if (entity == null)
				throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException("given userKey doesnot exist in DB");
		} catch (Exception e) {
			throw new ResourceNotFoundException(
					"Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
		sensitiveDetailsRepository.delete(entity);

	}
}
