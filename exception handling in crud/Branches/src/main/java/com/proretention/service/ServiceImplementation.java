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
import com.proretention.exception.ResourceNotFoundException;
import com.proretention.repository.BranchesRepository;

@Service
public class ServiceImplementation implements BranchesService {
	@Autowired
	BranchesRepository branchesRepository;

	@Override
	public BranchesDto createBranches(BranchesDto branchesDto) {
		try {
			if (branchesDto.getOrganizationId() == 0 || branchesDto.getBranchName().isEmpty()
					|| branchesDto.getAddress().isEmpty() || branchesDto.getCity().isEmpty()
					|| branchesDto.getCountry().isEmpty() || branchesDto.getState().isEmpty()
					|| branchesDto.getZipCode() == 0)
				throw new ResourceNotFoundException("please give proper input");
		} catch (ResourceNotFoundException e) {
			throw new ResourceNotFoundException("please give proper input");
		} catch (Exception e) {
			throw new ResourceNotFoundException("some thing wrong in service");
		}
		Branches brachesEntity = new Branches();
		BeanUtils.copyProperties(branchesDto, brachesEntity);
		String publicUserId = "hiengage" + brachesEntity.getBranchName();
		brachesEntity.setBranchKey(publicUserId);

		Branches storedBranchesDetails = branchesRepository.save(brachesEntity);

		BranchesDto get = new BranchesDto();
		BeanUtils.copyProperties(storedBranchesDetails, get);
		return get;

	}

	@Override
	public BranchesDto getByBranchKey(String branchKey) {
		try {
			BranchesDto dto = new BranchesDto();
			Branches branches = branchesRepository.getByBranchKey(branchKey);
			BeanUtils.copyProperties(branches, dto);
			return dto;
		} 

	catch (IllegalArgumentException e) {
			throw new ResourceNotFoundException(
					"given branchKey not exist");
		} catch (Exception e) {
			throw new ResourceNotFoundException(
					"Something went wrong in Service layer while fetching all employees" + e.getMessage());
		}
	}

	@Override
	public void deleteByBranchKey(String branchKey) {
	
		
			Branches branch = branchesRepository.getByBranchKey(branchKey);
			try {
				if (branch == null)
					throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				throw new ResourceNotFoundException("given branchKey doesnot exist in DB");
			} catch (Exception e) {
				throw new ResourceNotFoundException("Something went wrong in Service layer while fetching all employees");
			}
			branchesRepository.delete(branch);
		

	}

	@Override
	public BranchesDto updateBranch(String branchKey, BranchesDto userDto) {

		BranchesDto retVal = new BranchesDto();
		
			Branches exitingbranch = branchesRepository.getByBranchKey(branchKey);
			try {
				if (exitingbranch == null)
					throw new IllegalArgumentException();
			} catch (IllegalArgumentException e) {
				throw new ResourceNotFoundException("given branchKey doesnot exist in DB");
			} catch (Exception e) {
				throw new ResourceNotFoundException("Something went wrong in Service layer while fetching all employees");
			}
			exitingbranch.setOrganizationId(userDto.getOrganizationId());
			exitingbranch.setBranchName(userDto.getBranchName());
			exitingbranch.setAddress(userDto.getAddress());
			exitingbranch.setCountry(userDto.getCountry());
			exitingbranch.setCity(userDto.getCity());
			exitingbranch.setState(userDto.getState());
			exitingbranch.setZipCode(userDto.getZipCode());
			BeanUtils.copyProperties(exitingbranch, retVal);
			return retVal;

		

	}

	@Override
	public List<BranchesDto> getBranches(int page, int limit) {
		List<BranchesDto> retVal = new ArrayList<>();

		if (page > 0) {
			page = page - 1;
		}

		Pageable pageableRequest = PageRequest.of(page, limit);

		Page<Branches> branchesPage = branchesRepository.findAll(pageableRequest);

		List<Branches> users = branchesPage.getContent();

		for (Branches branchesEntity : users) {
			BranchesDto branchesdDto = new BranchesDto();
			BeanUtils.copyProperties(branchesEntity, branchesdDto);
			retVal.add(branchesdDto);
		}
		return retVal;
	}

}
