package com.pro.sensitivedetails.serviceimplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.pro.sensitivedetails.entity.SensitiveEntity;
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
		SensitiveEntity entity = new SensitiveEntity();
		SensitiveDto sensitiveDto = new SensitiveDto();
		BeanUtils.copyProperties(dto, entity);
		String encodedValue =passwordEncoder.encode(dto.getValue());
		entity.setValue(encodedValue);
		SensitiveEntity saveEntity = sensitiveDetailsRepository.save(entity);
		BeanUtils.copyProperties(saveEntity, sensitiveDto);
		return sensitiveDto;
	}

	@Override
	public SensitiveDto getvalueById(int id) {
		SensitiveDto dto = new SensitiveDto();
		SensitiveEntity entity = sensitiveDetailsRepository.getById(id);
		BeanUtils.copyProperties(entity, dto);
		return dto;
	}

	@Override
	public SensitiveDto updateValue(int id, SensitiveDto dto) {
		SensitiveEntity entity = sensitiveDetailsRepository.getById(id);
		entity.setValue(dto.getValue());
		SensitiveEntity sensitiveEntity = sensitiveDetailsRepository.save(entity);
		SensitiveDto esensitiveDto = new SensitiveDto();
		BeanUtils.copyProperties(sensitiveEntity, esensitiveDto);
		return esensitiveDto;
	}

	@Override
	public void deleteValue(int id) {
	    SensitiveEntity entity=sensitiveDetailsRepository.getById(id);
	    sensitiveDetailsRepository .delete(entity);
		
	}
}
