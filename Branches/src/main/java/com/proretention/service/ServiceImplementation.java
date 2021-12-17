package com.proretention.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.proretention.dto.BranchesDto;
import com.proretention.entity.Branches;
import com.proretention.repository.BranchesRepository;

@Service
public class ServiceImplementation implements BranchesService{
	@Autowired
	BranchesRepository branchesRepository;

	@Override
	public BranchesDto createBranches(BranchesDto branchesDto) {
            Branches brachesEntity=new Branches();
            BeanUtils.copyProperties(branchesDto, brachesEntity);
            String publicUserId= "hiengage"+brachesEntity.getBranchName();
            brachesEntity.setBranchKey(publicUserId);
            

            Branches storedBranchesDetails = branchesRepository.save(brachesEntity);
    		
            BranchesDto get = new BranchesDto();
    		BeanUtils.copyProperties(storedBranchesDetails, get);
		return get;
	}

	@Override
	public BranchesDto getByBranchKey(String branchKey) {
		
		BranchesDto dto =new BranchesDto();
		Branches branches=branchesRepository.getByBranchKey(branchKey);
		BeanUtils.copyProperties(branches, dto);
		return  dto;
	}

	@Override
	public void deleteByBranchKey( String branchKey) {
		// TODO Auto-generated method stub
		Branches branch = branchesRepository.getByBranchKey(branchKey);
		branchesRepository.delete(branch);
		
	}

	@Override
	public BranchesDto updateBranch(String branchKey,BranchesDto userDto) {
		
		BranchesDto retVal = new BranchesDto();
		Branches Exitingbranch =  branchesRepository.getByBranchKey(branchKey);
		Exitingbranch.setOrganizationId(userDto.getOrganizationId());
		Exitingbranch.setBranchName(userDto.getBranchName());
		Exitingbranch.setAddress(userDto.getAddress());
		Exitingbranch.setCountry(userDto.getCountry());		
		Exitingbranch.setCity(userDto.getCity());
		Exitingbranch.setState(userDto.getState());
		Exitingbranch.setZipCode(userDto.getZipCode());
		BeanUtils.copyProperties(Exitingbranch, retVal);
	        return retVal;
	
	}

	@Override
	public List<BranchesDto> getBranches(int page, int limit) {
List<BranchesDto> retVal = new ArrayList<>();
		
		if(page>0) {
			page = page-1;
		}
	
		Pageable pageableRequest = PageRequest.of(page, limit);
		
		Page<Branches> branchesPage = branchesRepository.findAll(pageableRequest);
		
		List<Branches> users = branchesPage.getContent();
		
		for(Branches branchesEntity : users) {
			BranchesDto branchesdDto = new BranchesDto();
			BeanUtils.copyProperties(branchesEntity, branchesdDto);
			retVal.add(branchesdDto);
		}
		return retVal;
	}

	
}
