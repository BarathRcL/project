package com.pro.sensitivedetails.service;

import com.pro.sensitivedetails.sensitiveDto.SensitiveDto;

public interface SensitiveDetailsService {
	SensitiveDto getvalueById(int id);

	SensitiveDto updateValue(int id, SensitiveDto dto);

	SensitiveDto saveValue(SensitiveDto dto);

	void deleteValue(int id);

}
